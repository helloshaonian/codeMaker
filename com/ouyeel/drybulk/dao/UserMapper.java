package com.ouyeel.drybulk.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.fairyland.jdp.orm.mybatis.pagination.annotation.MyBatisRepository;


import com.ouyeel.drybulk.domain.User;

/**
 * @description  --dao层接口
 * @author wangyanfei
 * @Date:2016-12-09 16:28:25
 */
@MyBatisRepository
public interface UserMapper {

	/**
	 * @Description:根据主键查询
	 * @param id 主键
	 * @return 实体
	 * @author:wangyanfei
	 * @Date:2016-12-09 16:28:25
	 */	
	User selectByPrimaryKey(Long id);
	
	/**
	 * @Description:根据例子查询
	 * @param vo 查询对象
	 * @return map集合
	 * @author:wangyanfei
	 * @Date:2016-12-09 16:28:25
	 */	
	List<HashMap<String, Object>> selectByExample(User vo);
	
	/**
	 * @Description:根据例子查询
	 * @param vo 查询对象
	 * @return 实体集合
	 * @author:wangyanfei
	 * @Date:2016-12-09 16:28:25
	 */	
	List<User> selectModelByExample(User vo);
	
	/**
	 * @Description:插入一条记录
	 * @param record 插入对象（必须有主键）
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2016-12-09 16:28:25
	 */	
    int insert(User record);
    
  	/**
	 * @Description:插入多条记录
	 * @param list 插入对象（必须有主键）
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2016-12-09 16:28:25
	 */	
    int insertModel(List list);
    
    
   /**
	 * @Description:更新一条记录
	 * @param record 更新对象（必须有主键）
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2016-12-09 16:28:25
	 */	
    int update(User record);
    
    /**
	 * @Description:更新多条记录
	 * @param list 更新对象（必须有主键）
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2016-12-09 16:28:25
	 */	
    int update(List list);
    
    
   	/**
	 * @Description:删除一条记录
	 * @param id 删除的记录的主键
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2016-12-09 16:28:25
	 */	
    int deleteByPrimaryKey(Long id);
    
   /**
	 * @Description:删除多条记录
	 * @param list 删除的记录的主键集合
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2016-12-09 16:28:25
	 */	
	int deleteByIds(List list);
 }