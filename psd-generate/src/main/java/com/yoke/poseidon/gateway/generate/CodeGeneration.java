package com.yoke.poseidon.gateway.generate;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author ethereal
 * @since 2018-09-20 19:26
 */
public class CodeGeneration {

	public static void main(String[] args) {
		AutoGenerator mpg = new AutoGenerator();
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir(
				"/media/code/program/java/poseidon/poseidon/psd-web-view/src/main/java");
		gc.setFileOverride(true);
		gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(false);// XML columList
		gc.setAuthor("yoke");// 作者

		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		gc.setControllerName("%sController");
		gc.setServiceName("%sService");
		gc.setServiceImplName("%sServiceImpl");
		gc.setMapperName("%sMapper");
		gc.setXmlName("%sMapper");
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setDriverName("com.mysql.cj.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("FJEOIRFWQ132EW");
		dsc.setUrl(
				"jdbc:mysql://www.test.com:13306/poseidon?useUnicode=true&characterEncoding=utf-8&useSSL=false");
		mpg.setDataSource(dsc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setTablePrefix("db_");// 此处可以修改为您的表前缀
		strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
		strategy.setInclude("db_item_attribute_name", "db_item_attribute_value",
				"db_item_sku");
		strategy.setSuperServiceClass(null);
		strategy.setSuperServiceImplClass(null);
		strategy.setSuperMapperClass(null);
		mpg.setStrategy(strategy);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent("com.yoke.poseidon.web.itemShow");
		pc.setController("web");
		pc.setService("service");
		pc.setServiceImpl("serviceImpl");
		pc.setMapper("mapper");
		pc.setEntity("entity");
		pc.setXml("mapper");
		mpg.setPackageInfo(pc);
		// 执行生成
		mpg.execute();

	}

}
