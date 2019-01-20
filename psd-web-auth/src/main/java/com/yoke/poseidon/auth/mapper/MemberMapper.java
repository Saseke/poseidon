package com.yoke.poseidon.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoke.poseidon.auth.cache.RedisCache;
import com.yoke.poseidon.auth.entity.Member;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.NonNull;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author yoke
 * @since 2018-11-25
 */
@CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)
public interface MemberMapper extends BaseMapper<Member> {

	Member selectByUsername(@NonNull @Param("username") String username);

}
