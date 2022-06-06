/**
 * 模块化 <p>模块的读取关系默认不传递
 *
 * @author Created by 思伟 on 2022/5/31
 */
module features_9_1 {
    // 可选依赖项
    requires static org.jetbrains.annotations;
    requires static lombok;

    // 可传递的依赖模块
    requires transitive org.apache.commons.lang3;

    exports com.tynet.module.demo.domain;

    // 模块之间共享代码
    exports com.tynet.module.demo.hessian to
            com.tynet.common,
            com.tynet.filestore,
            com.tynet.runtime,
            statistics;
}
