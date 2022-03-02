package com.example.mysite.data

import androidx.compose.runtime.Immutable

@Immutable
data class Site(
    val name: String,
    val description: String,
    val aboutMe: String,
    val aboutSite: String
)
val siteData = Site(
    name = "JianchengWang",
    description = "Have fun and enjoy every day.",
    aboutMe = "奔三大龄男青年，职业码农，立志全栈，技术九流，没啥兴趣爱好，一般刷剧，看书 沉迷网络小说，dota2，跑步，滑板，宅狗一枚，周末一般躺尸不出门",
    aboutSite = "个人博客，简单记录一下技术，生活上的东东，偶尔会发些莫名其妙的东西，什么类型都有，主要关注以下几点" +
            "\n" +
            "1.编码\n" +
            "2.生活牢骚，不喷不快\n" +
            "3.自己会发光的东西\n" +
            "4.武侠小说，妈的，来场穿越吧，要求不高，一座城堡，十个老婆，一剑光耀十九州\n" +
            "5.分享杂谈，读书笔记等"
)


@Immutable
data class Girl(
    val name: String,
    val avatar: String,
    val from: String,
    val description: String
)
val girls: ArrayList<Girl> = arrayListOf(
    Girl(
        "大污霞",
        "https://blog.res.jianchengwang.info/girls/dawuxia.jpg",
        "遥远的21世纪",
        "宇宙超级无敌女流氓"
    ),
    Girl(
        "香香大佬",
        "https://blog.res.jianchengwang.info/girls/xiangxiang.jpg",
        "遥远的21世纪",
        "冰箱上的女人"
    ),
    Girl(
        "陆老大",
        "https://blog.res.jianchengwang.info/girls/lulaoda.jpg",
        "遗失过去某个时空",
        "毕竟初恋"
    ),
    Girl(
        "御坂美琴",
        "https://blog.res.jianchengwang.info/girls/yubanmeiqin.png",
        "某科学的超电磁炮",
        "bilibili"
    ),
    Girl(
        "白井黑子",
        "https://blog.res.jianchengwang.info/girls/baijingheizi.jpg",
        "某科学的超电磁炮",
        "姐姐大人"
    ),
    Girl(
        "佐天泪子",
        "https://blog.res.jianchengwang.info/girls/zuotianleizi.jpg",
        "某科学的超电磁炮",
        "掀裙狂魔泪爷"
    ),
    Girl(
        "茵蒂克丝",
        "https://blog.res.jianchengwang.info/girls/index.jpg",
        "魔法禁书目录",
        "咬他"
    ),
    Girl(
        "冯宝宝",
        "https://blog.res.jianchengwang.info/girls/fengbaobao.jfif",
        "一人之下",
        "埋他"
    ),
    Girl(
        "阿库娅",
        "https://blog.res.jianchengwang.info/girls/aqua.png",
        "为美好的世界献上祝福",
        "汝，虔诚的教徒啊"
    ),
    Girl(
        "惠惠",
        "https://blog.res.jianchengwang.info/girls/huihui.jpg",
        "为美好的世界献上祝福",
        "为万恶的人设献上爆炎"
    ),
    Girl(
        "赤瞳",
        "https://blog.res.jianchengwang.info/girls/chitong.jfif",
        "斩·赤红之瞳",
        "葬送，一斩必杀"
    ),
    Girl(
        "玛茵",
        "https://blog.res.jianchengwang.info/girls/mayin.jpeg",
        "斩·赤红之瞳",
        "傲娇即是正义"
    ),
    Girl(
        "三笠",
        "https://blog.res.jianchengwang.info/girls/sanli.jpg",
        "进击的巨人",
        "刚毅温柔女汉子"
    ),
    Girl(
        "祢豆子",
        "https://blog.res.jianchengwang.info/girls/midouzi.jpg",
        "鬼灭之刃",
        "早....早上好"
    ),
    Girl(
        "洛琪希",
        "https://blog.res.jianchengwang.info/girls/luoqixi.jfif",
        "无职转生",
        "小师傅，萌萌哒"
    ),
    Girl(
        "结城明日奈",
        "https://blog.res.jianchengwang.info/girls/jiechengmingrinai.jpg",
        "刀剑神域",
        "做饭好手"
    ),
    Girl(
        "桐谷直叶",
        "https://blog.res.jianchengwang.info/girls/tongguzhiye.jpg",
        "刀剑神域",
        "兄控莉法桑"
    ),
    Girl(
        "司空千落",
        "https://blog.res.jianchengwang.info/girls/sikongqianluo.jpg",
        "少年歌行",
        "我以一枪入逍遥"
    ),
    Girl(
        "石兰",
        "https://blog.res.jianchengwang.info/girls/shilan.jfif",
        "秦时明月",
        "虞姬虞姬"
    ),
    Girl(
        "白月魁",
        "https://blog.res.jianchengwang.info/girls/baiyuekui.jfif",
        "灵笼",
        "白老板，YYDS"
    ),
)

