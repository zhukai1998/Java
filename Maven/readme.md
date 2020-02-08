# 为什么要 Maven
- 在开发中经常需要依赖第三方的包，包与包之间存在依赖关系，版本间还有兼容性问题，有时还要把旧的包升级或者降级，当项目复杂到一定程度时包管理变得非常重要
- Maven 做的事: 

|编号|事务|
|--------------|--------------------|
|            1 | 统一开发规范与工具 |
|            2 | 统一管理 jar 包    |

- Maven 提供的功能：

| 编号 |    功能    |
|------|------------|
|    1 | 依赖的管理 |
|    2 | 项目的构建 |
|    3 | 项目的知识管理           |

# Maven 安装
- 下载：[http://maven.apache.org/download.cgi]
- 配置环境变量 `$MAVEN_HOME/bin`
- 验证 mvn -version
- 本地仓库配置 `vim conf/setting.xml` 编辑 `<localRepository>`
- 中央仓库配置 `vim conf/setting.xml` 编辑 `<mirrors>`
```
<mirrors>
	<mirror>
		<id>nexus-aliyun</id>
		<mirrorOf>*,!jeecg,!jeecg-snapshots</mirrorOf>
		<name>Nexus aliyun</name>
		<url>http://maven.aliyun.com/nexus/content/groups/public</url>
	</mirror>
</mirrors>
```

# 命令行创建 maven 项目 - 方式一
- `mvn archetype:generate`
- 选择骨架（模版），可默认缺省
- 输入相关信息，并确认下载
- 进入项目文件夹内
- 将项目转换为 IDEA 项目 `mvn idea:idea`

# 命令行创建 maven 项目 - 方式二
-  输入命令
```
mvn archetype:generate -DgroupId=包名 -DartifactId=项目名 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
- 进入项目文件夹内

# Maven 名词解释
- POM(Project Object Model)项目对象模型
```
Maven 项目对象模型，可以通过一小段描述信息来管理项目的构建，报告和文档的软件项目管理工具。
POM 与 Java 代码实现了解耦，当需要升级版本时，只需修改 POM。而在 POM 稳定后，日常的 Java 代码开发基本不涉及 POM 的修改。
```
- 坐标
```
groupId, artifactId, version 三个元素是项目的坐标，唯一的标识这个项目
groupId 项目所在组，一般是组织或公司
artifactId 是当前项目在组的唯一 ID
version 表示版本，SNAPSHOT 表示快找，表示此项目还在开发中，不稳定
groupId 和实际项目不一定是一一对应的，maven 有模块的概念，例如 spring-core, spring-context... groupId 也不应该只对应公司或组织名，建议具体到项目名，因为公司或者组织下有多个项目，而 artifactId 只能代表模块名
```
- 依赖范围
```
compile 编译，测试，运行都有效，默认的选择
test 测试有效，例如 junit
provided 编译，测试有效，例如 servlet，运行时容器会提供实现
runtime 运行和测试有效，例如 jdbc，编译时只需相应的接口，测试和运行时才需要具体的实现
system 编译，测试有效。使用此范围的依赖必须通过 systemPath 元素显式的指定依赖文件，因而此类依赖是不通过 Maven 仓库解析的，一般适合于本机测试环境下，依赖本地起的服务。
```
- 构建
`maven 支持许多种的应用程序类别，对于每一种支持的应用程序类型都定义好了一组构建规则和工具集`
- 输出管理
`maven 可以管理项目构建的产物，并将其加入到用户库中。这个功能可以用于项目组和其他部门之间的交付行为`
- 依赖关系
`maven 对依赖关系的特性进行细致的分析和划分，避免开发过程中的依赖混乱和互相污染行为`
- 文档和构建结果
`maven 的 site 命令支持各种文档信息的发布，包括构建过程的各种输出，javadoc，产品文档等`
- 项目关系
`一个大型的项目通常有几个小项目或者模块组成，用 maven 可以很方便地管理`
- 移植性管理
`maven 可以针对不同的开发场景，输出不同种类的输出结果`

# POM 文档对象模型
`POM 是 Maven 的核心，它是指示 Maven 如何工作的元数据文件。pom.xml 位于每个 Project 的根目录`
- GroupId 组织号
- ArtifactId 项目名
- Packaging 打包为 jar、war、rar、ear、pom，缺省为 jar
- Version 版本，项目的唯一标识由 groupId + artifactId + packaging + version 组成
- Dependency 依赖
- Plug-in 插件
- Repository 仓库，用来存放 artifact 的，可以是本地仓库，也可以是远程仓库
- Snapshot 快照。工程中可以有这样一个特殊的版本：这个版本告诉 Maven，该工程处于开发阶段，会经常更新。当其他工程依赖此类型的 artifact 时，Maven 会在仓库中寻找该 artifact 的最新版本，并自动下载，使用最新版本。

# Maven 的生命周期
- maven 把项目的构建划分为不同的生命周期。过程包括：编译、测试、打包、集成测试、验证、部署。maven 中所有的执行动作都需要指明自己在这个过程中的执行位置，然后 Maven 执行的时候，就依照过程的发展依次调用这些 goal 进行各种处理。这也是 Maven 的一个基本调度机制，一般来说，位置稍后的过程都会依赖于之前的过程，当然 maven 同样提供了配置文件，可以依照用户要求，跳过某些阶段
- 三种生命周期

| 编号 |        名称       |                    说明                    |
|------|-------------------|--------------------------------------------|
|    1 | Clean Lifecycle   | 在进行真正的构建之前进行一些清理工作       |
|    2 | Default Lifecycle | 构建的核心部分：编译、测试、打包、部署等等 |
|    3 | Site Lifecycle    | 生成项目报告，站点，发布站点                                           |

- clean 生命周期
`执行阶段描述说明 pre-clean 在实际的项目清理之前执行所需的过程 clean 删除前一个构建生成的所有文件 post-clean 执行完成项目清理所需的过程`

- default 生命周期
`执行阶段描述说明 validate 验证项目是正确的，所有必要的信息都是可用的。initialize 初始化构建状态，例如设置属性或创建目录略`

# 笔记
- Maven 的约束优于配置，其策略可以减少修改配置的工作量，也可以降低学习成本，更重要的是，给项目引入了统一的规范
- Maven 的版本规范。Maven 判断版本的算法是 major、minor、incremeneta部分用数字比较，qualifier 部分用字符串比较，所以熬心 alpha-2 和 alpha-15 的比较关系，最好用 alpha-02 的格式
- Maven 版本管理时候的特殊字符串

|   名称   |                                说明                                |
|----------|--------------------------------------------------------------------|
| SNAPSHOT | 开发过程中，表示不稳定版本                                         |
| LATSET   | 某个特定构件的最新发布，可能是一个发布版，也可能是一个 snapshot 版 |
| RELEASE  | 仓库中最后的一个非快照版本                                                                   |

1、同一项目中所有模块版本保持一致
2、子模块统一继承父模块的版本
3、统一在顶层模块 pom 的 <dependencyManagement/> 节中定义所有子模块的依赖版本号，子模块中添加依赖时不要添加版本号
4、开发测试阶段使用 SNAPSHOT
5、生产发布使用 RELEASE
6、新版本迭代只修改顶层 POM 中的版本
