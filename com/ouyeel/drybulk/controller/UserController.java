package com.ouyeel.drybulk.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ouyeel.drybulk.domain.User;
import com.ouyeel.drybulk.service.UserService;
import com.ouyeel.drybulk.vo.UserVO;
import com.fairyland.ext.mybatis.Page;

/**
 *@description  --控制器
 *@Author：wangyanfei
 *@Date:2016-12-09 16:28:25
 */
@Controller
@RequestMapping(value = "/capital/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(df, true));
	}
	/**列表查询*/
	@RequestMapping(method = RequestMethod.GET)
	public String list(User vo){
		return "zjxm/drybulk/userList";
	}
	
	/**分页数据*/
	@RequestMapping(value="pageData")
	public ModelAndView data(User vo,Page<HashMap<String, Object>> page){
		page=userService.selectByPage(vo,page);
		return new ModelAndView("zjxm/drybulk/userData")
				.addObject("page", page);
	}
	
	
	/*@RequestMapping(value="data", produces = MediaTypes.JSON_UTF_8)
	@ResponseBody
	public JsonResult data(User entity,Page<HashMap<String, Object>> page){
		JsonResult result=new JsonResult();
		page=userService.selectByPage(entity,page);
		result.setData(page);
		return result;
	}*/
	
	/**进入新增*/
	@RequestMapping(value="add", method = RequestMethod.GET)
	public ModelAndView toAdd(){
		return new ModelAndView("zjxm/drybulk/userAdd")
				.addObject("action","add")
				.addObject("title","新增");
	}
	
	/**新增*/
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String add(User entity,RedirectAttributes redirectAttributes){
		userService.insert(entity);
		redirectAttributes.addFlashAttribute("message","添加成功");
		return "redirect:/capital/user";
	}
	
	/**进入编辑*/
	@RequestMapping(value="edit", method = RequestMethod.GET)
	public ModelAndView toEdit(Long id){
		User entity =userService.selectByPrimaryKey(id);
		if(entity==null){
			throw new NullPointerException("没有找到指定的");
		}
		return new ModelAndView("zjxm/drybulk/userAdd")
				.addObject("action","edit").addObject("title","修改").addObject("model", entity);
	}
	
	
	/**编辑*/
	@RequestMapping(value="edit", method = RequestMethod.POST)
	public String edit(User entity,RedirectAttributes redirectAttributes){
		userService.updateByPrimaryKey(entity);
		redirectAttributes.addFlashAttribute("message","更新成功");
		return "redirect:/capital/user";
	}
	
	/**进入查看*/
	@RequestMapping(value="view", method = RequestMethod.GET)
	public ModelAndView toView(Long id){
		User entity=userService.selectByPrimaryKey(id);
		if(entity==null){
			throw new NullPointerException("没有找到指定的");
		}
		return new ModelAndView("zjxm/drybulk/userView")
			.addObject("title","查看")
			.addObject("model", entity);
	}
	
	
	/**删除（批量删除）*/
	@RequestMapping(value="del", method = RequestMethod.POST)
	public String del(String ids,RedirectAttributes remodel){
		userService.deleteByIds(ids);
		remodel.addFlashAttribute("message","删除成功！");
		return "redirect:/capital/user";
	}
	
	
}
