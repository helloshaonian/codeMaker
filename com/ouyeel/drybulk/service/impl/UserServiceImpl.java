package com.ouyeel.drybulk.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ouyeel.drybulk.service.UserService;
import com.ouyeel.drybulk.domain.User;
import com.ouyeel.drybulk.dao.UserMapper;
import com.fairyland.ext.mybatis.Page;
import com.fairyland.ext.mybatis.PageHelper;
import com.fairyland.sys.codeMaster.service.CodeMasterService;

/**
 *@Description： Servcie实现类
 *@Author：wangyanfei
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper _UserMapper;//
	
	@Autowired
	private CodeMasterService codeMasterService;//取主键用
	
	@Override
	public List<HashMap<String, Object>> selectByExample(User vo) {
		return _UserMapper.selectByExample(vo);
	}

	@Override
	public List<User> selectModelByExample(User vo) {
		return _UserMapper.selectModelByExample(vo);
	}
	
		
	@SuppressWarnings("unchecked")
	@Override
	public Page<HashMap<String, Object>> selectByPage(User vo,
			Page<HashMap<String, Object>> page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		_UserMapper.selectByExample(vo);
		return PageHelper.endPage();
	}
	
	@Override
	public User selectByPrimaryKey(Long id) {
		return _UserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(User vo)  {
		if(vo.getId()==null){
			System.err.println("更新错误，无主键id");
		}
		return _UserMapper.update(vo);
	}

	@Override
	public int insert(User vo) {
		String idStr=codeMasterService.gnrtCode(vo.getClass().getSimpleName());
		vo.setId(new Long(idStr));
		return _UserMapper.insert(vo);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public int deleteByIds(String ids){
		List list=Arrays.asList(ids.split(","));
		return  _UserMapper.deleteByIds(list);
	}
	
	@Override
	public int deleteByPrimaryKey(Long id){
		return  _UserMapper.deleteByPrimaryKey(id);
	}
	
}
