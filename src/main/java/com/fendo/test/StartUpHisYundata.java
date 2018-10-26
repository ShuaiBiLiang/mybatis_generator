package com.fendo.test;


import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**   
 * @Title: StartUp.java 
 * @Package com.fendo.mybatis_generator_plus 
 * @Description: mybatis-generator测试类
 * @author fendo
 * @date 2017年10月5日 下午3:53:17 
 * @version V1.0   
*/
public class StartUpHisYundata {

	public static void main(String[] args) throws URISyntaxException {
        try {
        	System.out.println("--------------------start generator-------------------");
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("generatorConfig_his_yundata.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(is);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        	System.out.println("--------------------end generator-------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
