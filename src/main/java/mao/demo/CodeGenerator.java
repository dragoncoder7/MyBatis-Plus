package mao.demo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/yupi?characterEncoding=utf8&useSSL=false";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        FastAutoGenerator.create(url,username,password)
                .globalConfig(builder -> {
                    builder.author("maoyunlong") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("F:\\maoyunlong"); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent("mao.demo.samples.generator") // 设置父包名
                                .moduleName("demo") // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, "F:\\maoyunlong")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        builder.addInclude("t_simple") // 设置需要生成的表名
                                .addTablePrefix("t_", "c_") // 设置过滤表前缀
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
