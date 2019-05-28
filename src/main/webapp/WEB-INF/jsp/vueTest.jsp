<%@ taglib prefix="v-on" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="v-bind" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 我不管我最帅
  Date: 2019/3/9
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/vue.min.js"></script>
    <%--路由--%>
    <script src="${pageContext.request.contextPath}/static/js/vue-router.min.js"></script>
    <%--fetch(ajax框架)--%>
    <script src="${pageContext.request.contextPath}/static/js/fetch.min.js"></script>
    <%--axios （ajax框架）--%>
    <script src="${pageContext.request.contextPath}/static/js/axios.min.js"></script>

    <style>
        div{
            cursor: pointer;
        }
        #grandFather {
            background: deeppink;
        }
        #father {
            background: pink;
        }
        #me {
            background: hotpink;
        }#son {
             background: #ff4225;
         }
        tr.firstLine{
            background-color: lightGray;
        }
        .tb{

            border:1px solid green ;
        }
        table tr td{
            border:1px solid gray;
            padding:2px;

        }
        .active{
            color:green;

        }
        .text-danger{
            font-size: 1rem;
            outline: solid;
        }
        /* 可以设置不同的进入和离开动画 */
        /* 设置持续时间和动画函数 */
        .fade-enter-active, .fade-leave-active {
            transition: opacity 2s
        }
        .fade-enter, .fade-leave-to /* .fade-leave-active, 2.1.8 版本以下 */ {
            opacity: 0;
        }
        /*路由 css*/


    </style>
