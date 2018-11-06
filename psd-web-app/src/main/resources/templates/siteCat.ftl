<div class="site-category">
    <ul id="J_categoryList" class="site-category-list clearfix">
        [@item_show index=true limit=6]
            [#list root_cat_item as cat_item_split_list]
                <li class="category-item"><a class="title" href="https://www.mi.com/p/1915.html"
                                             data-stat-id="6f5c93b4d1baf5e9"
                                             onclick="_msq.push([&#39;trackEvent&#39;, &#39;81190ccc4d52f577-6f5c93b4d1baf5e9&#39;, &#39;//www.mi.com/p/1915.html&#39;, &#39;pcpid&#39;, &#39;&#39;]);">[=cat_item_split_list[0].name]
                    [=cat_item_split_list[1].name] <i class="iconfont"></i></a>
                    <div class="children clearfix children-col-4">
                        <ul class="children-list children-list-col children-list-col-1">
                            [#if (cat_item_split_list[0].items)??]
                                [#list cat_item_split_list[0].items as item]
                                    <li><a class="link" href="https://www.mi.com/mix3/"
                                           data-stat-id="47da862014d3df03"
                                           onclick="_msq.push([&#39;trackEvent&#39;, &#39;81190ccc4d52f577-47da862014d3df03&#39;, &#39;https://www.mi.com/mix3/&#39;, &#39;pcpid&#39;, &#39;&#39;]);"><img
                                            class="thumb"
                                            src="/img/placeholder-40.png"
                                            data-src="//i1.mifile.cn/f/i/g/2015/cn-index/mix3-80.png?width=80&amp;height=80"
                                            width="40" height="40" alt=""><span class="text">[=item.name]</span></a>
                                    </li>
                                [/#list]
                            [/#if]
                        </ul>
                    </div>
                </li>
            [/#list]
        [/@item_show]
    </ul>
</div>
