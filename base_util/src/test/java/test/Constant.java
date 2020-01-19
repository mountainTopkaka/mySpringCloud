package test;

/**
 * Created by 肖利军 on 2018/10/29.
 */
public class Constant {
    /**
     *  生成代码的包路径
     */
    public static final String GENERATOR_SYS_PARENT_PATH = "com.ict.system";
    
    public static final String GENERATOR_MODULE_PARENT_PATH = "com.ict.module";
    
    /**
     * 控制层包路径
     */
    public static final String GENERATOR_CONTROLLER_PATH = "controller";
    
    /**
     * 服务层接口类包路径
     */
    public static final String GENERATOR_SERVICE_PATH = "service";
    
    /**
     * 服务层实现类包路径
     */
    public static final String GENERATOR_SERVICEIMPL_PATH = "service.impl";
    
    /**
     * MAPPER JAVA文件包路径
     */
    public static final String GENERATOR_MAPPER_PATH = "dao.mapper";
    
    /**
     * MAPPER XML文件包路径
     */
    public static final String GENERATOR_MAPPERXML_PATH = "/src/main/resources/mybatis";
    
    /**
     * ENTITY包路径
     */
    public static final String GENERATOR_ENTITY_PATH = "dao.entity";

    /**
     *  生成代码的模块：sys、base、biz、eas
     */
    public static final String GENERATOR_MODEL_NAME = "sys";

    /**
     * 生成代码的作者
     */
    public static final String GENERATOR_AUTHOR = "Your Name!";

    /**
     * 生成实体类代码时要继承的基类
     */
    public static final String GENERATOR_SUPERENTITY_CLASS = "com.ict.common.entity.BaseEntity";

    /**
     * 生成controller类代码时要继承的基类
     */
    public static final String GENERATOR_SUPERCONTROLLER_CLASS= "com.ict.common.controller.BaseController";

}
