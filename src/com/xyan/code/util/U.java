package com.xyan.code.util;

import java.util.List;

public class U {
	private int id;
	private String name;
	private String sex;
	private int f;
	private List<U> ulist;
public U(int id,String name,String sex,int f){
	this.id=id;
	this.name=name;
	this.sex=sex;
	this.f=f;
}

public List<U> getUlist() {
	return ulist;
}

public void setUlist(List<U> ulist) {
	this.ulist = ulist;
}

public int getF() {
	return f;
}

public void setF(int f) {
	this.f = f;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}

}
