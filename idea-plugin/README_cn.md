> 首先非常感谢大家对插件的支持与意见，英文版的文档还是略为简单，这里详细介绍一下插件的安装使用。

## 插件安装
### 通过Jetbrains官方仓库安装
1. 打开 Settings >> Plugins >> Browse repositories...

![](https://gw.alicdn.com/tfscom/TB1Qn83ifBNTKJjy1zdXXaScpXa.png)
 
2. 在搜索框输入alibaba即可看到Alibaba Java Code Guidelines插件，点击Install进行安装，然后重启IDE生效 `注意：因为插件zip包托管在Jetbrains官方CDN上，所以是从国外的服务器进行下载，可能会出现超时的情况`

![](https://gw.alicdn.com/tfscom/TB1vcGbmYsTMeJjy1zcXXXAgXXa.png)

### 通过下载安装包进行安装
1. 打开[插件](https://plugins.jetbrains.com/plugin/10046-alibaba-java-coding-guidelines)页面

![download](https://gw.alicdn.com/tfscom/TB1WcF3hzlxYKJjSZFuXXaYlVXa.png)

2. Settings >> Plugins >> Install plugin from disk...，选择刚刚下载的zip包安装，然后重启IDE

![](https://gw.alicdn.com/tfscom/TB1WFsKiqigSKJjSsppXXabnpXa.png)


### 注意

最低支持IDEA版本为14.1（buildNumber 141.0，可以在About Intellij IDEA中查看版本信息），使用IDEA14的同学最好升级到14.1.7(<a href="https://www.jetbrains.com/idea/download/previous.html" target="_blank">历史版本传送门</a>)

插件基于JDK1.7打包，所以IDEA启动时使用的JDK版本如果是1.6的话就会报Unsupported major.minor version 51.0异常，建议大家都升级一下。

### [中文乱码解决方法](https://github.com/alibaba/p3c/issues/32#issuecomment-336762512)

1. 修改字体——Appearance&Behavior -> Appearance -> UI Options -> Name 里面设置成中文字体——如微软雅黑（microsoft yahei light）、文泉驿(linux)

![](https://gw.alicdn.com/tfscom/TB14wTmm3oQMeJjy0FoXXcShVXa.png) 

2. Switch Language to English and restart.

![](https://gw.alicdn.com/tfscom/TB1Z6u1mYsTMeJjSszhXXcGCFXa.png) 
	   

## 插件使用

目前插件实现了开发手册中的的53条规则，大部分基于PMD实现，其中有4条规则基于IDEA实现，并且基于IDEA <a href="https://www.jetbrains.com/help/idea/code-inspection.html" target="_blank">Inspection</a>实现了实时检测功能。部分规则实现了Quick Fix功能，对于可以提供Quick Fix但没有提供的，我们会尽快实现，也欢迎有兴趣的同学加入进来一起努力。
目前插件检测有两种模式：实时检测、手动触发。

### 实时检测
实时检测功能会在开发过程中对当前文件进行检测，并以高亮的形式提示出来，同时也可以支持Quick Fix，该功能默认开启，可以通过配置关闭。 

#### 结果高亮提示

<p style="text-indent:2em">检测结果高亮提示，并且鼠标放上去会弹出提示信息。</p>

![](https://gw.alicdn.com/tfscom/TB17wt3mYsTMeJjSszdXXcEupXa.png)

![](https://gw.alicdn.com/tfscom/TB1Rq85ifNNTKJjSspkXXaeWFXa.png)

#### <a href="https://www.jetbrains.com/help/idea/intention-actions.html" target="_blank">Intention</a> QuickFix功能

Alt+Enter键可呼出Intention菜单，不同的规则会提示不同信息的Quick Fix按钮

![](https://gw.alicdn.com/tfscom/TB1twLMsOAKL1JjSZFoXXagCFXa.png)

#### 关闭实时检测  
在某些情况下，我们不希望对代码提示违规信息，比如我们在阅读Github开源项目代码的时候，如果界面出现一堆红色、黄色的提示，此时心里肯定是飘过一万只草泥马。这个时候我们可以通过Inspection的设置关闭实时检测功能。
1. 通过右键快速关闭（打开）所有规则的实时检测功能

![](https://gw.alicdn.com/tfscom/TB1dBbDe_1z01JjSZFCXXXY.XXa.png)

2. 通过Settings >> Editor >> Inspections 进行手动设置  

![](https://gw.alicdn.com/tfscom/TB1zhCBsiFTMKJjSZFAXXckJpXa.png)

也可以关闭某条规则的实时检测功能或者修改提示级别。
   
### 代码扫描

可以通过右键菜单、Toolbar按钮、快捷键三种方式手动触发代码检测。同时结果面板中可以对部分实现了QuickFix功能的规则进行快速修复。 

#### 触发扫描
在当前编辑的文件中点击右键，可以在弹出的菜单中触发对该文件的检测。

![](https://gw.alicdn.com/tfscom/TB1Wj49mYsTMeJjSszdXXcEupXa.png)
   
在左侧的Project目录树种点击右键，可以触发对整个工程或者选择的某个目录、文件进行检测。

![](https://gw.alicdn.com/tfscom/TB1h_XciWmgSKJjSspiXXXyJFXa.png)
   
   如果您打开了IDE的Toolbar，也可以通过Toolbar中的按钮来触发检测，目前Toolbar的按钮触发的检测范围与您IDE当时的焦点有关，如当前编辑的文件或者是Project目录树选中的项，是不是感觉与右键菜单的检测范围类似呢。

![](https://gw.alicdn.com/tfscom/TB1q3Nfi6uhSKJjSspmXXcQDpXa.png)
   使用快捷键（Ctrl+Shift+Alt+J）触发弹出窗口，选择检测范围；您也可自定义快捷键。

![](https://gw.alicdn.com/tfscom/TB1k4uXmYwTMeJjSszfXXXbtFXa.png) 
   
![](https://gw.alicdn.com/tfscom/TB1ObqXifxNTKJjy0FjXXX6yVXa.png)
   
#### 扫描结果  
检测结果直接使用IDEA Run Inspection By Name功能的结果界面，插件的检测结果分级为Blocker、Critical、Major、Warning、Weak Warning。默认按等级分组，方便统计每个级别错误的数量。

![](https://gw.alicdn.com/tfscom/TB1aC1yifJNTKJjSspoXXc6mpXa.png)

其中，Blocker、Critical、Major三个级别保持与阿里巴巴官方版相同，不会轻易改变。如果未来需要改变，则必须在此Readme中注明。

看见有人做了比较有道理的第三方规则的话，会是视情况加入Warning或者Weak Warning。

如无例外，一个第三方规则如果在任何情况下都能够执行，即程序员完全可以实现不违背该规则实现任何功能，则这个规则会被放入Warning。

与之相对的，如果存在特定的条件，使得若需要满足特定条件则必须违背该规则，即程序员存在必须违背该规则的场景，则这个规则会被放入Weak Warning。

如果要使用pmd maven plugin对代码进行自动检查以确保不违反阿里巴巴Java开发手册，

则请设置`<failurePriority>3</failurePriority>`，以保证与官方版本规则吻合。

使用例可见`p3c-pmd/pom.xml`

默认情况我们在结果面板需要双击具体违规项才能打开对应的源文件，开启Autoscroll To Source选项，单击面板中的文件名、或者是具体的违规项的时候IDEA会自动打开对应的源文件。

![](https://gw.alicdn.com/tfscom/TB1aIixmYsTMeJjy1zcXXXAgXXa.png)
 
#### QuickFix
对于实现Quick Fix的规则，在结果面板中可以直接一键修复 `注意：IDEA14、15可以通过左下角的灯泡进行一键修复操作。`

![](https://gw.alicdn.com/tfscom/TB1Kw5Vm3oQMeJjy0FpXXcTxpXa.png)
   
![](https://gw.alicdn.com/tfscom/TB1lHZZiGagSKJjy0FbXXa.mVXa.png)
   
#### 其他
面板中其他按钮的功能大家自行探索吧，就不一一赘述了

### 代码提交时检测
1. 在提交代码框勾选Alibaba Code Guidelines选项
![](https://gw.alicdn.com/tfscom/TB1u_ZZjamgSKJjSspiXXXyJFXa.png)
2. 如果有违反手册的地方会提示是否继续提交，选择取消后会自动对修改的代码进行扫描
![](https://gw.alicdn.com/tfscom/TB1r5PUXbb85uJjSZFmXXcgsFXa.png)

## 设置文件机制
### 文件目录
对于p3c idea插件来说，配置文件存放的位置为项目根目录下的p3c_config.x8l文件。

对于maven项目来说，配置文件存放的位置为运行mvn的目录下的p3c_config.x8l文件。

经常的，这两个位置指向同一个位置。

### 文件格式
文件格式为 [x8l](https://github.com/cyanpotion/x8l).

### 文件描述

举个例子，以 [cyan_potion](https://github.com/cyanpotion/cyan_potionp3c_config.x8l) 为例，
我们来看如何配置p3c_config.x8l

首先，p3c_config.x8l位于项目根目录。

```
<com.alibaba.p3c.pmd.config version=0.0.1>
    <rule_config>
        <LowerCamelCaseVariableNamingRule>
            <WHITE_LIST [>
                DAOImpl&
                GLFW&
                URL&
                URI&
                XInput&
                PosX&
                PosY&
                AWT&
                XY&
                drawBoxTC&
                FPS&
                ID&
                lastX&
                lastY&
            >
        >
        <ClassNamingShouldBeCamelRule>
            <CLASS_NAMING_WHITE_LIST [>
                Hbase&
                HBase&
                ID&
                ConcurrentHashMap&
                GLFW&
                URL&
                URI&
                JXInput&
                SettingFileParser_
            >
        >
    >
    <rule_blacklist [>
        PackageNamingRule&
        AbstractClassShouldStartWithAbstractNamingRule&
        ThreadPoolCreationRule&
        MethodTooLongRule&
    >
    <class_blacklist [>
        Console
    >
	<package_blacklist [>
        com.xenoamess.cyan_potion.base.steam
    >
    <rule_class_pair_blacklist>
        <JamepadGamepadKeyEnum [>EnumConstantsMustHaveCommentRule>
        <JXInputGamepadKeyEnum [>EnumConstantsMustHaveCommentRule>
        <KeyActionEnum [>EnumConstantsMustHaveCommentRule>
        <KeyboardKeyEnum [>EnumConstantsMustHaveCommentRule>
        <CodePluginPosition [>EnumConstantsMustHaveCommentRule>
        <ShapeRelation [>EnumConstantsMustHaveCommentRule>

        <WaveData [>UndefineMagicConstantRule>

        <FileUtils [>AvoidUseDeprecationRule>

        <Font [>AvoidUseDeprecationRule>
        <Keymap [>AvoidUseDeprecationRule>
        <WorldForDemo [>AvoidUseDeprecationRule>

        <GameInputManager [>LowerCamelCaseVariableNamingRule&AvoidUseDeprecationRule>

        <Colors [>ConstantFieldShouldBeUpperCaseRule>
    >
>
```

其中，根节点名必为com.alibaba.p3c.pmd.config 。

属性version=0.0.1为配置文件version，目前尚未实际应用，但是建议写明，以防后续破坏性更新。

对于这个项目，方便/美观起见，我们开启了trim，所有读取的String会被trim，然后再进行处理。

例如，

```
    <class_blacklist>
        Console
    >
```

中的TextNode

```

        Console
    
```

会被trim为`Console`然后使用。

com.alibaba.p3c.pmd.config节点下有四个子节点，以下依次讲解。

### rule_config

rule_config节点主要包括对于提供了设置属性的规则的具体设置。

如，LowerCamelCaseVariableNamingRule的WHITE_LIST属性。

该属性要求提供一字符串List，则本项目中读取一个ContentNode下多个TextNode转换为字符串List。

### rule_blacklist

rule_blacklist节点主要包括对该项目的所有类禁用某一规则。

如，rule_blacklist中含有PackageNamingRule，则表明该项目中，检测器不会检测PackageNamingRule。

rule_blacklist中的Rule类名既可以是SimpleName，也可以是CanonicalName。

### class_blacklist

class_blacklist节点主要包括对该项目中的某一类禁用所有规则。

如，class_blacklist中含有Console类，则该项目中所有名为Console的类均不会进行任何检测。

注意，由于PMD技术原因，class_blacklist中的类必须为SimpleName

### package_blacklist

package_blacklist节点主要包括对该项目中的某一个父包禁用所有规则。

如，package_blacklist中含有`com.xenoamess`包，则该项目中所有`com.xenoamess`包下的类均不会进行任何检测。

注意，形如`com.xenoamess.cyan_potion`的，`com.xenoamess`包的子包也会被禁用所有规则。

### rule_class_pair_blacklist

rule_class_pair_blacklist节点主要包括对该项目中的某一类禁用某数个规则。

如，rule_class_pair_blacklist中含有

`<GameInputManager>LowerCamelCaseVariableNamingRule&AvoidUseDeprecationRule>`

，
则该项目中所有名为GameInputManager的类中，LowerCamelCaseVariableNamingRule与AvoidUseDeprecationRule不会被检测。

Rule类名既可以是SimpleName，也可以是CanonicalName。
注意，由于PMD技术原因，被忽略检测的类名必须为SimpleName。

### 为了反X8L主义者干杯

如果你确实讨厌X8L文件格式，你可以使用等价json格式配置文件。

```json
{
  "com.alibaba.p3c.pmd.config": {
    "_attributes": {
      "version": "0.0.1"
    },
    "rule_config": {
      "LowerCamelCaseVariableNamingRule": {
        "WHITE_LIST": [
          "DAOImpl",
          "GLFW",
          "URL",
          "URI",
          "XInput",
          "PosX",
          "PosY",
          "AWT",
          "XY",
          "drawBoxTC",
          "FPS",
          "ID",
          "lastX",
          "lastY"
        ]
      },
      "ClassNamingShouldBeCamelRule": {
        "CLASS_NAMING_WHITE_LIST": [
          "Hbase",
          "HBase",
          "ID",
          "ConcurrentHashMap",
          "GLFW",
          "URL",
          "URI",
          "JXInput",
          "SettingFileParser_"
        ]
      }
    },
    "rule_blacklist": [
      "PackageNamingRule",
      "AbstractClassShouldStartWithAbstractNamingRule",
      "ThreadPoolCreationRule",
      "MethodTooLongRule"
    ],
    "class_blacklist": [
      "Console"
    ], 
	"package_blacklist": [
	  "com.xenoamess.cyan_potion.base.steam"
	],
    "rule_class_pair_blacklist": {
      "JamepadGamepadKeyEnum": [
        "EnumConstantsMustHaveCommentRule"
      ],
      "JXInputGamepadKeyEnum": [
        "EnumConstantsMustHaveCommentRule"
      ],
      "KeyActionEnum": [
        "EnumConstantsMustHaveCommentRule"
      ],
      "KeyboardKeyEnum": [
        "EnumConstantsMustHaveCommentRule"
      ],
      "CodePluginPosition": [
        "EnumConstantsMustHaveCommentRule"
      ],
      "ShapeRelation": [
        "EnumConstantsMustHaveCommentRule"
      ],
      "WaveData": [
        "UndefineMagicConstantRule"
      ],
      "FileUtils": [
        "AvoidUseDeprecationRule"
      ],
      "Font": [
        "AvoidUseDeprecationRule"
      ],
      "Keymap": [
        "AvoidUseDeprecationRule"
      ],
      "WorldForDemo": [
        "AvoidUseDeprecationRule"
      ],
      "GameInputManager": [
        "LowerCamelCaseVariableNamingRule",
        "AvoidUseDeprecationRule"
      ],
      "Colors": [
        "ConstantFieldShouldBeUpperCaseRule"
      ]
    }
  }
}
```

文件名为p3c_config.json即可。
