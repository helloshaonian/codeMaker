package com.xyan.code.config;

/**
 * @description 固定数据，一般不需要修改
 * @author wangming
 * @date 2016年2月15日 上午9:47:54
 */
public class Datas {
	
	public static String path = Class.class.getClass().getResource("/").getPath();
	
	/**
	 * 要注意这三个数组之间的对应关系
	 */
	
	/**模板*/
	public static String[] templates = { "domain.vm", "mapper.vm", "mapperInterface.vm",
			"service.vm", "serviceImpl.vm", "vo.vm", "controller.vm"};
	
	/**路径*/
	public static String[] paths = { "model", "dao.mapper", "dao", "service",
			"service.impl", "vo", "controller", "jsp", "jsp" ,"jsp"};
	
	/**生成的文件名*/
	public static String[] fileNames = { ".java", "Mapper.xml", "Mapper.java",
			"Service.java", "ServiceImpl.java", "VO.java", "Controller.java"
			};
}
