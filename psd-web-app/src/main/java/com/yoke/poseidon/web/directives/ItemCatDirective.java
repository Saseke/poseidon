package com.yoke.poseidon.web.directives;

import com.yoke.poseidon.web.dto.ItemCatDto;
import com.yoke.poseidon.web.service.ItemCatService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 该标签参数: limit : 指定返回的条数
 * @Author Yoke
 * @Date 2018/10/17 下午10:25
 */
@Component
public class ItemCatDirective implements TemplateDirectiveModel {
    @Autowired
    private ItemCatService itemCatService;
    private static final String LIMIT = "limit";

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        if (!params.containsKey(LIMIT) || params.get(LIMIT) == null) {
            throw new TemplateModelException("This is miss limit param");
        }
        List<ItemCatDto> itemCatDtos = itemCatService.listCatBySortOrder(Integer.valueOf(params.get(LIMIT).toString()));
        DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        env.setVariable("item_cat_list", builder.build().wrap(itemCatDtos));
        body.render(env.getOut());
    }
}
