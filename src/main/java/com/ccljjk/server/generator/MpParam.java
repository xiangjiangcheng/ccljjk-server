package com.ccljjk.server.generator;

import lombok.Data;

/**
 * 代码生成所需要的上下文参数
 */
@Data
public class MpParam {

    /**
     * 移除表前缀
     */
    private String[] removeTablePrefix = {""};

    /**
     * 包含的表名称
     */
    private String[] includeTables;

    /**
     * 是否生成service的接口
     */
    private Boolean generatorInterface = true;

}
