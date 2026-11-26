# jdk-features

------------------

## 介绍

按版本整理 Java 语言、标准库和运行时的新特性。

- [JDK 增强提案（JEP）](https://openjdk.org/jeps)
- [Java 规范请求（JSR）](https://jcp.org/en/jsr/)
- [OpenJDK 项目](https://openjdk.org/projects/jdk/)
- [OpenJDK 下载](https://jdk.java.net/)
- [JDK 发行说明](https://www.oracle.com/java/technologies/javase/jdk-relnotes-index.html)
- [Oracle Java SE 支持路线图（LTS）](https://www.oracle.com/java/technologies/java-se-support-roadmap.html)

> 使用 `java -XshowSettings:properties -version` 查看 JDK 属性。

## 新特性

### JDK 9

- Java 平台模块系统（JPMS） [JEP 261](https://openjdk.org/jeps/261)
- JShell 交互式工具
- `javac --release` 支持面向旧版 Java 编译 [JEP 247](https://openjdk.org/jeps/247)
- 多版本 JAR [JEP 238](https://openjdk.org/jeps/238)
- 集合工厂方法
- 接口私有方法
- 紧凑字符串（Compact Strings）
- Stream API 增强
- `try-with-resources` 增强
- 匿名类支持菱形运算符 `<>`
- 锁竞争优化

### JDK 10

- 局部变量类型推断（`var`）

### JDK 11

- Lambda 形参支持 `var`，便于标注注解
- 移除 Java EE 和 CORBA 模块 [JEP 320](https://openjdk.org/jeps/320)
- 标准 HTTP 客户端（`java.net.http`） [JEP 321](https://openjdk.org/jeps/321)

### JDK 12

- `switch` 表达式（预览，使用 `break value`） [JEP 325](https://openjdk.org/jeps/325)

### JDK 13

- `switch` 表达式（第二次预览，引入 `yield`） [JEP 354](https://openjdk.org/jeps/354)
- 文本块（预览）

### JDK 14

- `switch` 表达式
- `record` 记录类（预览）
- `instanceof` 模式匹配（预览）

### JDK 15

- 文本块
- 密封类（预览）
- 隐藏类

### JDK 16

- `record` 记录类
- `instanceof` 模式匹配
- 密封类（第二次预览）
- Stream API 新增 `toList()` 和 `mapMulti()` [Stream API](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/Stream.html)

### JDK 17

- 密封类
- `switch` 模式匹配（预览）

### JDK 18

- `switch` 模式匹配（第二次预览）
- UTF-8 成为标准 Java API 的默认字符集 [JEP 400](https://openjdk.org/jeps/400)

### JDK 19

- `switch` 模式匹配（第三次预览）

### JDK 21

- 记录模式与 `switch` 模式匹配 [JEP 440](https://openjdk.org/jeps/440) · [JEP 441](https://openjdk.org/jeps/441)
- 有序集合（Sequenced Collections） [JEP 431](https://openjdk.org/jeps/431)
- 虚拟线程 [JEP 444](https://openjdk.org/jeps/444)

### JDK 22

- 未命名变量与模式（`_`） [JEP 456](https://openjdk.org/jeps/456)

### JDK 24

- Stream Gatherers [JEP 485](https://openjdk.org/jeps/485)
- 虚拟线程在 `synchronized` 中阻塞时可释放承载线程 [JEP 491](https://openjdk.org/jeps/491)

### JDK 25

- 作用域值（`ScopedValue`） [JEP 506](https://openjdk.org/jeps/506)
- 模块导入声明（`import module`） [JEP 511](https://openjdk.org/jeps/511)
- 紧凑源文件与实例 `main` 方法 [JEP 512](https://openjdk.org/jeps/512)
- 灵活构造器体 [JEP 513](https://openjdk.org/jeps/513)
