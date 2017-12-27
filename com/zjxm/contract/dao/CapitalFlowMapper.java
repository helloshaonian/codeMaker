package com.zjxm.contract.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.fairyland.jdp.orm.mybatis.pagination.annotation.MyBatisRepository;


import com.zjxm.contract.domain.CapitalFlow;

/**
 * @description 资金流预测 --dao层接口
 * @author wangyanfei
 * @Date:2016-08-29 18:00:39
 */
@MyBatisRepository
public interface CapitalFlowMapper {

	/**
	 * @Description:根据主键查询
	 * @param id 主键
	 * @return 实体
	 * @author:wangyanfei
	 * @Date:2016-08-29 18:00:39
	 */	
	CapitalFlow selectByPrimaryKey(Long id);
	
	/**
	 * @Description:根据例子查询
	 * @param vo 查询对象
	 * @return map集合
	 * @author:wangyanfei
	 * @Date:2016-08-29 18:00:39
	 */	
	List<HashMap<String, Object>> selectByExample(CapitalFlow vo);
	
	/**
	 * @Description:根据例子查询
	 * @param vo 查询对象
	 * @return 实体集合
	 * @author:wangyanfei
	 * @Date:2016-08-29 18:00:39
	 */	
	List<CapitalFlow> selectModelByExample(CapitalFlow vo);
	
	/**
	 * @Description:插入一条记录
	 * @param record 插入对象（必须有主键）
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2016-08-29 18:00:39
	 */	
    int insert(CapitalFlow record);
    
  	/**
	 * @Description:插入多条记录
	 * @param list 插入对象（必须有主键）
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2016-08-29 18:00:39
	 */	
    int insertModel(List list);
    
    
   /**
	 * @Description:更新一条记录
	 * @param record 更新对象（必须有主键）
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2016-08-29 18:00:39
	 */	
    int update(CapitalFlow record);
    
    /**
	 * @Description:更新多条记录
	 * @param list 更新对象（必须有主键）
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2016-08-29 18:00:39
	 */	
    int update(List list);
    
    
   	/**
	 * @Description:删除一条记录
	 * @param id 删除的记录的主键
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2016-08-29 18:00:39
	 */	
    int deleteByPrimaryKey(Long id);
    
   /**
	 * @Description:删除多条记录
	 * @param list 删除的记录的主键集合
	 * @return 受影响的条数
	 * @author:wangyanfei
	 * @Date:2016-08-29 18:00:39
	 */	
	int deleteByIds(List list);
 }