package com.yoke.poseidon.web.config;

import com.yoke.poseidon.web.directives.ItemCatDirective;
import com.yoke.poseidon.web.directives.ItemDirective;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author Yoke
 * @Date 2018/10/17 下午8:03
 */
@Component
public class FreemarkerConfig {
    @Autowired
    private Configuration configuration;
    @Autowired
    private ItemDirective itemDirective;
    @Autowired
    private ItemCatDirective itemCatDirective;

    @PostConstruct
    public void setSharedVariable() {
//        开启方括号标签
        configuration.setTagSyntax(Configuration.SQUARE_BRACKET_TAG_SYNTAX);
//        修改插值语法
        configuration.setInterpolationSyntax(Configuration.SQUARE_BRACKET_INTERPOLATION_SYNTAX);
//        设置共享变量
//        configuration.setSharedVariable();
        configuration.setWrapUncheckedExceptions(true);
        configuration.setSharedVariable("item_show", itemDirective);
        configuration.setSharedVariable("item_cat_show", itemCatDirective);
    }
}
