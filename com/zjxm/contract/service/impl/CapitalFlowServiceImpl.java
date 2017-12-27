package com.zjxm.contract.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjxm.contract.service.CapitalFlowService;
import com.zjxm.contract.domain.CapitalFlow;
import com.zjxm.contract.dao.CapitalFlowMapper;
import com.fairyland.ext.mybatis.Page;
import com.fairyland.ext.mybatis.PageHelper;
import com.fairyland.sys.codeMaster.service.CodeMasterService;

/**
 *@Description：资金流预测 Servcie实现类
 *@Author：wangyanfei
 */
@Service
@Transactional
public class CapitalFlowServiceImpl implements CapitalFlowService{

	@Autowired
	private CapitalFlowMapper _CapitalFlowMapper;//资金流预测
	
	@Autowired
	private CodeMasterService codeMasterService;//取主键用
	
	@Override
	public List<HashMap<String, Object>> selectByExample(CapitalFlow vo) {
		return _CapitalFlowMapper.selectByExample(vo);
	}

	@Override
	public List<CapitalFlow> selectModelByExample(CapitalFlow vo) {
		return _CapitalFlowMapper.selectModelByExample(vo);
	}
	
		
	@SuppressWarnings("unchecked")
	@Override
	public Page<HashMap<String, Object>> selectByPage(CapitalFlow vo,
			Page<HashMap<String, Object>> page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		_CapitalFlowMapper.selectByExample(vo);
		return PageHelper.endPage();
	}
	
	@Override
	public CapitalFlow selectByPrimaryKey(Long id) {
		return _CapitalFlowMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(CapitalFlow vo)  {
		if(vo.getId()==null){
			System.err.println("更新错误，无主键id");
		}
		return _CapitalFlowMapper.update(vo);
	}

	@Override
	public int insert(CapitalFlow vo) {
		String idStr=codeMasterService.gnrtCode(vo.getClass().getSimpleName());
		vo.setId(new Long(idStr));
		return _CapitalFlowMapper.insert(vo);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public int deleteByIds(String ids){
		List list=Arrays.asList(ids.split(","));
		return  _CapitalFlowMapper.deleteByIds(list);
	}
	
	@Override
	public int deleteByPrimaryKey(Long id){
		return  _CapitalFlowMapper.deleteByPrimaryKey(id);
	}
	
}
