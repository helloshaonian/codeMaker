package com.ouyeel.drybulk.service;

import java.util.HashMap;
import java.util.List;

import com.ouyeel.drybulk.domain.User;
import com.fairyland.ext.mybatis.Page;

/**
 *@Description： Servcie
 *@Author：wangyanfei
 *@Date:2016-12-09 16:28:25
 */
public interface UserService {
	
	/**
	 * @Description:按条件查询
	 * @param vo 查询对象
	 * @return map集合
	 * @author:wangyanfei
	 * @Date:2016-12-09 16:28:25
	 */	
	public List<HashMap<String, Object>> selectByExample(User vo);
	
	/**
	 * @Description:按条件查询实体
	 * @param vo 查询对象
	 * @return 实体集合
	 * @author:wangyanfei
	 * @Date:2016-12-09 16:28:25
	 */	
	public List<User> selectModelByExample(User record);
	
	/**
	 * @Description:分页查询
	 * @param vo 查询对象
	 * @param page 分页对象
	 * @return 分页对象
	 * @author:wangyanfei
	 * @Date:2016-12-09 16:28:25
	 */
	public Page<HashMap<String, Object>> selectByPage(User vo, Page<HashMap<String, Object>> page);
	
	/**
	 * @Description:根据主键查询
	 * @param id 主键
	 * @return 受影响的记录条数
	 * @author:wangyanfei
	 * @Date:2016-12-09 16:28:25
	 */
	public User selectByPrimaryKey(Long id);
	
	/**
	 * @Description:更新一条记录
	 * @param vo 记录
	 * @return 受影响的记录条数
	 * @author:wangyanfei
	 * @Date:2016-12-09 16:28:25
	 */
	public int updateByPrimaryKey(User record);
	
	/**
	 * @Description:更新一条记录
	 * @param vo 记录
	 * @return 受影响的记录条数
	 * @author:wangyanfei
	 * @Date:2016-12-09 16:28:25
	 */
	public int insert(User record);
	
	/**
	 * @Description:删除多条记录
	 * @param ids ids字符串，多个以【,】隔开
	 * @return 受影响的记录条数
	 * @author:wangyanfei
	 * @Date:2016-12-09 16:28:25
	 */
	public int deleteByIds(String ids);
	
	/**
	 * @Description:删除一条记录
	 * @param id 主键
	 * @return 受影响的记录条数
	 * @author:wangyanfei
	 * @Date:2016-12-09 16:28:25
	 */
	public int deleteByPrimaryKey(Long id);
	
}