</head>
<body>
<div id="main">
    普通文本（双大括号）:{{message}}
    <p>html:<span v-html="message"></span></p>
    <p>之前都是把 Vue对象上的数据显示在视图上</p>
    <p>双向数据绑定 v-model: 把视图上的数据放到vue对象上去</p>
    <input type="text" v-model="message">
    <p>多种风格数据双向绑定</p>
    <table cellpadding="0" cellspacing="0" border="1">
        <tr class="firstLine">
            <td>视图类型</td>
            <td>输入数据</td>
            <td>绑定到vue上的数据</td>
        </tr>

        <tr>
            <td> 单行文本</td>
            <td><input type="text" v-model="input"></td>
            <td>{{input}}</td>
        </tr>
        <tr>
            <td>  多行文本</td>
            <td><textarea v-model="textarea"></textarea></td>
            <td>{{textarea}}</td>
        </tr>
        <tr>
            <td>单个复选框</td>
            <td><input type="checkbox" v-model="checked"></td>
            <td>{{checked}}</td>
        </tr>
        <tr>
            <td>多个复选框</td>
            <td>
                <input id="apple" value="apple" type="checkbox" v-model="checkeds">
                <label for="apple">apple</label>
                <input id="banana" value="banana" type="checkbox" v-model="checkeds">
                <label for="banana">banana</label>
                <input id="orange" value="orange" type="checkbox" v-model="checkeds">
                <label for="orange">orange</label>
            </td>
            <td>{{checkeds}}</td>
        </tr>
        <tr>
            <td>单选按钮</td>
            <td>
                <input type="radio" name="sex" id="female" value="female" v-model="radio">
                <label for="female">female</label>
            <input type="radio" name="sex" id="man" value="male" v-model="radio">
            <label for="man">male</label>
            </td>
            <td>{{radio}}</td>
        </tr>
        <tr>
            <td> 下拉单选框</td>
            <td>
                <select v-model="selected"  size="4">
                    <option disabled value="">请选择</option>
                    <option>Apple</option>
                    <option>Banana</option>
                    <option>Orange</option>
                </select>
            </td>
            <td>{{selected}}</td>
        </tr>
        <tr>
            <td> 下拉多选框,加属性multiple，按住ctrl</td>
            <td>
                <select v-model="selecteds" multiple  size="4">
                    <option disabled value="">请选择</option>
                    <option>Apple</option>
                    <option>Banana</option>
                    <option>Orange</option>
                </select>
            </td>
            <td>{{selecteds}}</td>
        </tr>
        <tr>
            <td> 单个复选框二（自定义值）</td>
            <td>
                默认值是true或者false,也可以修改为自定义的值<br>
                <input type="checkbox" v-model="toggle" true-value="好" false-value="不好">
            </td>
            <td>{{toggle}}</td>
        </tr>
    </table>
    <p>v-model 修饰符: .lazy .number .trim</p>
    <p><span style="color:red">.lazy:</span>相当于监听change操作，只有在失去焦点的时候，才会进行数据绑定了 </p>
    <table class="tb">
        <tr class="firstLine">
            <td>视图类型</td>
            <td>输入数据</td>
            <td>绑定到Vue上的数值</td>
        </tr>
        <tr>
            <td>
                单行文本1(未加.lazy)
            </td>
            <td>
                <input v-model="input1" placeholder="输入数据">
            </td>
            <td>
                <p>{{ input1 }}</p>
            </td>
        </tr>
        <tr>
            <td>
                单行文本2(加.lazy)
            </td>
            <td>
                <input v-model.lazy="input2" placeholder="输入数据">
            </td>
            <td>
                <p>{{ input2 }}</p>
            </td>
        </tr>
    </table>

    <p><span style="color:red">.number:</span>v-model默认是string类型，所以就可以通过.number方式确保获取到的是数字类型了。 </p>
    <table class="tb">
        <tr class="firstLine">
            <td>视图类型</td>
            <td>输入数据</td>
            <td>绑定到Vue上的数值</td>
            <td>数值类型</td>
        </tr>
        <tr>
            <td>
                单行文本1(未加.number)
            </td>
            <td>
                <input v-model="input3" type="number" placeholder="输入数据">
            </td>
            <td>
                <p>{{ input3 }}</p>
            </td>
            <td>
                <p>{{ typeof input3 }}</p>
            </td>
        </tr>
        <tr>
            <td>
                单行文本2(加.number)
            </td>
            <td>
                <input v-model.number="input4"   type="number"  placeholder="输入数据">
            </td>
            <td>
                <p>{{ input4 }}</p>
            </td>
            <td>
                <p>{{ typeof input4 }}</p>
            </td>
        </tr>
    </table>

    <p><span style="color:red">.trim:</span> 去掉前后的空白 </p>
    <table class="tb" >
        <tr class="firstLine">
            <td>视图类型</td>
            <td>输入数据</td>
            <td>绑定到Vue上的数值</td>
        </tr>
        <tr>
            <td>
                单行文本
            </td>
            <td>
                <input v-model.trim="input5"  placeholder="输入数据">
            </td>
            <td>
                <p>"{{ input5 }}"</p>
            </td>
        </tr>
    </table>
    <button v-on:click="toUper">点我变大写</button>
    <button v-on:click="count">v-on:click="count" 点我 {{clickNumber}}</button>
    <button @click="count">@click="count" 点我 {{clickNumber}}</button>
    <br/>
    <p>遍历 v-for="item in list"</p>
    <p v-for="item in groceryList">{{item.id}}、{{item.text}}</p>
    <table cellspacing="0" cellpadding="2" border="1" style="text-align:  center">
        <tr><td>name</td>
        <td>hp</td></tr>
        <tr v-for="hreo in heros">
            <td>{{hreo.name}}</td>
            <td>{{hreo.hp}}</td>
        </tr>
    </table>
    <p>遍历 v-for="hreo,index in heros"  以及遍历下标：index 方法</p>
    <table cellspacing="0" cellpadding="2" border="1" style="text-align:  center">
        <tr><td>index</td>
            <td>name</td>
            <td>hp</td></tr>
        <tr v-for="hreo,index in heros">
            <td>{{index+1}}</td>
            <td>{{hreo.name}}</td>
            <td>{{hreo.hp}}</td>
        </tr>
    </table>
    <p>纯数字遍历</p>
    <div v-for="i in 10">{{i}}</div>

    <br/>
    <p>组件案例：todo-item 里面有个属性todo，  v-bind 用于做属性绑定</p>
    <ul>
        <todo-item  v-for="item in groceryList"
                    v-bind:todo="item"
                    v-bind:key="item.id"></todo-item>
    </ul>
    <br/>
    <p>v-bind :属性绑定  v-bind:href 可以简写成 :href ,v-on:click 简写成 @click</p>
    <button v-bind:disabled="isok">123 绑定属性disbaled</button>
    <p><a v-bind:href="url">绑定属性href</a></p>
    <br/>
    <p>v-if v-else  v-else-if</p>
    <button v-on:click="toggle">切换显示隐藏</button>
    <p v-if="seen">v-if为true  你就可以看到我</p>
    <button v-on:click="moyiba">摸一把中彩票</button>
    <div v-if="show">中了500万</div>
    <div v-else="">谢谢惠顾</div>
    <button v-on:click="toutai">看看投胎做什么：{{number}}</button>
    <div v-if="number>98">神仙</div>
    <div v-else-if="number>95">国家领导人</div>
    <div v-else-if="number>90">大富商</div>
    <div v-else-if="number>80">大企业家</div>
    <div v-else-if="number>60">小企业家</div>
    <div v-else-if="number>30">工人</div>
    <div v-else>流浪汉</div>
