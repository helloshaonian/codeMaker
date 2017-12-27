package com.zjxm.contract.controller;

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

import com.zjxm.contract.domain.CapitalFlow;
import com.zjxm.contract.service.CapitalFlowService;
import com.zjxm.contract.vo.CapitalFlowVO;
import com.fairyland.ext.mybatis.Page;

/**
 *@description 资金流预测 --控制器
 *@Author：wangyanfei
 *@Date:2016-08-29 18:00:39
 */
@Controller
@RequestMapping(value = "/capital/capitalFlow")
public class CapitalFlowController {

	@Autowired
	private CapitalFlowService capitalFlowService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(df, true));
	}
	/**列表查询*/
	@RequestMapping(method = RequestMethod.GET)
	public String list(CapitalFlow vo){
		return "zjxm/contract/capitalFlowList";
	}
	
	/**分页数据*/
	@RequestMapping(value="pageData")
	public ModelAndView data(CapitalFlow vo,Page<HashMap<String, Object>> page){
		page=capitalFlowService.selectByPage(vo,page);
		return new ModelAndView("zjxm/contract/capitalFlowData")
				.addObject("page", page);
	}
	
	
	/*@RequestMapping(value="data", produces = MediaTypes.JSON_UTF_8)
	@ResponseBody
	public JsonResult data(CapitalFlow entity,Page<HashMap<String, Object>> page){
		JsonResult result=new JsonResult();
		page=capitalFlowService.selectByPage(entity,page);
		result.setData(page);
		return result;
	}*/
	
	/**进入新增*/
	@RequestMapping(value="add", method = RequestMethod.GET)
	public ModelAndView toAdd(){
		return new ModelAndView("zjxm/contract/capitalFlowAdd")
				.addObject("action","add")
				.addObject("title","新增资金流预测");
	}
	
	/**新增*/
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String add(CapitalFlow entity,RedirectAttributes redirectAttributes){
		capitalFlowService.insert(entity);
		redirectAttributes.addFlashAttribute("message","添加成功");
		return "redirect:/capital/capitalFlow";
	}
	
	/**进入编辑*/
	@RequestMapping(value="edit", method = RequestMethod.GET)
	public ModelAndView toEdit(Long id){
		CapitalFlow entity =capitalFlowService.selectByPrimaryKey(id);
		if(entity==null){
			throw new NullPointerException("没有找到指定的资金流预测");
		}
		return new ModelAndView("zjxm/contract/capitalFlowAdd")
				.addObject("action","edit").addObject("title","资金流预测修改").addObject("model", entity);
	}
	
	
	/**编辑*/
	@RequestMapping(value="edit", method = RequestMethod.POST)
	public String edit(CapitalFlow entity,RedirectAttributes redirectAttributes){
		capitalFlowService.updateByPrimaryKey(entity);
		redirectAttributes.addFlashAttribute("message","更新成功");
		return "redirect:/capital/capitalFlow";
	}
	
	/**进入查看*/
	@RequestMapping(value="view", method = RequestMethod.GET)
	public ModelAndView toView(Long id){
		CapitalFlow entity=capitalFlowService.selectByPrimaryKey(id);
		if(entity==null){
			throw new NullPointerException("没有找到指定的资金流预测");
		}
		return new ModelAndView("zjxm/contract/capitalFlowView")
			.addObject("title","资金流预测查看")
			.addObject("model", entity);
	}
	
	
	/**删除（批量删除）*/
	@RequestMapping(value="del", method = RequestMethod.POST)
	public String del(String ids,RedirectAttributes remodel){
		capitalFlowService.deleteByIds(ids);
		remodel.addFlashAttribute("message","删除成功！");
		return "redirect:/capital/capitalFlow";
	}
	
	
}
