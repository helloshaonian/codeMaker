package com.xyan.dish.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.fairyland.jdp.orm.mybatis.pagination.annotation.MyBatisRepository;


import com.xyan.dish.domain.Dish;

/**
 * @description 菜谱 --dao层接口
 * @author wangyanfei
 * @Date:2017-04-14 13:26:18
 */
@MyBatisRepository
public interface DishMapper {

	/**
	 * @Description:根据主键查询
	 * @param id 主键
	 * @return 实体
	 * @author:wangyanfei
	 * @Date:2017-04-14 13:26:18
	 */	
	Dish selectByPrimaryKey(Long id);
	
	/**
	 * @Description:根据例子查询
	 * @param vo 查询对象
	 * @return map集合
	 * @author:wangyanfei
	 * @Date:2017-04-14 13:26:18
	 */	
	List<HashMap<String, Object>> selectByExample(Dish vo);
	
	/**
	 * @Description:根据例子查询
	 * @param vo 查询对象
	 * @return 实体集合
	 * @author:wangyanfei
	 * @Date:2017-04-14 13:26:18
	 */	
	List<Dish> selectModelByExample(Dish vo);
	
	/**
	 * @Description:插入一条记录
	 * @param record 插入对象（必须有主键）
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2017-04-14 13:26:18
	 */	
    int insert(Dish record);
    
  	/**
	 * @Description:插入多条记录
	 * @param list 插入对象（必须有主键）
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2017-04-14 13:26:18
	 */	
    int insertModel(List list);
    
    
   /**
	 * @Description:更新一条记录
	 * @param record 更新对象（必须有主键）
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2017-04-14 13:26:18
	 */	
    int update(Dish record);
    
    /**
	 * @Description:更新多条记录
	 * @param list 更新对象（必须有主键）
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2017-04-14 13:26:18
	 */	
    int update(List list);
    
    
   	/**
	 * @Description:删除一条记录
	 * @param id 删除的记录的主键
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2017-04-14 13:26:18
	 */	
    int deleteByPrimaryKey(Long id);
    
   /**
	 * @Description:删除多条记录
	 * @param list 删除的记录的主键集合
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2017-04-14 13:26:18
	 */	
	int deleteByIds(List list);
 }