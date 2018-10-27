[@item_show remark="nav" limit=6]
    [#list nav_cat_item as nav_cat_item]
    <li class="nav-item">
        <a class="link" href="javascript: void(0);" data-stat-id="69baf6920236bfcb"><span
                class="text">[=nav_cat_item.name]</span><span class="arrow"></span></a>
        <div class="item-children">
            <div class="container">
                <ul class="children-list clearfix">
                    [#assign count=1]
                    [#list nav_cat_item.items as item]
                        [#if count==1]
                        <li class="first">
                            <div class="figure figure-thumb">
                                <a href="https://www.mi.com/mix3/" data-stat-id="7534b5f810118349"
                                   onclick="_msq.push([&#39;trackEvent&#39;, &#39;81190ccc4d52f577-7534b5f810118349&#39;, &#39;https://www.mi.com/mix3/&#39;, &#39;pcpid&#39;, &#39;&#39;]);"><img
                                        src="/img/placeholder-220!110x110.png"
                                        data-src="[=item.image]" alt="[=item.name]"
                                        width="160" height="110"></a>
                            </div>
                            <div class="title"><a href="https://www.mi.com/mix3/"
                                                  data-stat-id="8ac9878ca7561df3"
                                                  onclick="_msq.push([&#39;trackEvent&#39;, &#39;81190ccc4d52f577-8ac9878ca7561df3&#39;, &#39;https://www.mi.com/mix3/&#39;, &#39;pcpid&#39;, &#39;&#39;]);">
                                [=item.name]</a></div>
                            <p class="price">[=item.price]元起</p>
                            [#if item.remark='新品']
                            <div class="flags">
                                <div class="flag">新品</div>
                            </div>
                            [/#if]
                        </li>
                        [#else]
                        <li>
                            <div class="figure figure-thumb">
                                <a href="https://www.mi.com/mi8youth/" data-stat-id="8e888d929618c349"
                                   onclick="_msq.push([&#39;trackEvent&#39;, &#39;81190ccc4d52f577-8e888d929618c349&#39;, &#39;https://www.mi.com/mi8youth/&#39;, &#39;pcpid&#39;, &#39;&#39;]);"><img
                                        src="/img/placeholder-220!110x110.png"
                                        data-src="[=item.image]"
                                        alt="[=item.name]" width="160" height="110"></a>
                            </div>
                            <div class="title"><a href="https://www.mi.com/mi8youth/"
                                                  data-stat-id="cb599fe6b8c9f764"
                                                  onclick="_msq.push([&#39;trackEvent&#39;, &#39;81190ccc4d52f577-cb599fe6b8c9f764&#39;, &#39;https://www.mi.com/mi8youth/&#39;, &#39;pcpid&#39;, &#39;&#39;]);">
                                [=item.name]</a></div>
                            <p class="price">[=item.price]元起</p>
                            [#if item.remark=="新品"]
                            <div class="flags">
                                <div class="flag">新品</div>
                            </div>
                            [/#if]
                        </li>
                        [/#if]
                    [/#list]
                </ul>
            </div>
        </div>
    </li>
    [/#list]
[/@item_show]
