package com.biz.controller;

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

import com.biz.domain.Dish;
import com.biz.service.DishService;
import com.biz.vo.DishVO;
import com.fairyland.ext.mybatis.Page;

/**
 *@description 菜谱 --控制器
 *@Author：wangyanfei
 *@Date:2017-04-14 13:28:09
 */
@Controller
@RequestMapping(value = "/capital/dish")
public class DishController {

	@Autowired
	private DishService dishService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(df, true));
	}
	/**列表查询*/
	@RequestMapping(method = RequestMethod.GET)
	public String list(Dish vo){
		return "zjxm/biz/dishList";
	}
	
	/**分页数据*/
	@RequestMapping(value="pageData")
	public ModelAndView data(Dish vo,Page<HashMap<String, Object>> page){
		page=dishService.selectByPage(vo,page);
		return new ModelAndView("zjxm/biz/dishData")
				.addObject("page", page);
	}
	
	
	/*@RequestMapping(value="data", produces = MediaTypes.JSON_UTF_8)
	@ResponseBody
	public JsonResult data(Dish entity,Page<HashMap<String, Object>> page){
		JsonResult result=new JsonResult();
		page=dishService.selectByPage(entity,page);
		result.setData(page);
		return result;
	}*/
	
	/**进入新增*/
	@RequestMapping(value="add", method = RequestMethod.GET)
	public ModelAndView toAdd(){
		return new ModelAndView("zjxm/biz/dishAdd")
				.addObject("action","add")
				.addObject("title","新增菜谱");
	}
	
	/**新增*/
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String add(Dish entity,RedirectAttributes redirectAttributes){
		dishService.insert(entity);
		redirectAttributes.addFlashAttribute("message","添加成功");
		return "redirect:/capital/dish";
	}
	
	/**进入编辑*/
	@RequestMapping(value="edit", method = RequestMethod.GET)
	public ModelAndView toEdit(Long id){
		Dish entity =dishService.selectByPrimaryKey(id);
		if(entity==null){
			throw new NullPointerException("没有找到指定的菜谱");
		}
		return new ModelAndView("zjxm/biz/dishAdd")
				.addObject("action","edit").addObject("title","菜谱修改").addObject("model", entity);
	}
	
	
	/**编辑*/
	@RequestMapping(value="edit", method = RequestMethod.POST)
	public String edit(Dish entity,RedirectAttributes redirectAttributes){
		dishService.updateByPrimaryKey(entity);
		redirectAttributes.addFlashAttribute("message","更新成功");
		return "redirect:/capital/dish";
	}
	
	/**进入查看*/
	@RequestMapping(value="view", method = RequestMethod.GET)
	public ModelAndView toView(Long id){
		Dish entity=dishService.selectByPrimaryKey(id);
		if(entity==null){
			throw new NullPointerException("没有找到指定的菜谱");
		}
		return new ModelAndView("zjxm/biz/dishView")
			.addObject("title","菜谱查看")
			.addObject("model", entity);
	}
	
	
	/**删除（批量删除）*/
	@RequestMapping(value="del", method = RequestMethod.POST)
	public String del(String ids,RedirectAttributes remodel){
		dishService.deleteByIds(ids);
		remodel.addFlashAttribute("message","删除成功！");
		return "redirect:/capital/dish";
	}
	
	
}
