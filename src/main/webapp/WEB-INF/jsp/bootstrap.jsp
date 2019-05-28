<%--
  Created by IntelliJ IDEA.
  User: 我不管我最帅
  Date: 2019/3/13
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>bootstrap</title>
    <link  href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

</head>
<body>
<p>下拉菜单</p>
<div class="dropdown">
    <button class="btn dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">选择<span class="caret"></span></button>

    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
        <li class="dropdown-header">
          下拉菜单标题dropdown-header
        </li>
        <li role="presentation">
            <a href="#">CSS</a>
        </li>

        <li role="presentation">
            <a href="#">Javascript</a>
        </li>
        <li role="presentation" class="divider">
        </li>
        <li >
            divider分割线
        </li>
        <li class="disabled">
          禁用项
        </li>
    </ul>
</div>
<p>按钮组  按钮大小用 btn-group-(lg,sm,xs)</p>
<div class="btn-group btn-group-lg">
    <button type="button" class="btn btn-success">按钮</button>
    <button type="button" class="btn btn-success">按钮</button>
    <button type="button" class="btn btn-success">按钮</button>
</div>
<div class="btn-group btn-group-sm">
    <button type="button" class="btn btn-success">按钮</button>
    <button type="button" class="btn btn-success">按钮</button>
    <button type="button" class="btn btn-success">按钮</button>
</div>
<div class="btn-group btn-group-xs">
    <button type="button" class="btn btn-success">按钮</button>
    <button type="button" class="btn btn-success">按钮</button>
    <button type="button" class="btn btn-success">按钮</button>
