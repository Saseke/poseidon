<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>小米商城</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<!-- start header -->
<header>
    <div class="top center">
        <div class="left fl">
            <ul>
                <li><a href="http://www.mi.com/" target="_blank">小米商城</a></li>
                <li>|</li>
                <li><a href="">MIUI</a></li>
                <li>|</li>
                <li><a href="">米聊</a></li>
                <li>|</li>
                <li><a href="">游戏</a></li>
                <li>|</li>
                <li><a href="">多看阅读</a></li>
                <li>|</li>
                <li><a href="">云服务</a></li>
                <li>|</li>
                <li><a href="">金融</a></li>
                <li>|</li>
                <li><a href="">小米商城移动版</a></li>
                <li>|</li>
                <li><a href="">问题反馈</a></li>
                <li>|</li>
                <li><a href="">Select Region</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="right fr">
            <div class="gouwuche fr"><a href="">购物车</a></div>
            <div class="fr">
                <ul>
                    <li><a href="./login.html" target="_blank">登录</a></li>
                    <li>|</li>
                    <li><a href="./register.html" target="_blank">注册</a></li>
                    <li>|</li>
                    <li><a href="">消息通知</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</header>
<!--end header -->

<!-- start banner_x -->
<div class="banner_x center">
    <a href="index.ftl" target="_blank">
        <div class="logo fl"></div>
    </a>
    <a href="">
        <div class="ad_top fl"></div>
    </a>
    <div class="nav fl">
        <ul>
            [@item_cat_show limit=8]
                [#list item_cat_list as item_cat]
                    <li><a href="">[=item_cat.name]</a></li>
                [/#list]
            [/@item_cat_show]
        </ul>
    </div>
    <div class="search fr">
        <form action="" method="post">
            <div class="text fl">
                <input type="text" class="shuru" placeholder="小米6&nbsp;小米MIX现货">
            </div>
            <div class="submit fl">
                <input type="submit" class="sousuo" value="搜索"/>
            </div>
            <div class="clear"></div>
        </form>
        <div class="clear"></div>
    </div>
</div>
<!-- end banner_x -->

<!-- start banner_y -->
<div class="banner_y center">
    <div class="nav">
        <ul>
            [#assign x = 0]
            [#list itemRootCats as itemCat]
                [#assign x++]
                [#if x%2!=0]
            <li>
                <a href="#">[=itemCat.name]</a>
                [#else]
                <a href="#">[=itemCat.name]</a>
            </li>
                [/#if]
            [/#list]
        </ul>
    </div>
</div>

<div class="sub_banner center">
    <div class="sidebar fl">
        <div class="fl"><a href=""><img src="./image/hjh_01.gif"></a></div>
        <div class="fl"><a href=""><img src="./image/hjh_02.gif"></a></div>
        <div class="fl"><a href=""><img src="./image/hjh_03.gif"></a></div>
        <div class="fl"><a href=""><img src="./image/hjh_04.gif"></a></div>
        <div class="fl"><a href=""><img src="./image/hjh_05.gif"></a></div>
        <div class="fl"><a href=""><img src="./image/hjh_06.gif"></a></div>
        <div class="clear"></div>
    </div>
    <div class="datu fl"><a href=""><img src="./image/hongmi4x.png" alt=""></a></div>
    <div class="datu fl"><a href=""><img src="./image/xiaomi5.jpg" alt=""></a></div>
    <div class="datu fr"><a href=""><img src="./image/pinghengche.jpg" alt=""></a></div>
    <div class="clear"></div>


</div>
<!-- end banner -->
<div class="tlinks">Collect from <a href="http://www.cssmoban.com/">企业网站模板</a></div>

<!-- start danpin -->
<div class="danpin center">


    <div class="biaoti center">小米明星单品</div>
    <div class="main center">
        [@item_show item_cat_name='手机' limit=5]
            [#list item_cat_item_list as item_cat_item]
        <div class="mingxing fl">
            <div class="sub_mingxing"><a href=""><img src="[=item_cat_item.image]" alt=""></a></div>
            <div class="pinpai"><a href="">[=item_cat_item.title]</a></div>
            <div class="youhui">[=item_cat_item.sellPoint]</div>
            <div class="jiage">[=item_cat_item.price]元</div>
        </div>
            [/#list]
        [/@item_show]
        <div class="clear"></div>
    </div>
</div>
<div class="peijian w">
    <div class="biaoti center">配件</div>
    <div class="main center">

        <div class="content">
            <div class="remen fl"><a href=""><img src="./image/peijian1.jpg"></a>
            </div>
            [@item_show item_cat_name='配件' limit=8]
                [#list item_cat_item_list as item_cat_item]
            <div class="remen fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src="[=item_cat_item.image]"></a></div>
                <div class="miaoshu"><a href="">[=item_cat_item.title]</a></div>
                <div class="jiage">[=item_cat_item.price]元</div>
            </div>
                [/#list]
            [/@item_show]
            <div class="remenlast fr">
                <div class="hongmi"><a href=""><img src="./image/hongmin4.png" alt=""></a></div>
                <div class="liulangengduo"><a href=""><img src="./image/liulangengduo.png" alt=""></a></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<footer class="mt20 center">
    <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>
</body>
</html>