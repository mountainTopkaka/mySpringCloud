package test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * mysql 代码生成器演示例子
 * </p>
 *
 * @author jobob
 * @since 2018-09-12
 */
public class MyBaitsPlusGenerator {

	@Autowired
	private DatasourceConfig datasourceConfig;

	/**
	 * <p>
	 * 读取控制台内容
	 * </p>
	 */
	private String scanner(String tip) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder help = new StringBuilder();
		help.append("请输入" + tip + "：");
		System.out.println(help.toString());
		if (scanner.hasNext()) {
			String ipt = scanner.next();
			if (StringUtils.isNotEmpty(ipt)) {
				return ipt;
			}
		}
		throw new MybatisPlusException("请输入正确的" + tip + "！");
	}

	// @Test
	public void createCodeFile() {
		// String name = datasourceConfig.getName();
		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		String projectPath = "";
		String ide = scanner("请选择IDE类型：1.Eclipse, 2.IDEA");
		if(ide.equals("2")) {
			projectPath = System.getProperty("user.dir")+"/zj-qms2/ict-qms/qms-view-njht"; //Idea路径
		}else {
			projectPath = System.getProperty("user.dir"); //Eclipse路径
		}
		String projectPath2 = projectPath;

		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir(projectPath + "/src/main/java");
		gc.setFileOverride(true);
		gc.setAuthor(Constant.GENERATOR_AUTHOR);
		gc.setOpen(false);//是否打开输出目录
		gc.setServiceName("%sService");//service 命名方式
		gc.setServiceImplName("%sServiceImpl");//service impl 命名方式
		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		gc.setMapperName("%sMapper");
		gc.setXmlName("%sMapper");
		gc.setFileOverride(true);
		gc.setActiveRecord(true);
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(false);// XML columList
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl("jdbc:oracle:thin:@139.129.252.132:1521:ORCL");
		// dsc.setSchemaName("public");
		dsc.setDriverName("oracle.jdbc.driver.OracleDriver");
		dsc.setUsername("qms_njht");
		dsc.setPassword("crrcqms20191001");
		dsc.setDbType(DbType.ORACLE);
        dsc.setTypeConvert(new OracleTypeConvert(){
            // 自定义数据库表字段类型转换
            @Override
            public IColumnType processTypeConvert(GlobalConfig gc, String fieldType) {
            	if (fieldType.contains("number")) {
                    if (fieldType.matches("number\\(\\s*[1-9](\\s*,\\s*0)?\\)")) {
                        return DbColumnType.INTEGER;
                    } else if (fieldType.matches("number\\(\\s*1[0-6](\\s*,\\s*0)?\\)")) {
                        return DbColumnType.LONG;
                    }else if(fieldType.matches("number\\(\\s*(17|18|19|([2-3][0-9]))(\\s*,\\s*0)?\\)")) {
                    	return DbColumnType.STRING;
                    }
                    return DbColumnType.DOUBLE;
                }else {
                	return super.processTypeConvert(gc, fieldType);
                }
            }
        });
		mpg.setDataSource(dsc);

		// 包配置
		String moduleName = scanner("模块名");
		PackageConfig pc = new PackageConfig();
		//模块功能类别
		String moduleType = scanner("请选择模块功能类别：1.系统管理, 2.常规业务");
		if(moduleType.equals("1")) {
			pc.setParent(Constant.GENERATOR_SYS_PARENT_PATH);//父包名。// 自定义包路径  如果为空，将下面子包名必须写全部， 否则就只需写子包名
		}else {
			pc.setParent(Constant.GENERATOR_MODULE_PARENT_PATH);//父包名。// 自定义包路径  如果为空，将下面子包名必须写全部， 否则就只需写子包名
		}
		//pc.setModuleName(moduleName); //如果自定义包路径此处不需要指定模块包路径
		pc.setEntity(Constant.GENERATOR_ENTITY_PATH);
		pc.setMapper(Constant.GENERATOR_MAPPER_PATH);
		//pc.setXml(Constant.GENERATOR_MAPPERXML_PATH);
		pc.setService(Constant.GENERATOR_SERVICE_PATH);
		pc.setServiceImpl(Constant.GENERATOR_SERVICEIMPL_PATH);
		pc.setController(Constant.GENERATOR_CONTROLLER_PATH);//设置控制器包名
		mpg.setPackageInfo(pc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		//strategy.setSuperEntityClass(Constant.GENERATOR_SUPERENTITY_CLASS);
		strategy.setEntityLombokModel(true);
		strategy.setSuperControllerClass(Constant.GENERATOR_SUPERCONTROLLER_CLASS);
		strategy.setInclude(scanner("表名"));
		strategy.setSuperEntityColumns("id");
		//strategy.setControllerMappingHyphenStyle(true);
		strategy.setTablePrefix(moduleName + "_");
		//strategy.setTablePrefix(new String[]{pc.getModuleName() + "_","T_"});
		strategy.setRestControllerStyle(false);
		strategy.setLogicDeleteFieldName("IS_DELETE");
		List<TableFill> tableFillList = new ArrayList<>();
		tableFillList.add(new TableFill("CREATE_ID", FieldFill.INSERT));
		tableFillList.add(new TableFill("CREATE_TIME", FieldFill.INSERT));
		tableFillList.add(new TableFill("UPDATE_ID", FieldFill.UPDATE));
		tableFillList.add(new TableFill("UPDATE_TIME", FieldFill.UPDATE));
		tableFillList.add(new TableFill("IS_DELETE", FieldFill.INSERT));
		strategy.setTableFillList(tableFillList);
		strategy.entityTableFieldAnnotationEnable(true);
		mpg.setStrategy(strategy);

		// 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());

		//生成范围
		String generatorScope = scanner("请选择生成文件范围：1.全部, 2.仅Entity");
		if(generatorScope.equals("2")) {
			mpg.setTemplate(new TemplateConfig().setController(null).setService(null).setServiceImpl(null).setMapper(null).setXml(null));
		}else {
			// 自定义配置
			InjectionConfig cfg = new InjectionConfig() {
				@Override
				public void initMap() {
					// to do nothing
				}
			};
			List<FileOutConfig> focList = new ArrayList<>();
			//自动生成Mapper XML接口配置
			focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
				@Override
				public String outputFile(TableInfo tableInfo) {
					// 自定义输入文件名称
					if(moduleType.equals("1")) {
						return projectPath2 + Constant.GENERATOR_MAPPERXML_PATH + "/" + "system"
				                + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
					}else {
						return projectPath2 + Constant.GENERATOR_MAPPERXML_PATH + "/" + "module"
				                + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
					}
				}
			});

			/*
			//自动生成Entity接口配置
			focList.add(new FileOutConfig("/templates/entity.java.ftl") {
				@Override
				public String outputFile(TableInfo tableInfo) {
					// 自定义输入文件名称
					return projectPath + "/src/main/java/com/ict/system/dao/entity/auto/" //+ pc.getModuleName() + "/"
							+ tableInfo.getEntityName() + StringPool.DOT_JAVA;
				}
			});

			//自动生成Mapper接口配置
			focList.add(new FileOutConfig("/templates/mapper.java.ftl") {
				@Override
				public String outputFile(TableInfo tableInfo) {
					// 自定义输入文件名称
					return projectPath + "/src/main/java/com/ict/system/dao/mapper/auto/" //+ pc.getModuleName() + "/"
							+ tableInfo.getEntityName() + "Mapper" + StringPool.DOT_JAVA;
				}
			});

			//自动生成Service实现配置
			focList.add(new FileOutConfig("/templates/serviceImpl.java.ftl") {
				@Override
				public String outputFile(TableInfo tableInfo) {
					// 自定义输入文件名称
					return projectPath + "/src/main/java/com/ict/system/service/impl/" //+ pc.getModuleName() + "/"
							+ tableInfo.getEntityName() + "ServiceImpl" + StringPool.DOT_JAVA;
				}
			});

			//自动生成Service接口配置
			focList.add(new FileOutConfig("/templates/service.java.ftl") {
				@Override
				public String outputFile(TableInfo tableInfo) {
					// 自定义输入文件名称
					return projectPath + "/src/main/java/com/ict/system/service/" //+ pc.getModuleName() + "/"
							+ tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
				}
			});

			//自动生成Controller配置
			focList.add(new FileOutConfig("/templates/controller.java.ftl") {
				@Override
				public String outputFile(TableInfo tableInfo) {
					// 自定义输入文件名称
					return projectPath + "/src/main/java/com/ict/system/controller/" //+ pc.getModuleName() + "/"
							+ tableInfo.getEntityName() + "Controller" + StringPool.DOT_JAVA;
				}
			});
			*/
			cfg.setFileOutConfigList(focList);
			mpg.setCfg(cfg);
			mpg.setTemplate(new TemplateConfig().setXml(null));
		}

		mpg.execute();
	}

	/**
	 * 自动创建代码 RUN THIS
	 */
	public static void main(String[] args) {
		MyBaitsPlusGenerator generator = new MyBaitsPlusGenerator();
		generator.createCodeFile();
	}

}
