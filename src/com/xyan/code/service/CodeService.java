package com.xyan.code.service;

import java.util.List;

import com.xyan.code.entity.Table;

public interface CodeService {
	
	/**
	 * @Description：获取表信息
	 * @author wangming
	 * @return
	 * @throws Exception
	 * @since 2016年3月19日 下午10:38:37
	 */
	public List<Table> getTables() throws Exception;
}