</div>
<p>该 .btn-toolbar(按钮工具栏） 有助于把几组 class="btn-group"> 结合到一个  class="btn-toolbar"> 中，一般获得更复杂的组件。</p>
<div class="btn-toolbar">
    <div class="btn-group">
        <button type="button" class="btn btn-success">按钮</button>
        <button type="button" class="btn btn-success">按钮</button>
        <button type="button" class="btn btn-success">按钮</button>
    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-info">按钮</button>
        <button type="button" class="btn btn-info">按钮</button>
        <button type="button" class="btn btn-info">按钮</button>

    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-warning">按钮</button>
        <button type="button" class="btn btn-warning">按钮</button>
        <button type="button" class="btn btn-warning">按钮</button>
    </div>
</div>
<p>嵌套:您可以在一个按钮组内嵌套另一个按钮组,即，在一个 .btn-group 内嵌套另一个 .btn-group </p>
<div class="btn-group">
    <button type="button" class="btn btn-warning">按钮</button>
    <button type="button" class="btn btn-warning">按钮</button>
    <div class="btn-group">
        <button type="button" class="btn btn-warning dropdown-toggle " data-toggle="dropdown">下拉
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <li><a href="#">下拉链接 1</a></li>
            <li><a href="#">下拉链接 2</a></li>
            <li class="divider"></li>
            <li><a href="#">分离的链接</a></li>
        </ul>
    </div>
</div>
<p>垂直的按钮组: .btn-group-vertical 的使用：</p>
<div class="btn-group-vertical">
    <button type="button" class="btn btn-warning">按钮</button>
    <button type="button" class="btn btn-warning">按钮</button>
    <div class="btn-group">
        <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">下拉<span class="caret"></span></button>
        z
        <ul class="dropdown-menu">
            <li><a href="#">下拉链接 1</a></li>
            <li><a href="#">下拉链接 2</a></li>
            <li class="divider"></li>
            <li><a href="#">分离的链接</a></li>
        </ul>
    </div>
</div>
<p>输入框组</p>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <div class="input-group input-group-lg">
            <span class="input-group-addon" id="basic-addon1">@</span>
            <input type="text" class="form-control" aria-labelledby="basic-addon1" name="">
        </div>
        </div>
        <div class="col-md-3">
            <div class="input-group input-group-sm">
                <input type="text" class="form-control" aria-labelledby="basic-addon2" name="">
                <span class="input-group-addon" id="basic-addon2">$</span>
            </div>
        </div>
    </div>
    <p>输入框组 带按钮的</p>
    <div class="row">
        <div class="col-md-3">
            <div class="input-group">
                <span class="input-group-btn">
                <button class="btn btn-default">go!</button>
                </span>

                <input type="text" class="form-control" aria-labelledby="basic-addon3" name="">
            </div>
        </div>
    </div>
    <p>输入框组 带下拉菜单</p>
    <div class="row">
        <div class="col-md-3">
            <div class="input-group">
                <div class="input-group-btn">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        下拉菜单
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">功能</a></li>
                        <li><a href="#">另一个功能</a></li>
                        <li><a href="#">其他</a></li>
                        <li class="divider"></li>
                        <li><a href="#">分离的链接</a></li>
                    </ul>
                </div><!-- /btn-group -->

                <input type="text" class="form-control" aria-labelledby="basic-addon3" name="">
            </div>
        </div>
    </div>
</div>
<p>标签式的导航菜单：nav-tabs</p>
<ul class="nav nav-tabs">
    <li class="active"><a href="#">Home</a></li>
    <li><a href="#">SVN</a></li>
    <li><a href="#">iOS</a></li>
    <li><a href="#">VB.Net</a></li>
    <li><a href="#">Java</a></li>
    <li class="disabled"><a href="#">PHP</a></li>
</ul>
<p>基本的胶囊式导航菜单:nav-pills</p>
<ul class="nav nav-pills">
    <li class="active"><a href="#">Home</a></li>
    <li><a href="#">SVN</a></li>
    <li><a href="#">iOS</a></li>
    <li><a href="#">VB.Net</a></li>
    <li><a href="#">Java</a></li>
    <li class="disabled"><a href="#">PHP</a></li>
</ul>
<p>垂直的胶囊式导航菜单:nav-stacked</p>
<ul class="nav nav-pills nav-stacked">
    <li class="active"><a href="#">Home</a></li>
    <li><a href="#">SVN</a></li>
    <li><a href="#">iOS</a></li>
    <li><a href="#">VB.Net</a></li>
    <li><a href="#">Java</a></li>
    <li class="disabled"><a href="#">PHP</a></li>
</ul>
<p>两端对齐的导航
    您可以在屏幕宽度大于 768px 时，
    通过在分别使用 .nav、.nav-tabs 或 .nav、.nav-pills 的同时使用 class .nav-justified，
    让标签式或胶囊式导航菜单与父元素等宽。在更小的屏幕上，导航链接会堆叠。</p>
<ul class="nav nav-pills nav-justified">
    <li class="active"><a href="#">Home</a></li>
    <li><a href="#">SVN</a></li>
    <li><a href="#">iOS</a></li>
    <li><a href="#">VB.Net</a></li>
    <li><a href="#">Java</a></li>
    <li><a href="#">PHP</a></li>
</ul>
<p>带有下拉菜单的标签式导航菜单</p>
<ul class="nav nav-pills nav-justified">
    <li class="active"><a href="#">Home</a></li>
    <li><a href="#">SVN</a></li>
    <li><a href="#">iOS</a></li>
    <li><a href="#">VB.Net</a></li>
    <li class="dropdown">
        <a href="#" type="button" class="btn dropdown-toggle" data-toggle="dropdown">Java<span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="#">Swing</a></li>
            <li><a href="#">jMeter</a></li>
            <li><a href="#">EJB</a></li>
            <li class="divider"></li>
            <li><a href="#">分离的链接</a></li>
        </ul>
    </li>
    <li><a href="#">PHP</a></li>
</ul>
<p>导航栏</p>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">菜鸟</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">iOS</a></li>
                <li><a href="#">SVN</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        Java<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" >
                        <li><a href="#">jmeter</a></li>
                        <li><a href="#">EJB</a></li>
                        <li><a href="#">Jasper Report</a></li>
                        <li class="divider"></li>
                        <li><a href="#">分离的链接</a></li>
                        <li class="divider"></li>
                        <li><a href="#">另一个分离的链接</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<p>响应式的导航栏(缩小看效果)</p>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#hh">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">CAIJI</a>
        </div>
        <div class="collapse navbar-collapse" id="hh">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">iOS</a></li>
                <li><a href="#">SVN</a></li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">java<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">jmeter</a></li>
                        <li><a href="#">EJB</a></li>
                        <li><a href="#">Jasper Report</a></li>
                        <li class="divider"></li>
                        <li><a href="#">分离的链接</a></li>
                        <li class="divider"></li>
                        <li><a href="#">另一个分离的链接</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<p>导航栏中的表单</p>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">菜鸟教程</a>
        </div>
        <div>
            <form class="navbar-form" role="search">
                <div class="form-group">
                    <input class="form-control" placeholder="search">
                </div>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>
</nav>
<p>导航栏中的文本</p>
<nav class="navbar navbar-default">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand">菜鸟教程</a>
    </div>
        <div>
            <p class="navbar-text">森系  用户登录</p>
        </div>
    </div>
</nav>
<p>结合图标的导航链接</p>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">菜鸟教程</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
        </ul>
    </div>
</nav>
<p>导航栏固定到顶部 navbar-fixed-top  底部 navbar-fix-bottom</p>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">菜鸟</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">iOS</a></li>
                <li><a href="#">SVN</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        Java<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" >
                        <li><a href="#">jmeter</a></li>
                        <li><a href="#">EJB</a></li>
                        <li><a href="#">Jasper Report</a></li>
                        <li class="divider"></li>
                        <li><a href="#">分离的链接</a></li>
                        <li class="divider"></li>
                        <li><a href="#">另一个分离的链接</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<p>导航栏 静态的顶部  navbar-static-top:不知咋用(该 class 不要求向 body 添加内边距（padding）)</p>
<nav class="navbar navbar-default  navbar-static-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">菜鸟</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">iOS</a></li>
                <li><a href="#">SVN</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        Java<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" >
                        <li><a href="#">jmeter</a></li>
                        <li><a href="#">EJB</a></li>
                        <li><a href="#">Jasper Report</a></li>
                        <li class="divider"></li>
                        <li><a href="#">分离的链接</a></li>
                        <li class="divider"></li>
                        <li><a href="#">另一个分离的链接</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<p>导航栏 ：反色的导航栏 .navbar-inverse(为了防止导航栏与页面主体中的其他内容的顶部相交错，请向 body 标签添加至少 50 像素的内边距（padding），内边距的值可以根据您的需要进行设置)</p>
<nav class="navbar navbar-default  navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">菜鸟</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">iOS</a></li>
                <li><a href="#">SVN</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        Java<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" >
                        <li><a href="#">jmeter</a></li>
                        <li><a href="#">EJB</a></li>
                        <li><a href="#">Jasper Report</a></li>
                        <li class="divider"></li>
                        <li><a href="#">分离的链接</a></li>
                        <li class="divider"></li>
                        <li><a href="#">另一个分离的链接</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<p>警告框 alert alert-success..</p>
<div class="alert alert-success">成功！很好地完成了提交。</div>
<p>可以取消的警告 添加alert-dismissible ，请确保使用带有 data-dismiss="alert" data 属性的 button 元素才能关闭</p>
<div class="alert alert-success alert-dismissible">
    <button class="close" type="button" data-dismiss="alert" aria-hidden="true">&times</button>
    成功！很好地完成了提交。
</div>
<p>模态弹框 modal:整个大的全屏框，fade 关闭时淡入淡出效果， modal-dialog：显示内容的框 ,关闭按钮必须加data-dismiss="modal"才可关闭弹窗</p>
<p>aria-hidden="true" 用于保持模态窗口不可见，直到触发器被触发为止</p>
<p>data-keyboard="false":当按下 escape 键时关闭模态框，设置为 false 时则按键无效。 </p>
<p>data-backdrop="static":指定一个静态的背景，当用户点击模态框外部时不会关闭模态框。</p>
<button class="btn " data-toggle="modal" data-target="#myModal">开始演示模态弹窗</button>

<div class="modal fade"  id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <%--头部标题--%>
            <div class="modal-header">
                <%--包括标题 和关闭按钮--%>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times</button>
                <h4 class="modal-title">模态框（Modal）标题</h4>
            </div>
            <%--主体--%>
            <div class="modal-body">
                <p>显示一些内容</p>
            </div>
            <%--底部 一些操作--%>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">提交</button>
            </div>
        </div><%--modal-content--%>

    </div><%--modal-dialog--%>
</div><%--modal--%>
<p>提示工具:tooltip</p>
<p>data-trigger="click":触发tooltip的事件( click| hover | focus | manual)</p>
<p>data-placement="left":规定如何定位提示工具 left左边提示（</p>
<p>data-delay=“1000”:显示和隐藏延迟1秒</p>
<a href="#" data-toggle="tooltip" title="默认的tooltip">默认的tooltip</a>...
<a href="#" data-toggle="tooltip" data-placement="top" title="顶部的 Tooltip">顶部的 Tooltip</a>...
<a href="#"  data-toggle="tooltip" data-placement="left" title="左边的tooltip">左边的tooltip</a>...
<a href="#" data-toggle="tooltip"  data-delay="2000" data-placement="right" title="右边的tooltip">右边的tooltip</a>...
<a href="#" data-toggle="tooltip"  data-placement="bottom" title="底部的tooltip">底部的tooltip</a>
<button type="button" class="btn btn-success" data-trigger="click" data-toggle="tooltip" data-placement="top" title="顶部tooltip">顶部tooltip</button>
<p>tooltip提供的方法</p>

这是一个 <a href="#" class="tooltip-show" data-toggle="tooltip"
        title="show haha">Tooltip 方法 show
</a>.
这是一个
<a href="#" class="tooltip-toggle" data-toggle="tooltip" data-placement="top" title="toggle haha">Tooltip 方法 toggle</a>.

<p>弹出框</p>
<button class="btn btn-success" data-toggle="popover" title="title" data-placement="top" data-content="content hello world">top弹出框</button>
<button class="btn btn-warning" data-toggle="popover" title="title" data-placement="right" data-content="content hello world">right弹出框</button>
<button class="btn btn-info" data-toggle="popover" title="title" data-placement="bottom" data-content="content hello world">bottom弹出框</button>
<button class="btn btn-danger" data-toggle="popover" title="title" data-placement="left" data-content="content hello world">left弹出框</button>
<br/><br/><br><br/>
<button class="btn btn-success" data-loading-text="Loading..." type="button">加载状态</button>
<p>创建可折叠的分组或折叠面板</p>
<div class="panel panel-primary">
    <div class="panel-heading">
    <h4 class="panel-title">
        <a data-toggle="collapse" href="#collapseThere">
            点击
        </a>
    </h4></div>
    <div class="collapse panel-collapse in" id="collapseThere">
        <div class="panel-body">
            Nihil anim keffiyeh helvetica, craft beer labore wes anderson
            cred nesciunt sapiente ea proident. Ad vegan excepteur butcher
            vice lomo.
        </div>
    </div>
</div>
<div class="panel panel-success">
    <div class="panel-heading">
        <h4 class="panel-title">
            <a data-toggle="collapse" href="#collapseThere2">
                点击
            </a>
        </h4></div>
    <div class="collapse panel-collapse" id="collapseThere2">
        <div class="panel-body">
            Nihil anim keffiyeh helvetica, craft beer labore wes anderson
            cred nesciunt sapiente ea proident. Ad vegan excepteur butcher
            vice lomo.
        </div>
    </div>
</div>
<p>轮播 carousel 加slide才有滑动效果</p>
<p>属性 data-slide 接受关键字 prev 或 next，用来改变幻灯片相对于当前位置的位置。</p>
<p>data-ride="carousel" 属性用于标记轮播在页面加载时就开始动画播放。</p>
<p>data-interval:自动循环每个项目之间延迟的时间量。如果为 false，轮播将不会自动循环。</p>
<div style="width:35%">
<div class="carousel slide" id="myCarousel" data-ride="carousel" data-interval="2000">
    <%--轮播指引--%>
    <ol class="carousel-indicators">
        <li class="active"  data-target="#myCarousel" data-slide-to="0">0</li>
        <li  data-target="#myCarousel" data-slide-to="1">0</li>
        <li  data-target="#myCarousel" data-slide-to="2">0</li>
    </ol>
    <%--轮播项目--%>
    <div class="carousel-inner">
        <div class="item active">
            <img src="${pageContext.request.contextPath}/static/img/1.jpg" alt="first">
        </div>
        <div class="item ">
            <img src="${pageContext.request.contextPath}/static/img/2.jpg" alt="second">
        </div>
        <div class="item ">
            <img src="${pageContext.request.contextPath}/static/img/3.jpg" alt="third">
        </div>
    </div>
    <%--轮播导航--%>
    <%--prev--%>
    <a class="carousel-control left" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <%--next--%>
    <a class="carousel-control right" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>

</div>
</div>
<br/>
<br/>
<p>带标题的轮播 .carousel-caption</p>
<div style="width:35%">
    <div class="carousel slide" id="myCarousel2">
        <%--轮播指标--%>
        <ol class="carousel-indicators">
            <li class="active" data-target="#myCarousel2" data-slide-to="0"></li>
            <li data-target="#myCarousel2" data-slide-to="1"></li>
            <li data-target="#myCarousel2" data-slide-to="2"></li>
        </ol>
            <%--轮播项目--%>
            <div class="carousel-inner">
                <div class="item active">
                    <img src="${pageContext.request.contextPath}/static/img/1.jpg">
                <div class="carousel-caption"><h4>标题1</h4></div>
                </div>
                <div class="item ">
                    <img src="${pageContext.request.contextPath}/static/img/2.jpg"/>
                    <div class="carousel-caption"><h4>标题2</h4></div>
                </div>
                <div class="item">
                    <img src="${pageContext.request.contextPath}/static/img/3.jpg"/>
                    <div class="carousel-caption"><h4>标题3</h4></div>
                </div>
            </div>
            <%--prev next 导航--%>
           <a href="#myCarousel2" class="carousel-control left" role="button" data-slide="prev">
               <span class="glyphicon glyphicon-chevron-left" aria-hidden="true" ></span>
               <span class="sr-only">prev</span>
           </a>
            <a href="#myCarousel2" data-slide="next" class="carousel-control right" role="button">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <%--sr-only 残障人士才会看到next，正常人看不出效果 --%>
                <span class="sr-only">next</span>
            </a>
        <div></div>
    </div>
</div>
<p>carousel一些方法控制轮播</p>
<p>.carousel('cycle'):	从左到右循环轮播项目。</p>
<p>.carousel('pause'):	停止轮播循环项目。</p>
<p>.carousel(number):	循环轮播到某个特定的帧（从 0 开始计数，与数组类似）。</p>
<p>.carousel('prev'):轮播到上个项目</p>
<p>.carousel('next'):轮播到下个项目</p>
<button type="button" class="btn start-slide">开始轮播</button>
<button type="button" class="btn pause-slide">暂停轮播</button>
<button type="button" class="btn prev-slide">上一个</button>
<button type="button" class="btn next-slide">下一个</button>
<button type="button" class="btn slide-one">slide 1</button>
<button type="button" class="btn slide-two">slide 2</button>
<button type="button" class="btn slide-three">slide 3</button>
<br/>
<br/>

<%--tooltip提示插件必须手动激活--%>
<script>
    $(function () { $("[data-toggle='tooltip']").tooltip();
    $('.tooltip-show').tooltip('show');});
    $(function () { $('.tooltip-hide').tooltip('hide');});
    $(function () { $('.tooltip-destroy').tooltip('destroy');});
    //向提示工具插入html
    $(function () { $(".tooltip-options a").tooltip({html : true });
    });
    /*弹出层 popover插件必须激活*/
    $(function () { $("[data-toggle='popover']").popover(); });
    //向按钮添加加载状态，
   /* $(function() {
        $(".btn").click(function(){
            $(this).button('loading').delay(1000).queue(function() {
                // $(this).button('reset');
                // $(this).dequeue();
            });
        });
    });*/
    //轮播
    $(function () {
        //start-slide
        $(".start-slide").click(function () {
            $("#myCarousel2").carousel('cycle')
        });
        //pause-slide
        $(".pause-slide").click(function () {
            $("#myCarousel2").carousel('pause');
        });
        //prev-slide
        $(".prev-slide").click(function () {
            $("#myCarousel2").carousel('prev')
        });
        //next-slide
        $(".next-slide").click(function () {
            $("#myCarousel2").carousel('next');
        });
        // 循环轮播到某个特定的帧
        $(".slide-one").click(function () {
            $("#myCarousel2").carousel(0)
        });
        $(".slide-two").click(function () {
            $("#myCarousel2").carousel(1)
        });
        $(".slide-three").click(function () {
            $("#myCarousel2").carousel(2)
        });
    })
</script>
</body>

</html>
