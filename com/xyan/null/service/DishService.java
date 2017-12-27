package com.xyan.dish.service;

import java.util.HashMap;
import java.util.List;

import com.xyan.dish.domain.Dish;
import com.fairyland.ext.mybatis.Page;

/**
 *@Description：菜谱 Servcie
 *@Author：wangyanfei
 *@Date:2017-04-14 13:26:18
 */
public interface DishService {
	
	/**
	 * @Description:按条件查询
	 * @param vo 查询对象
	 * @return map集合
	 * @author:wangyanfei
	 * @Date:2017-04-14 13:26:18
	 */	
	public List<HashMap<String, Object>> selectByExample(Dish vo);
	
	/**
	 * @Description:按条件查询实体
	 * @param vo 查询对象
	 * @return 实体集合
	 * @author:wangyanfei
	 * @Date:2017-04-14 13:26:18
	 */	
	public List<Dish> selectModelByExample(Dish record);
	
	/**
	 * @Description:分页查询
	 * @param vo 查询对象
	 * @param page 分页对象
	 * @return 分页对象
	 * @author:wangyanfei
	 * @Date:2017-04-14 13:26:18
	 */
	public Page<HashMap<String, Object>> selectByPage(Dish vo, Page<HashMap<String, Object>> page);
	
	/**
	 * @Description:根据主键查询
	 * @param id 主键
	 * @return 受影响的记录条数
	 * @author:wangyanfei
	 * @Date:2017-04-14 13:26:18
	 */
	public Dish selectByPrimaryKey(Long id);
	
	/**
	 * @Description:更新一条记录
	 * @param vo 记录
	 * @return 受影响的记录条数
	 * @author:wangyanfei
	 * @Date:2017-04-14 13:26:18
	 */
	public int updateByPrimaryKey(Dish record);
	
	/**
	 * @Description:更新一条记录
	 * @param vo 记录
	 * @return 受影响的记录条数
	 * @author:wangyanfei
	 * @Date:2017-04-14 13:26:18
	 */
	public int insert(Dish record);
	
	/**
	 * @Description:删除多条记录
	 * @param ids ids字符串，多个以【,】隔开
	 * @return 受影响的记录条数
	 * @author:wangyanfei
	 * @Date:2017-04-14 13:26:18
	 */
	public int deleteByIds(String ids);
	
	/**
	 * @Description:删除一条记录
	 * @param id 主键
	 * @return 受影响的记录条数
	 * @author:wangyanfei
	 * @Date:2017-04-14 13:26:18
	 */
	public int deleteByPrimaryKey(Long id);
	
}
