package com.xyan.code.test;

import java.math.BigDecimal;

public class Test {
	
	public static void main(String[] args) {
		BigDecimal a=new BigDecimal(111);
		BigDecimal b=new BigDecimal(22);
		//System.out.println(a.compareTo(b));
		//System.out.println(a.divide(b));
		//System.out.println(a.divide(b,2,BigDecimal.ROUND_HALF_UP));
		System.out.println(calculate(a,b));
	}
	public static BigDecimal calculate(BigDecimal a,BigDecimal b){
    	BigDecimal result=null;
    	if(a.compareTo(new BigDecimal(0))==0||b.compareTo(new BigDecimal(0))==0){
    		result=new BigDecimal(0);
    	}else if(a.compareTo(b)==-1){
    		result=a.divide(b,2,BigDecimal.ROUND_HALF_UP);
    	}else{
    		result=b.divide(a,2,BigDecimal.ROUND_HALF_UP);
    	}
    	return result;
    }
}
