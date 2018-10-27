package com.yoke.poseidon.web.directives;

import com.yoke.poseidon.web.dto.ItemCatDto;
import com.yoke.poseidon.web.dto.ItemDto;
import com.yoke.poseidon.web.service.ItemService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 该标签根据商品分类名,得到指定limit数量的商品
 *
 * @Author Yoke
 * @Date 2018/10/17 下午7:55
 */
@Component
public class ItemDirective implements TemplateDirectiveModel {

    @Autowired
    private ItemService itemService;
    private static final String LIMIT = "limit";
    private static final String ITEM_CAT_NAME = "item_cat_name";
    private static final String REMARK = "remark";

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        if (!params.containsKey(LIMIT) || (!params.containsKey(ITEM_CAT_NAME) && !params.containsKey(REMARK))) {
            throw new TemplateModelException("There miss params");
        }

        DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        if (params.containsKey(ITEM_CAT_NAME)) {
            List<ItemDto> list = itemService.findItemCatWithItems(params.get(ITEM_CAT_NAME).toString(),
                    Integer.valueOf(params.get(LIMIT).toString()));
            env.setVariable("item_cat_item_list", builder.build().wrap(list));
            body.render(env.getOut());
        } else if (params.containsKey(REMARK)) {
            List<ItemCatDto> ret = itemService.getByCatRemark(params.get(REMARK).toString(),
                    Integer.valueOf(params.get(LIMIT).toString()));
            env.setVariable("nav_cat_item", builder.build().wrap(ret));
            body.render(env.getOut());
        }
    }
}
