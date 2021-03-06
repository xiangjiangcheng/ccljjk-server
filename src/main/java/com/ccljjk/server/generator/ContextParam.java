package com.ccljjk.server.generator;

import lombok.Data;

/**
 * 代码生成所需要的上下文参数
 */
@Data
public class ContextParam {

    /**
     * jdbc连接的驱动名称
     */
    private String jdbcDriver;

    /**
     * 数据库连接的url
     */
    private String jdbcUrl;

    /**
     * 数据库用户名
     */
    private String jdbcUserName;

    /**
     * 数据库连接的密码
     */
    private String jdbcPassword;

    /**
     * 代码生成路径
     */
    private String outputPath = "temp";

    /**
     * 项目的包路径
     */
    private String proPackage;

    /**
     * 代码生成作者
     */
    private String author = "Tom";

    /**
     * 模块名称
     */
    private String modularName;

}
