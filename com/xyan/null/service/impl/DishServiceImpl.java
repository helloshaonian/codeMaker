package com.xyan.dish.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xyan.dish.service.DishService;
import com.xyan.dish.domain.Dish;
import com.xyan.dish.dao.DishMapper;
import com.fairyland.ext.mybatis.Page;
import com.fairyland.ext.mybatis.PageHelper;
import com.fairyland.sys.codeMaster.service.CodeMasterService;

/**
 *@Description：菜谱 Servcie实现类
 *@Author：wangyanfei
 */
@Service
@Transactional
public class DishServiceImpl implements DishService{

	@Autowired
	private DishMapper _DishMapper;//菜谱
	
	@Autowired
	private CodeMasterService codeMasterService;//取主键用
	
	@Override
	public List<HashMap<String, Object>> selectByExample(Dish vo) {
		return _DishMapper.selectByExample(vo);
	}

	@Override
	public List<Dish> selectModelByExample(Dish vo) {
		return _DishMapper.selectModelByExample(vo);
	}
	
		
	@SuppressWarnings("unchecked")
	@Override
	public Page<HashMap<String, Object>> selectByPage(Dish vo,
			Page<HashMap<String, Object>> page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		_DishMapper.selectByExample(vo);
		return PageHelper.endPage();
	}
	
	@Override
	public Dish selectByPrimaryKey(Long id) {
		return _DishMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Dish vo)  {
		if(vo.getId()==null){
			System.err.println("更新错误，无主键id");
		}
		return _DishMapper.update(vo);
	}

	@Override
	public int insert(Dish vo) {
		String idStr=codeMasterService.gnrtCode(vo.getClass().getSimpleName());
		vo.setId(new Long(idStr));
		return _DishMapper.insert(vo);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public int deleteByIds(String ids){
		List list=Arrays.asList(ids.split(","));
		return  _DishMapper.deleteByIds(list);
	}
	
	@Override
	public int deleteByPrimaryKey(Long id){
		return  _DishMapper.deleteByPrimaryKey(id);
	}
	
}