</div>
<p>事件修饰符里面有几个都是关于冒泡的
    那么什么是冒泡呢? 简单的说就是 父元素里有 子元素， 如果点击了 子元素, 那么click 事件不仅会发生在子元素上，也会发生在其父元素上，依次不停地向父元素冒泡，直到document元素。
</p>
<p>.stop：阻止冒泡 用法：v-on:click.stop=“doc”</p>
<p>.capture:优先触发 ，当冒泡发生的时候加了修饰符.capture的优先触发</p>
<p>.self:只有自己能触发，子元素无法触发.self </p>
<p>.once :只能提交一次,点击一次之后既不会在监听 </p>
<p> .prevent :阻止提交 </p>
<div id="content">
    <div id="grandFather"  v-on:click.capture="doc">
        grandFather
        <div id="father" v-on:click.self="doc">
            father
            <div id="me" v-on:click.once="doc">
                me
                <div id="son" v-on:click.stop="doc">
                    son
                </div>
            </div>
        </div>
    </div>
</div>
<div id="div1">
    只有超链和form这种会导致页面刷新的操作，.prevent 才有用<br/>
    <a href="http://www.12306.com" v-on:click="jump">正常超链接http://www.12306.com</a><br/>
    <a href="http://www.12306.com" v-on:click.prevent="jump">prevent jump()之后的链接 http://12306.com</a>
    <br>
    <a href="http://12306.com" @click.prevent >纯prevent之后的链接 http://12306.com</a>
    <form  v-on:submit="jump" action="http://www.12306.com">
        <button type="submit" >正常的form</button>
    </form>
    <form action="http://www.12306.com" v-on:submit.prevent="jump">
        <button type="submit">prevent jump()之后的form</button>
    </form>
    <form action="http://12306.com" v-on:submit.prevent>
        <button type="submit">纯prevent之后的form</button>
    </form>
</div>
<%--计算属性--%>
<p style="color:red">计算属性</p>
<p>不用compute计算属性的做法</p>
<div id="compute_div">
    <table align="center"  cellpadding="0" cellspacing="0" border="1">
        <tr>
            <td>人名币</td>
            <td>美元</td>
        </tr>
        <tr>
            <td colspan="2">汇率：<input type="number" v-model.number="huilv1"></td>
        </tr>
        <tr>
            <td>￥:<input type="number" v-model.number="rmb1"></td>
            <td>$:{{rmb1/huilv1}}</td>
        </tr>
    </table>
    <p>使用compute计算属性的做法</p>
    <table align="center"  cellpadding="0" cellspacing="0" border="1">
        <tr>
            <td>人名币</td>
            <td>美元</td>
        </tr>
        <tr>
            <td colspan="2">汇率：<input type="number" v-model.number="huilv2"></td>
        </tr>
        <tr>
            <td>￥:<input type="number" v-model.number="rmb2"></td>
            <td>$:{{dollar}}</td>
        </tr>
    </table>
    <input type="text" v-model="firstName">{{firstName}}<br/>
    <input type="text" v-model="lastName">{{lastName}}<br/>
    在控制台输入vm.fullNames="kitt world"： {{fullNames}}
