package com.yoke.poseidon.web.directives;

import freemarker.template.TemplateModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/10/18 下午8:16
 */
public class ItemTestList implements TemplateModel {
    private List<Integer> list;

    ItemTestList() {
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
