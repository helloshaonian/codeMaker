package com.zjxm.contract.domain;

import java.util.Date;
import java.math.BigDecimal;

/**
 *@Description: 资金流预测  实体类 
 *				ZJ_CAPITAL_FLOW
 *@Author:wangyanfei
 */
public class CapitalFlow {

	
	private Long id;  //主键
	
	private Long docId;  //单据ID
	
	private String docType;  //单据类型
	
	private Date flowDate;  //流水时间
	
	private String direction;  //流水方向
	
	private BigDecimal planAmount;  //计划金额
	
	private BigDecimal realAmount;  //实际金额
	
	private String digest;  //摘要
	
	public void setId(Long id){
		this.id=id;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public void setDocId(Long docId){
		this.docId=docId;
	}
	
	public Long getDocId(){
		return this.docId;
	}
	
	public void setDocType(String docType){
		this.docType=docType;
	}
	
	public String getDocType(){
		return this.docType;
	}
	
	public void setFlowDate(Date flowDate){
		this.flowDate=flowDate;
	}
	
	public Date getFlowDate(){
		return this.flowDate;
	}
	
	public void setDirection(String direction){
		this.direction=direction;
	}
	
	public String getDirection(){
		return this.direction;
	}
	
	public void setPlanAmount(BigDecimal planAmount){
		this.planAmount=planAmount;
	}
	
	public BigDecimal getPlanAmount(){
		return this.planAmount;
	}
	
	public void setRealAmount(BigDecimal realAmount){
		this.realAmount=realAmount;
	}
	
	public BigDecimal getRealAmount(){
		return this.realAmount;
	}
	
	public void setDigest(String digest){
		this.digest=digest;
	}
	
	public String getDigest(){
		return this.digest;
	}
	
		
}