</div>
<p>watch监听属性：ue可以通过watch来监听属性值的变化。</p>
<div id="watch">
    <table cellspacing="1" cellpadding="1" border="1" align="center" >
        <tr class="firstLine">
            <td>人民币</td>
            <td>美元</td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                汇率： <input type="number" v-model.number="huilv" />
            </td>
        </tr>

        <tr>

            <td align="center">
                ￥: <input type="number" v-model.number = "rmb"  />
            </td>
            <td align="center">
                $: <input type="number" v-model.number = "dollar"   />
            </td>
        </tr>
    </table>
</div>
<h2>Class与Style绑定</h2>
<h3>绑定 HTML Class:v-bind:class</h3>
<div id="bing">
    <p v-bind:class="{active:isActive,'text-danger':isActive}">绑定样式写法一(类名带- 就必须加单引号‘text-danger’:isActive)</p>
    <p v-bind:class="classObject">绑定样式写法二classObject:{active:true,'text-danger':true}</p>
    <p v-bind:class="classObjected">绑定样式写法三（classObjected是计算属性）</p>
    <p v-bind:class="[activeClass,atClass]">把一个数组传给 v-bind:class</p>
    <h3>绑定内联样式 v-bind:style</h3>
    <p v-bind:style="{color:'red',fontSize:30+'px'}">绑定内联样式一(直接写单位需要加单引号)</p>
    <p v-bind:style="{color:activeColor,fontSize:font_size}">绑定内联样式二（在vue里面写）</p>
    <p v-bind:style="[actoveColor2,font_size2]">绑定内联样式三（数组）</p>
</div>
<h3 style="color:red">组件</h3>
<div id="component">
    <button-counter title="hello world"></button-counter>
    <button-counter v-bind:title="value"></button-counter>
</div>

<h3 style="color:red">过滤器</h3>
<h3 style="color:red">全局过滤器如下：</h3>
<code>Vue.filter("capitalize",function(value){
    if(!value) return '';
    value=value.toString();
    return value.charAt(0).toUpperCase()+value.slice(1);
    });</code>
<div id="filters">
<input type="text" v-model="data" placeholder="输入字母首字母变大写">
    {{data|capitalize}}
    <h3 style="color:red">局部过滤器如下：</h3>
    <input type="text" v-model="data2" placeholder="输入字母首尾字母变大写">
    {{data2|capitalize|cpp}}
</div>
<p>过渡效果</p>
<div id="guodu">
    <button v-on:click="show=!show">点我</button>
    <transition name="fade">
        <p v-show="show" v-bind:style="styobj">动画实例</p>
    </transition>
</div>

<p>路由：vue.js 里的路由相当于就是局部刷新。</p>
<p style="color:red">第一步：定义路由组件<br/>
第二步：定义路由<br/>
第三步：创建router实例<br/>
第四步：给vue对象绑定路由</p>
<div id="app">
        <router-link to="/user">用户管理</router-link>
        <router-link to="/product">产品管理</router-link>
        <router-link to="/order">订单管理</router-link>
    <div>
        <router-view></router-view>
    </div>
</div>
<p>fetch实例</p>
<div id="hero"></div>
<p>fetch操作json数组实例</p>
<div id="fetchs">
    <table>
        <tr>
            <td>name</td>
            <td>hp</td>
        </tr>
        <tr v-for="hero in heros">
            <td>{{hero.name}}</td>
            <td>{{hero.hp}}</td>
        </tr>
    </table>
</div>
<p>axios实例</p>
<div id="hero2"></div>
<p>axios操作json数组实例</p>
<div id="axios">
    <table>
        <tr>
            <td>name</td>
            <td>hp</td>
        </tr>
        <tr v-for="hero in heros">
            <td>{{hero.name}}</td>
            <td>{{hero.hp}}</td>
        </tr>
    </table>
</div>
<div class="dropdown">
    <button class="btn dropdown-toggle" id="menu1" data-toggle="dropdown">zxc</button>
    <span class="caret"></span>
    <ul class="dropdown-menu" role="menu" aria-labelledby="">

    </ul>
</div>
<%--<p>监听子组件事件</p>
<div id="zi">
    <div v-bind:style="{fontSize:postFontSize+'em'}">
        <blog-post v-for="post in posts"
                   v-bind:post="post" v-on:enlarge="postFontSize+=0.1"></blog-post>
    </div>
