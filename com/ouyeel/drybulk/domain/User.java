package com.ouyeel.drybulk.domain;

import java.util.Date;
import java.math.BigDecimal;

/**
 *@Description:   实体类 
 *				plat_user
 *@Author:wangyanfei
 */
public class User {

	
	private String userId;  //用户ID
	
	private String loginName;  //登录账号
	
	private String password;  //登录密码
	
	private String status;  //账号状态(NORMAL：正常,ABNORMAL异常)
	
	private String userName;  //用户姓名
	
	private String mobile;  //手机
	
	private String email;  //邮箱
	
	private String userType;  //用户类别(COMPANY企业用户，USER个人用户，OPERATOR运营人员)
	
	private Date accountExpireDate;  //账号过期时间
	
	private Date pwdExpireDate;  //密码过期时间
	
	private String isLocked;  //是否锁定
	
	private String recCreator;  //创建人
	
	private Date recCreateTime;  //创建时间
	
	private String recRevisor;  //修改人
	
	private Date recReviseTime;  //修改时间
	
	public void setUserId(String userId){
		this.userId=userId;
	}
	
	public String getUserId(){
		return this.userId;
	}
	
	public void setLoginName(String loginName){
		this.loginName=loginName;
	}
	
	public String getLoginName(){
		return this.loginName;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setStatus(String status){
		this.status=status;
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	public void setMobile(String mobile){
		this.mobile=mobile;
	}
	
	public String getMobile(){
		return this.mobile;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setUserType(String userType){
		this.userType=userType;
	}
	
	public String getUserType(){
		return this.userType;
	}
	
	public void setAccountExpireDate(Date accountExpireDate){
		this.accountExpireDate=accountExpireDate;
	}
	
	public Date getAccountExpireDate(){
		return this.accountExpireDate;
	}
	
	public void setPwdExpireDate(Date pwdExpireDate){
		this.pwdExpireDate=pwdExpireDate;
	}
	
	public Date getPwdExpireDate(){
		return this.pwdExpireDate;
	}
	
	public void setIsLocked(String isLocked){
		this.isLocked=isLocked;
	}
	
	public String getIsLocked(){
		return this.isLocked;
	}
	
	public void setRecCreator(String recCreator){
		this.recCreator=recCreator;
	}
	
	public String getRecCreator(){
		return this.recCreator;
	}
	
	public void setRecCreateTime(Date recCreateTime){
		this.recCreateTime=recCreateTime;
	}
	
	public Date getRecCreateTime(){
		return this.recCreateTime;
	}
	
	public void setRecRevisor(String recRevisor){
		this.recRevisor=recRevisor;
	}
	
	public String getRecRevisor(){
		return this.recRevisor;
	}
	
	public void setRecReviseTime(Date recReviseTime){
		this.recReviseTime=recReviseTime;
	}
	
	public Date getRecReviseTime(){
		return this.recReviseTime;
	}
	
		
}