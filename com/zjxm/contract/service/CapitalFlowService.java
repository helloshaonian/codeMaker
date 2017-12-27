package com.zjxm.contract.service;

import java.util.HashMap;
import java.util.List;

import com.zjxm.contract.domain.CapitalFlow;
import com.fairyland.ext.mybatis.Page;

/**
 *@Description：资金流预测 Servcie
 *@Author：wangyanfei
 *@Date:2016-08-29 18:00:39
 */
public interface CapitalFlowService {
	
	/**
	 * @Description:按条件查询
	 * @param vo 查询对象
	 * @return map集合
	 * @author:wangyanfei
	 * @Date:2016-08-29 18:00:39
	 */	
	public List<HashMap<String, Object>> selectByExample(CapitalFlow vo);
	
	/**
	 * @Description:按条件查询实体
	 * @param vo 查询对象
	 * @return 实体集合
	 * @author:wangyanfei
	 * @Date:2016-08-29 18:00:39
	 */	
	public List<CapitalFlow> selectModelByExample(CapitalFlow record);
	
	/**
	 * @Description:分页查询
	 * @param vo 查询对象
	 * @param page 分页对象
	 * @return 分页对象
	 * @author:wangyanfei
	 * @Date:2016-08-29 18:00:39
	 */
	public Page<HashMap<String, Object>> selectByPage(CapitalFlow vo, Page<HashMap<String, Object>> page);
	
	/**
	 * @Description:根据主键查询
	 * @param id 主键
	 * @return 受影响的记录条数
	 * @author:wangyanfei
	 * @Date:2016-08-29 18:00:39
	 */
	public CapitalFlow selectByPrimaryKey(Long id);
	
	/**
	 * @Description:更新一条记录
	 * @param vo 记录
	 * @return 受影响的记录条数
	 * @author:wangyanfei
	 * @Date:2016-08-29 18:00:39
	 */
	public int updateByPrimaryKey(CapitalFlow record);
	
	/**
	 * @Description:更新一条记录
	 * @param vo 记录
	 * @return 受影响的记录条数
	 * @author:wangyanfei
	 * @Date:2016-08-29 18:00:39
	 */
	public int insert(CapitalFlow record);
	
	/**
	 * @Description:删除多条记录
	 * @param ids ids字符串，多个以【,】隔开
	 * @return 受影响的记录条数
	 * @author:wangyanfei
	 * @Date:2016-08-29 18:00:39
	 */
	public int deleteByIds(String ids);
	
	/**
	 * @Description:删除一条记录
	 * @param id 主键
	 * @return 受影响的记录条数
	 * @author:wangyanfei
	 * @Date:2016-08-29 18:00:39
	 */
	public int deleteByPrimaryKey(Long id);
	
}