</div>--%>

</body>
<script>
    var data=[{name:"盖伦",hp:341},{name:"提莫",hp:555},{name:"安妮",hp:666}];
    /*注册组件 放在实例Vue上面*/
    Vue.component('todo-item',{
        props:['todo'],
        template:'<li>{{todo.text}}</li>'
    });

    var app=new Vue({
    el:"#main",
    data:{
        message:"<span style='color:red'>hello world</span>",
        clickNumber:0,
        isok:true,
        seen:true,
        show:false,
        number:0,
        url:"http://www.baidu.com",
        heros:data,   /*引用上面定义好的*/
        groceryList: [
            { id: 0, text: '蔬菜' },
            { id: 1, text: '奶酪' },
            { id: 2, text: '随便其它什么人吃的东西' }
        ],
        input:'',
        textarea:'',
        checked:'',
        checkeds:[],
        radio:'',
        selected:'',
        selecteds:[],
        toggle:'',
        input1:'',
        input2:'',
        input3:'',
        input4:'',
        input5:''




    },
    methods:{
        toUper:function () {
            this.message=this.message.toUpperCase();
        },
        count:function () {
            this.clickNumber++;
        },
        toggle:function () {
            this.seen=!this.seen;
        },
        moyiba:function () {
            this.show=Math.random()<0.5
        },
        toutai:function () {
            this.number=Math.random()*100;
        }
    }
});

    var contents = new Vue({
        el: "#content",
        data: {
            id: ''
        },
        methods: {
            doc: function (event) {
               this.id= event.currentTarget.id;
                alert(this.id);
            }
        }
    });
    var div1=new Vue({
        el:"#div1",
        data:{

        },
        methods:{
            jump:function () {
                alert("jump()被调用");
            }
        }
    });
        var vm=new Vue({
      el:"#compute_div",
            data:{
                huilv1:6.4,
                rmb1:0,
                huilv2:6.4,
                rmb2:0,
                firstName:'Foo',
                lastName:'Bar'

            },
            computed:{
                dollar:function () {
                return this.rmb2/this.huilv2;
            },
                fullNames:{
                    get:function () {
                    return this.firstName+" "+this.lastName;
                },
                    set:function (newVal) {
                        var names=newVal.split(" ");
                        this.firstName=names[0];
                        this.lastName=names[names.length-1]
                    }
                }}
    });
        new Vue({
            el:"#watch",
            data:{huilv:6.5,
            rmb:0,
            dollar:0},
            watch:{
                //如果data里面的rmb发生变化，这个函数将会执行
            rmb:function (val) {
                this.rmb=val;
                this.dollar=this.rmb/this.huilv;
            },
                //如果data里面的dollar发生变化，这个函数将会执行
                dollar:function (val) {
                    this.dollar=val;
                    this.rmb=this.dollar*this.huilv;
                }
            }
        });
        //class与style绑定
        new Vue({
            el:"#bing",
            data:{
                isActive:true,
                hasError:true,
                activeClass:'active',
                atClass:'text-danger',
                classObject:{
                    //active 是定义好的css
                    active:true,
                    //样式text-danger带- 需要加单引号‘’
                    'text-danger':true
                },
                activeColor: 'red',
                font_size: 30+'px',
                actoveColor2:{
                    color:'red'
                },
                font_size2:{
                    fontSize:30+'px'
                }
            },
            computed:{
                classObjected:function () {
                            //返回对象的计算属性(avtive text-danger是样式)
                    return { active:this.isActive,
                    'text-danger':this.isActive}
                }
            }
        });
        //定义组件（全局注册）
        Vue.component("button-counter",{
            //data选项必须是一个函数，因此每个实例可以维护一份被返回对象的独立的拷贝：
            data:function () {
                return {
                    count: 0
                }
            },
            //通过props向子组件传递数据（也可以理解为给这个组件添加属性）
            props:['title'],
            template:'<button v-on:click="count++">You clicked me {{ count }} times. {{title}}</button>'
        });
        new Vue({
            el:"#component",
            data:{
                value:'hello kiity'
            }
        });
    //过滤器
    //全局过滤器
    Vue.filter("capitalize",function(value){
        if(!value) return '';
        value=value.toString();
        return value.charAt(0).toUpperCase()+value.slice(1);
    });
    new Vue({
        el:"#filters",
        data:{
            data:'',
            data2:''
        },
        //局部过滤器(定义在vue内部)
        filters:{
            cpp:function (value) {
                if(!value) return '';
                    value=value.toString();
                return value.substring(0,value.length-1)+ value.charAt(value.length-1).toUpperCase();
            }

        }
    });
    //过渡效果
    new Vue({
        el:"#guodu",
        data:{
            show:true,
            styobj:{
                fontSize:'30px',
                color:'red'
            }
        }
    });
    //路由
    //1、定义（路由）组件
    const user={template:'<p>用户管理页面的内容</p>'};
    const product={template:'<p>产品管理页面的内容</p>'};
    const order={template:'<p>订单管理页面的内容</p>'};
    //2、定义路由
    const routes=[{path:'/',redirect:'/user'},// 这个表示会默认渲染 /user，没有这个就是空白
        {path:'/user',component:user},
        {path:'/product',component:product},
        {path:'/order',component:order}];
    //3、创建vueRouter实例
    const router=new VueRouter({
        routes:routes
    });
    //4、给Vue对象绑定router
  new Vue({
      el:"#app",
        router
    });
  //fetch: ajax框架 （非原生）
    var url="static/json.txt";
    fetch(url).then(function (response) {
      //  alert("response.status:"+response.status+",Response.statusText:"+response.statusText+",Response.ok: "+response.ok);
        // alert("response.json()返回的是"+response.json()+"类型");
     //  console.log("response.json()返回的是"+response.json()+"类型");
        //response.json()返回的是promise，其本质是分离异步数据获取和业务
      response.json().then(function (jsonObject) {
          var jsonString=JSON.stringify(jsonObject);
            //alert(jsonObject);
           // alert(jsonObject.name);
          document.getElementById("hero").innerHTML="通过fetch获取到的json数据："+ jsonString;
      })
    }).catch(function (err) {
        alert("Fetch错误:"+err)
    });
    //fetch操作json批量数据
    var url2="static/jsons.txt";
    new Vue({
        el:"#fetchs",
        data:{
            heros:[]
        },
        mounted:function () { //mounted　表示这个 Vue 对象加载成功了 就执行
            self=this;
            fetch(url2).then(function (response) {
                response.json().then(function (jsonObj) {
                    self.heros=jsonObj;
                })
            }).catch(function (err) {
               alert("Fetch错误:"+err);
            })
        }
    });

    //axios（ajax框架）
    axios.get(url).then(function (response) {
        var jsonObject=response.data;
        var jsonString=JSON.stringify(jsonObject);
        document.getElementById("hero2").innerHTML="通过axios获取到的json数据："+ jsonString;
    });
    //axios操作json批量数据
    new Vue({
        el:"#axios",
        data:{
            heros:[]
        },
        mounted:function () {
            self=this;
            axios.get(url2).then(function (response) {
                self.hreos=response.data; //此时还是字符串
                self.heros=eval("("+self.heros+")");//字符串转为json数组
            })
            
        }
    })
 /*   var url="static/hello.txt";
    fetch(url).then(function (response) {
       // alert("response.status:"+response.status+",Response.statusText:"+response.statusText+",Response.ok: "+response.ok);
       // alert("response.json()返回的是"+response.json()+"类型");
        response.text().then(function (text) {
            alert(text);
            document.getElementById("hero").innerHTML="通过fetch获取到的text数据："+ text;
        })
    }).catch(function (err) {
        alert("Fetch错误:"+err)
    })*/

/*
        //监听子组件事件
    Vue.component('blog-post', {
        props: ['post'],//内建的 $emit 方法 传入事件名称来触发一个事件：
        template:'<div><h3>{{post.title}}</h3><button v-on:click="$emit(enlarge)">Enlarge text</button><div v-html="post.content"></div></div>'
    });
    new Vue({
        el:"#zi",
        data:{
            posts:[{title:"新闻",content:"央视一套"},{title:"明星",content:"张   杰"},{title:"歌手",content:"汪峰"}],
            postFontSize:1
        }
    })*/


</script>
</html>
