package org.mybatis.generator.plugins;

import com.fendo.util.MybatisGeneratorUtil;
import com.fendo.util.StringUtil;
import com.fendo.util.VelocityUtil;
import org.apache.commons.lang.ObjectUtils;
import org.apache.velocity.VelocityContext;
import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.ListUtilities;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

/**   
*/
public class DaoServiceControllerPlugin extends PluginAdapter{

    private String daoTargetDir;
    private String daoTargetPackage;
    private String serviceTargetPackage;
    private String controllerTargetPackage;
    private String acceptTargetPackage;
    private String voTargetPackage;


    private ShellCallback shellCallback = null;

    public DaoServiceControllerPlugin() {
        shellCallback = new DefaultShellCallback(false);
    }

    /**
     * 验证参数是否有效
     * @param warnings
     * @return
     */
    public boolean validate(List<String> warnings) {
        daoTargetDir = properties.getProperty("targetProject");
        boolean valid = stringHasValue(daoTargetDir);

        daoTargetPackage = properties.getProperty("daoTargetPackage");
        serviceTargetPackage = properties.getProperty("serviceTargetPackage");
        controllerTargetPackage = properties.getProperty("controllerTargetPackage");
        acceptTargetPackage = properties.getProperty("acceptTargetPackage");
        voTargetPackage = properties.getProperty("voTargetPackage");
        return valid;
    }

    


    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        String templatePath = DaoServiceControllerPlugin.class.getResource("/").getPath().replace("/target/classes/", "").substring(1)+"/src/main/resources/template/";
        System.out.println(templatePath);
        JavaFormatter javaFormatter = context.getJavaFormatter();
        List<GeneratedJavaFile> mapperJavaFiles = new ArrayList<>();
        for (GeneratedJavaFile javaFile : introspectedTable.getGeneratedJavaFiles()) {
            CompilationUnit unit = javaFile.getCompilationUnit();
            FullyQualifiedJavaType baseModelJavaType = unit.getType();
            String shortName = baseModelJavaType.getShortName();
            if (shortName.endsWith("Mapper")) {
                return mapperJavaFiles;
            }
            if (stringHasValue(daoTargetPackage)) {
                // 通过mybatis-generator相关api生成的java
                generateDaoFile(introspectedTable, javaFormatter, mapperJavaFiles, baseModelJavaType, shortName);
            }
            if(stringHasValue(serviceTargetPackage)){
                // 通过velocity模版生成的java类
                generateServiceFile(templatePath, shortName);
            }
            if(stringHasValue(controllerTargetPackage)){
                // 通过velocity模版生成的java类
                generateControllerFile(templatePath, shortName);
            }
            if(stringHasValue(acceptTargetPackage)){
                // 通过velocity模版生成的java类
                generateAcceptFile(templatePath, shortName);
            }
            if(stringHasValue(voTargetPackage)){
                // 通过velocity模版生成的java类
                generateVoFile(templatePath, shortName);
            }
        }
            return mapperJavaFiles;

    }

    private void generateDaoFile(IntrospectedTable introspectedTable, JavaFormatter javaFormatter, List<GeneratedJavaFile> mapperJavaFiles, FullyQualifiedJavaType baseModelJavaType, String shortName) {
        GeneratedJavaFile mapperJavafile;TopLevelClass topLevelClass = new TopLevelClass(daoTargetPackage + "." + shortName + "Dao");
        FullyQualifiedJavaType daoSuperType = new FullyQualifiedJavaType(daoTargetPackage + ".BaseDao");
        // 继承 添加泛型支持
        daoSuperType.addTypeArgument(baseModelJavaType);
        topLevelClass.setVisibility(JavaVisibility.PUBLIC);
        topLevelClass.addImportedType(baseModelJavaType);
        topLevelClass.addImportedType(daoSuperType);
        topLevelClass.addImportedType("com.his.clinic.repository.mapper."+shortName+"Mapper");
        topLevelClass.setSuperClass(daoSuperType);
        //注释
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" *");
        topLevelClass.addJavaDocLine(" * dao层");
        topLevelClass.addJavaDocLine(" */");
        //注解
        topLevelClass.addAnnotation("@Repository");
        topLevelClass.addImportedType("org.springframework.stereotype.Repository");
        mapperJavafile = new GeneratedJavaFile(topLevelClass, daoTargetDir, javaFormatter);
        addParameterizedConstructor(topLevelClass,introspectedTable,shortName);
        try {
            File mapperDir = shellCallback.getDirectory(daoTargetDir, daoTargetPackage);
            File mapperFile = new File(mapperDir, mapperJavafile.getFileName());
            // 文件不存在
            if (!mapperFile.exists()) {
                mapperJavaFiles.add(mapperJavafile);
            }
        } catch (ShellException e) {
            e.printStackTrace();
        }
    }

    private void generateServiceFile(String templatePath, String shortName) {
        String servicePath = daoTargetDir  + "/" + serviceTargetPackage.replaceAll("\\.", "/") ;
        String model =shortName;
        String service = servicePath + "/" + model + "Service.java";
        File serviceFile = new File(service);
        if (!serviceFile.exists()) {
            VelocityContext context = new VelocityContext();
            context.put("package_name", serviceTargetPackage);
            context.put("model", model);
            context.put("lowerModel", StringUtil.toLowerCaseFirstOne(model));
            context.put("ctime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
            try {
                VelocityUtil.generate(templatePath+"HisService.vm", service, context);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(service);
        }
    }

    private void generateControllerFile(String templatePath, String shortName) {
        String filePath = daoTargetDir  + "/" + controllerTargetPackage.replaceAll("\\.", "/") ;
        String model =shortName;
        String fileFullPath = filePath + "/" + model + "Controller.java";
        File serviceFile = new File(fileFullPath);
        if (!serviceFile.exists()) {
            VelocityContext context = new VelocityContext();
            context.put("package_name", controllerTargetPackage);
            context.put("model", model);
            context.put("lowerModel", StringUtil.toLowerCaseFirstOne(model));
            context.put("ctime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
            try {
                VelocityUtil.generate(templatePath+"HisController.vm", fileFullPath, context);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(fileFullPath);
        }
    }

    private void generateVoFile(String templatePath, String shortName) {
        String filePath = daoTargetDir  + "/" + voTargetPackage.replaceAll("\\.", "/") ;
        String model =shortName;
        String fileFullPath = filePath + "/" + model + "Vo.java";
        File serviceFile = new File(fileFullPath);
        if (!serviceFile.exists()) {
            VelocityContext context = new VelocityContext();
            context.put("package_name", voTargetPackage);
            context.put("model", model);
            context.put("lowerModel", StringUtil.toLowerCaseFirstOne(model));
            context.put("ctime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
            try {
                VelocityUtil.generate(templatePath+"HisVo.vm", fileFullPath, context);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(fileFullPath);
        }
    }

    private void generateAcceptFile(String templatePath, String shortName) {
        String filePath = daoTargetDir  + "/" + acceptTargetPackage.replaceAll("\\.", "/") ;
        String model =shortName;
        VelocityContext context = new VelocityContext();
        context.put("package_name", acceptTargetPackage);
        context.put("model", model);
        context.put("lowerModel", StringUtil.toLowerCaseFirstOne(model));
        context.put("ctime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));

        List<String> acceptTypes = new ArrayList<>();
        acceptTypes.add("Select");
        acceptTypes.add("Add");
        acceptTypes.add("Update");
        acceptTypes.add("UpdateState");

        for(String type:acceptTypes){
            String fileFullPath = filePath + "/" + model + type+"Accept.java";
            File serviceFile = new File(fileFullPath);
            if (!serviceFile.exists()) {
                try {
                    VelocityUtil.generate(templatePath+"His"+type+"Accept.vm", fileFullPath, context);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(fileFullPath);
            }
        }
    }



    private void addParameterizedConstructor(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String modelName) {
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        FullyQualifiedJavaType returnType = new FullyQualifiedJavaType(
                "com.his.clinic.repository.mapper.BaseMapper<"+modelName+">");
        method.setReturnType(returnType);
        method.setName("getMapper");
        StringBuilder sb = new StringBuilder();
        sb.append("return this.mapper;");
        method.addBodyLine(sb.toString());
        method.addAnnotation("@Override");

        Field field = new Field();
        field.setVisibility(JavaVisibility.PUBLIC);
        field.setName("mapper");
        field.setType(new FullyQualifiedJavaType("com.his.clinic.repository.mapper."+modelName+"Mapper"));
        field.addAnnotation("@Autowired");
        topLevelClass.addImportedType("org.springframework.beans.factory.annotation.Autowired");
        topLevelClass.addField(field);
        topLevelClass.addMethod(method);
    }


}
