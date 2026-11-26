# 仓库协作指南

## 项目用途

本项目用于学习和验证不同 JDK 版本的新特性。示例按版本划分为 Maven 模块，特性介绍见 `README.md`。

JUnit 5 示例主要位于各模块的 `src/test/java/com/tynet/SimpleTest.java`。

## 构建与测试

在仓库根目录执行 Maven 命令。依赖版本由根 `pom.xml` 管理。Maven Wrapper 固定使用 Maven 3.10.2。

- 用 `mvn -version` 确认 Maven 使用的 JDK。各模块的目标版本以 POM 为准。
- 默认执行 `package`。显式执行 `install` 时也默认跳过本地安装。
- `features-17` 默认运行测试。其他模块运行测试时加上 `-Dmaven.test.skip=false`。

```text
# features-9-jpms-consumer 依赖 features-9-jpms-library，使用 -am 一并编译
mvn -pl features-9-jpms-consumer -am compile
mvn -pl features-17 "-Dtest=SimpleTest" test
```

## 代码约定

遵循 `.editorconfig`，使用 UTF-8 和 LF，Java 和 XML 缩进 4 个空格。新增模块时，在根 POM 的 `<modules>` 中注册。

通用模块使用 `features-<版本>`。专题模块使用 `features-<版本>-<主题>`，同一专题拆成多个模块时使用 `features-<版本>-<主题>-<角色>`。目录名与 Maven `artifactId` 一致。
