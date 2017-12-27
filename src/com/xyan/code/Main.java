package com.xyan.code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.xyan.code.config.Config;
import com.xyan.code.config.Datas;
import com.xyan.code.entity.Table;
import com.xyan.code.service.CodeService;
import com.xyan.code.service.impl.CodeServiceImpl;
import com.xyan.code.util.StringUtils;

public class Main {
	public static void main(String[] args) throws Exception {
		
		System.out.println("去读配置文件: " + Datas.path);

		Config config = Config.getInstance();
		config.initVelocity();
		//获取数据库中的信息
		CodeService service=new CodeServiceImpl();
		List<Table> tables = service.getTables();

		if(tables==null||tables.size()<1){
			System.out.println("数据库中不存在表："+config.getProperty("tableName"));
			return ;
		}
		String fileSeparator = System.getProperty("file.separator");

		//设置输出路径
		String outputPath = config.getProperty("outPath");
		if (outputPath == null || outputPath.trim().equals("")) {
			outputPath = Datas.path + "output/";
		}
		
		System.out.println(">>>>>>>>>>>>>>输出路径\t"+outputPath);
		
		String projectPackage = config.getProperty("projectPackage");
		VelocityContext context = new VelocityContext();
		System.out.println("开始生成文件");
		System.out.println("================================================================================");
		String commonPackage=config.getProperty("commonPackage");
		for (Table table : tables) {
			//计算真正的包名
			table.calPackageName(commonPackage);
			context.put("meta", table);
			for (int i = 0; i < Datas.templates.length; i++) {
				String outPath = outputPath
						+ projectPackage.replace(".", fileSeparator) + "\\"+commonPackage+"\\" 
						+ Datas.paths[i].replace(".", fileSeparator) + "\\";
				File file = new File(outPath);
				if (!file.exists()) {
					file.mkdirs();
				}
				Template template = Velocity.getTemplate(Datas.templates[i]);
				template.setEncoding("utf-8");
				String fileName = outPath;
				if(Datas.fileNames[i].endsWith(".jsp")){
					fileName+=StringUtils.toLowerCaseFirstOne(table.getDomainClassName())
					+ Datas.fileNames[i];
				}else{
					fileName+=table.getDomainClassName()
							+ Datas.fileNames[i];
				}
				
				writeFiles(template, context, fileName);
				System.out.println("生成文件: " + fileName);
			}
		}
		System.out.println("===========================================================================");
		System.out.println("代码生成结束!");
	}

	private static void writeFiles(Template template, VelocityContext context,
			String fileName) throws IOException {
		FileWriter fileWriter = new FileWriter(fileName, false);
		template.merge(context, fileWriter);
		fileWriter.close();
	}
}
