package org.mybatis.generator.plugins;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.ibatis2.Ibatis2FormattingUtilities;
import org.mybatis.generator.codegen.mybatis3.ListUtilities;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**   
 * @Title: MapperPlugin.java 
 * @Package org.mybatis.generator.plugins 
 * @Description: TODO
 * @author fendo
 * @date 2017年12月2日 下午5:35:14 
 * @version V1.0   
*/
public class MapperPlugin extends PluginAdapter{

    private static final String DEFAULT_DAO_SUPER_CLASS = "com.fendo.mapper.BaseMapper";
    private static final String DEFAULT_EXPAND_DAO_SUPER_CLASS = "com.fendo.mapper.BaseExpandMapper";
    private String daoTargetDir;
    private String daoTargetPackage;

    private String daoSuperClass;

    // 扩展
    private String expandDaoTargetPackage;
    private String expandDaoSuperClass;

    private ShellCallback shellCallback = null;

    public MapperPlugin() {
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

        daoTargetPackage = properties.getProperty("targetPackage");
        boolean valid2 = stringHasValue(daoTargetPackage);

        daoSuperClass = properties.getProperty("daoSuperClass");
        if (!stringHasValue(daoSuperClass)) {
            daoSuperClass = DEFAULT_DAO_SUPER_CLASS;
        }

        expandDaoTargetPackage = properties.getProperty("expandTargetPackage");
        expandDaoSuperClass = properties.getProperty("expandDaoSuperClass");
        if (!stringHasValue(expandDaoSuperClass)) {
            expandDaoSuperClass = DEFAULT_EXPAND_DAO_SUPER_CLASS;
        }
        return valid && valid2;
    }

    
    /** 
     * 生成mapping 添加自定义sql 
     */ 
    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
    	
    	//创建Select查询
//        XmlElement select = new XmlElement("select");
//        select.addAttribute(new Attribute("id", "selectAll"));
//        select.addAttribute(new Attribute("resultMap", "BaseResultMap"));
//        select.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
//        select.addElement(new TextElement("select * from "+ introspectedTable.getFullyQualifiedTableNameAtRuntime()));
//
//        XmlElement queryPage = new XmlElement("select");
//        queryPage.addAttribute(new Attribute("id", "queryPage"));
//        queryPage.addAttribute(new Attribute("resultMap", "BaseResultMap"));
//        queryPage.addAttribute(new Attribute("parameterType", "com.fendo.bean.Page"));
//        queryPage.addElement(new TextElement("select * from "+ introspectedTable.getFullyQualifiedTableNameAtRuntime()));


        XmlElement selectByCondition = new XmlElement("select");
        selectByCondition.addAttribute(new Attribute("id", "selectListByCondition"));
        selectByCondition.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        selectByCondition.addAttribute(new Attribute("parameterType", "map"));
        StringBuilder sb = new StringBuilder();
        sb.append("select * from "+ introspectedTable.getFullyQualifiedTableNameAtRuntime());
        selectByCondition.addElement(new TextElement(sb.toString()));
        XmlElement dynamicElement = new XmlElement("where"); //$NON-NLS-1$
        selectByCondition.addElement(dynamicElement);
        for (IntrospectedColumn introspectedColumn : ListUtilities.removeGeneratedAlwaysColumns(introspectedTable
                .getNonPrimaryKeyColumns())) {
            XmlElement isNotNullElement = new XmlElement("if"); //$NON-NLS-1$
            sb.setLength(0);
            sb.append(introspectedColumn.getJavaProperty());
            sb.append(" != null"); //$NON-NLS-1$
            isNotNullElement.addAttribute(new Attribute("test", sb.toString())); //$NON-NLS-1$
            dynamicElement.addElement(isNotNullElement);

            sb.setLength(0);
            sb.append(" and "+MyBatis3FormattingUtilities
                    .getEscapedColumnName(introspectedColumn));
            sb.append(" = "); //$NON-NLS-1$
            sb.append(MyBatis3FormattingUtilities
                    .getParameterClause(introspectedColumn));
//            sb.append(',');

            isNotNullElement.addElement(new TextElement(sb.toString()));
        }