@Immutable
data class Blog(
    var title: String = "",
    var createdAt: String = "",
    var tags: List<String> = emptyList(),
    var draft: Boolean = false,
    var markdownFile: String = ""
)
var techs: ArrayList<Blog> = arrayListOf(
    Blog(
        "image-similarity-flask",
        "2021-10-28",
        tags = listOf("ml"),
        markdownFile = "image-similarity-flask.md"
    ),
    Blog(
        "hardhat-bsc-demo",
        "2021-09-29",
        tags = listOf("blockchain"),
        markdownFile = "hardhat-bsc-demo.md"
    ),
    Blog(
        "hyperledger-fabric",
        "2021-09-22",
        tags = listOf("blockchain"),
        markdownFile = "hyperledger-fabric.md"
    ),
    Blog(
        "window-terminal",
        "2021-06-28",
        tags = listOf("terminal"),
        markdownFile = "window-terminal.md"
    ),
    Blog(
        "coderunner",
        "2021-05-25",
        tags = listOf("go"),
        markdownFile = "coderunner.md"
    ),
    Blog(
        "ext-webcomponents-vue",
        "2021-04-24",
        tags = listOf("js", "vue"),
        markdownFile = "ext-webcomponents-vue.md"
    ),
    Blog(
        "mac-m1",
        "2021-03-02",
        tags = listOf("mac"),
        markdownFile = "mac-m1.md"
    ),
    Blog(
        "elastic-stack",
        "2021-02-26",
        tags = listOf("elastic"),
        markdownFile = "elastic-stack.md"
    ),
    Blog(
        "java-source-base",
        "2021-02-08",
        tags = listOf("java"),
        markdownFile = "java-source-base.md"
    ),
    Blog(
        "idea",
        "2021-02-08",
        tags = listOf("idea"),
        markdownFile = "idea.md"
    ),

    Blog(
        "build-my-site",
        "2020-12-23",
        tags = listOf("mysite"),
        markdownFile = "build-my-site.md"
    ),
    Blog(
        "flask-todolist",
        "2020-11-28",
        tags = listOf("flask"),
        markdownFile = "flask-todolist.md"
    ),
    Blog(
        "intro-to-serverless-functions",
        "2020-11-13",
        tags = listOf("serverless"),
        markdownFile = "intro-to-serverless-functions.md"
    ),
    Blog(
        "flink",
        "2020-11-12",
        tags = listOf("serverless"),
        markdownFile = "flink.md"
    ),
    Blog(
        "live2d-web",
        "2020-10-25",
        tags = listOf("live2d"),
        markdownFile = "live2d-web.md"
    ),
    Blog(
        "git",
        "2020-10-09",
        tags = listOf("git"),
        markdownFile = "git.md"
    ),
    Blog(
        "pandas",
        "2020-10-06",
        tags = listOf("pandas"),
        markdownFile = "pandas.md"
    ),
    Blog(
        "intro-to-vue",
        "2020-09-13",
        tags = listOf("vue"),
        markdownFile = "intro-to-vue.md"
    ),
    Blog(
        "docker",
        "2020-09-10",
        tags = listOf("docker"),
        markdownFile = "docker.md"
    ),
    Blog(
        "tlcl",
        "2020-07-18",
        tags = listOf("tlcl"),
        markdownFile = "tlcl.md"
    ),
    Blog(
        "gradle",
        "2020-06-09",
        tags = listOf("gradle"),
        markdownFile = "gradle.md"
    ),
    Blog(
        "electron-vue",
        "2020-04-20",
        tags = listOf("vue"),
        markdownFile = "electron-vue.md"
    ),
    Blog(
        "redis",
        "2020-03-10",
        tags = listOf("redis"),
        markdownFile = "redis.md"
    ),
    Blog(
        "kafka",
        "2020-02-09",
        tags = listOf("kafka"),
        markdownFile = "kafka.md"
    ),
    Blog(
        "java-thread",
        "2020-01-03",
        tags = listOf("java"),
        markdownFile = "java-thread.md"
    ),

    Blog(
        "es6",
        "2019-12-09",
        tags = listOf("es6"),
        markdownFile = "es6.md"
    ),
    Blog(
        "this-in-javascript",
        "2019-12-09",
        tags = listOf("es6"),
        markdownFile = "this-in-javascript.md"
    ),
    Blog(
        "functional-programming-in-javascript",
        "2019-12-05",
        tags = listOf("es6"),
        markdownFile = "functional-programming-in-javascript.md"
    ),
    Blog(
        "centos7",
        "2019-11-28",
        tags = listOf("linux"),
        markdownFile = "centos7.md"
    ),
    Blog(
        "canal",
        "2019-11-20",
        tags = listOf("canal"),
        markdownFile = "canal.md"
    ),
    Blog(
        "curl",
        "2019-11-20",
        tags = listOf("linux"),
        markdownFile = "curl.md"
    ),
    Blog(
        "ssh",
        "2019-11-10",
        tags = listOf("linux"),
        markdownFile = "ssh.md"
    ),
    Blog(
        "debian",
        "2019-10-09",
        tags = listOf("linux"),
        markdownFile = "debian.md"
    ),
    Blog(
        "manjaro",
        "2019-09-20",
        tags = listOf("linux"),
        markdownFile = "manjaro.md"
    ),
    Blog(
        "nacos",
        "2019-08-19",
        tags = listOf("nacos"),
        markdownFile = "nacos.md"
    ),
    Blog(
        "java8",
        "2019-06-09",
        tags = listOf("java"),
        markdownFile = "java8.md"
    ),
)
var stores: ArrayList<Blog> = arrayListOf(
    Blog(
        "断刀残雪",
        "2015-10-10",
        tags = listOf("武侠"),
        markdownFile = "断刀残雪.md"
    ),
    Blog(
        "明月泪",
        "2015-10-09",
        tags = listOf("武侠"),
        markdownFile = "明月泪.md"
    ),
    Blog(
        "温柔刀",
        "2015-09-10",
        tags = listOf("武侠"),
        markdownFile = "温柔刀.md"
    ),
    Blog(
        "长安乱",
        "2015-06-01",
        tags = listOf("武侠"),
        markdownFile = "长安乱.md"
    ),
    Blog(
        "大荒",
        "2014-09-10",
        tags = listOf("武侠"),
        markdownFile = "大荒.md"
    ),
)

@Immutable
data class Book(
    var title: String = "",
    var coverImageUrl: String = "",
    var bookUrl: String = ""
)
