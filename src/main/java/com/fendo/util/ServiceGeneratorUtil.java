package com.fendo.util;

import org.apache.commons.lang.ObjectUtils;
import org.apache.velocity.VelocityContext;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * 代码生成类
 * Created by ZhangShuzheng on 2017/1/10.
 */
public class ServiceGeneratorUtil {

	// Service模板路径
	private static String service_vm = "/template/Service.vm";


	/**
	 * 根据模板生成generatorConfig.xml文件
	 * @param jdbcDriver   驱动路径
	 * @param jdbcUrl      链接
	 * @param jdbcUsername 帐号
	 * @param jdbcPassword 密码
	 * @param module        项目模块
	 * @param database      数据库
	 * @param tablePrefix  表前缀
	 * @param packageName  包名
	 */
	public static void generator(

			String module,

			String packageName) throws Exception{

		String os = System.getProperty("os.name");
		String targetProject = module + "/" + module + "-dao";
		String basePath = ServiceGeneratorUtil.class.getResource("/").getPath().replace("/target/classes/", "").replace(targetProject, "");
		if (os.toLowerCase().startsWith("win")) {
			service_vm = ServiceGeneratorUtil.class.getResource(service_vm).getPath().replaceFirst("/", "");
			basePath = basePath.replaceFirst("/", "");
		} else {
			service_vm = ServiceGeneratorUtil.class.getResource(service_vm).getPath();
		}

		System.out.println("========== 开始生成Service ==========");
		String ctime = new SimpleDateFormat("yyyy/M/d").format(new Date());
		String servicePath = basePath + module + "/" + module + "-rpc-api" + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/rpc/api";
		String table_name = "";

		String model = StringUtil.lineToHump(ObjectUtils.toString(table_name));
		String service = servicePath + "/" + model + "Service.java";

		// 生成service
		File serviceFile = new File(service);
		if (!serviceFile.exists()) {
			VelocityContext context = new VelocityContext();
			context.put("package_name", packageName);
			context.put("model", model);
			context.put("ctime", ctime);
			VelocityUtil.generate(service_vm, service, context);
			System.out.println(service);
		}

		System.out.println("========== 结束生成Service ==========");
	}

	// 递归删除非空文件夹
	public static void deleteDir(File dir) {
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				deleteDir(files[i]);
			}
		}
		dir.delete();
	}

}
