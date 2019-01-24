package com.yoke.poseidon.gateway.config;

import com.yoke.poseidon.gateway.filter.JwtTokenAuthenticationFilter;
import com.yoke.poseidon.gateway.router.Router;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Yoke
 * @Date 2018/11/24 下午8:16
 */
@EnableWebSecurity
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtConfig jwtConfig;

	@Autowired
	private Router router;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().and()
				// make sure we use stateless session; session won't be used to store
				// user's state.
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				// handle an authorized attempts
				.exceptionHandling()
				.authenticationEntryPoint((req, rsp, e) -> rsp
						.sendError(HttpServletResponse.SC_UNAUTHORIZED))
				.and()
				// Add a filter to validate the tokens with every request
				.addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig),
						UsernamePasswordAuthenticationFilter.class)
				// authorization requests config
				.authorizeRequests().requestMatchers(CorsUtils::isCorsRequest).permitAll()
				.antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()
				.antMatchers(HttpMethod.GET, router.getWeb_shop_cart_service(),
						router.getWeb_view_service(), router.getMember_service())
				.permitAll()
				// required here)
				// .antMatchers("/view" + "/admin/**").hasRole("")
				// Any other request must be authenticated
				.anyRequest().authenticated();
	}

	@Bean
	public JwtConfig jwtConfig() {
		return new JwtConfig();
	}

	@Bean
	public Router router() {
		return new Router();
	}

}