        XmlElement parentElement = document.getRootElement();
//        parentElement.addElement(select);
//        parentElement.addElement(queryPage);
        parentElement.addElement(selectByCondition);
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        JavaFormatter javaFormatter = context.getJavaFormatter();
        List<GeneratedJavaFile> mapperJavaFiles = new ArrayList<GeneratedJavaFile>();
        for (GeneratedJavaFile javaFile : introspectedTable.getGeneratedJavaFiles()) {
            CompilationUnit unit = javaFile.getCompilationUnit();
            FullyQualifiedJavaType baseModelJavaType = unit.getType();

            String shortName = baseModelJavaType.getShortName();

            GeneratedJavaFile mapperJavafile = null;

            if (shortName.endsWith("Mapper")) { // 扩展Mapper
                if (stringHasValue(expandDaoTargetPackage)) {
                    Interface mapperInterface = new Interface(
                            expandDaoTargetPackage + "." + shortName.replace("Mapper", "ExpandMapper"));
                    mapperInterface.setVisibility(JavaVisibility.PUBLIC);
                    mapperInterface.addJavaDocLine("/**");
                    mapperInterface.addJavaDocLine(" * " + shortName + "扩展");
                    mapperInterface.addJavaDocLine(" */");

                    FullyQualifiedJavaType daoSuperType = new FullyQualifiedJavaType(expandDaoSuperClass);
                    mapperInterface.addImportedType(daoSuperType);
                    mapperInterface.addSuperInterface(daoSuperType);


                    mapperJavafile = new GeneratedJavaFile(mapperInterface, daoTargetDir, javaFormatter);
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
            } else if (!shortName.endsWith("Example")) { // CRUD Mapper

                if(stringHasValue(daoSuperClass)){

                    Interface mapperInterface = new Interface(daoTargetPackage + "." + shortName + "Mapper");

                    mapperInterface.setVisibility(JavaVisibility.PUBLIC);
                    mapperInterface.addJavaDocLine("/**");
                    mapperInterface.addJavaDocLine(" * MyBatis Generator工具自动生成");
                    mapperInterface.addJavaDocLine(" */");

                    FullyQualifiedJavaType daoSuperType = new FullyQualifiedJavaType(daoSuperClass);
                    // 添加泛型支持
                    daoSuperType.addTypeArgument(baseModelJavaType);
                    mapperInterface.addImportedType(baseModelJavaType);
                    mapperInterface.addImportedType(daoSuperType);
                    mapperInterface.addSuperInterface(daoSuperType);

                    mapperJavafile = new GeneratedJavaFile(mapperInterface, daoTargetDir, javaFormatter);
                    mapperJavaFiles.add(mapperJavafile);
                }

            }
        }
        return mapperJavaFiles;
    }


    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
                                                 IntrospectedTable introspectedTable) {
        //该代码表示在生成class的时候，向topLevelClass添加一个@Setter和@Getter注解
        topLevelClass.addAnnotation("@Getter\n" +
                "@Setter\n" +
                "@NoArgsConstructor\n" +
                "@AllArgsConstructor");
        topLevelClass.addImportedType("lombok.Setter");
        topLevelClass.addImportedType("lombok.Getter");
        topLevelClass.addImportedType("lombok.NoArgsConstructor");
        topLevelClass.addImportedType("lombok.AllArgsConstructor");
        return super.modelBaseRecordClassGenerated(topLevelClass,
                introspectedTable);
    }

    //该方法在生成每一个属性的getter方法时候调用，如果我们不想生成getter，直接返回false即可；
    @Override
    public boolean modelGetterMethodGenerated(Method method,
                                              TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable,
                                              ModelClassType modelClassType) {
        return false;
    }

    //该方法在生成每一个属性的setter方法时候调用，如果我们不想生成setter，直接返回false即可；
    @Override
    public boolean modelSetterMethodGenerated(Method method,
                                              TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable,
                                              ModelClassType modelClassType) {
        return false;
    }

}
