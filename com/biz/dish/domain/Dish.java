package com.biz.dish.domain;

import java.util.Date;
import java.math.BigDecimal;

/**
 *@Description: 菜谱  实体类 
 *				dish
 *@Author:wangyanfei
 */
public class Dish {

	
	private int id;  //主键
	
	private int preSchoolId;  //幼儿园id
	
	private String code;  //菜谱编号
	
	private String name;  //菜谱名称
	
	private String shortName;  //缩略名
	
	private String useType;  //使用类别
	
	public void setId(int id){
		this.id=id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setPreSchoolId(int preSchoolId){
		this.preSchoolId=preSchoolId;
	}
	
	public int getPreSchoolId(){
		return this.preSchoolId;
	}
	
	public void setCode(String code){
		this.code=code;
	}
	
	public String getCode(){
		return this.code;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setShortName(String shortName){
		this.shortName=shortName;
	}
	
	public String getShortName(){
		return this.shortName;
	}
	
	public void setUseType(String useType){
		this.useType=useType;
	}
	
	public String getUseType(){
		return this.useType;
	}
	
		
}