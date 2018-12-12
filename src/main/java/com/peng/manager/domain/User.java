package com.peng.manager.domain;

import java.util.Date;

/**
 * 用户实体类
 * @ClassName:  User   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: peng 
 * @date:   2018年10月25日 上午9:55:34    
 * @Copyright: 2018
 * id | name | password | phone | create_time | birthday | email | portrait_url | update_time
 */
public class User {
	
	private Integer id;
	
	private String name;
	
	private String password;

	private String phone;

	private Date birthday;

	private String email;

	private String portraitUrl;

	private Date createTime;

	private Date updateTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPortraitUrl() {
		return portraitUrl;
	}

	public void setPortraitUrl(String portraitUrl) {
		this.portraitUrl = portraitUrl;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public User(Integer id, String name, String password, String phone, Date birthday, String email, String portraitUrl, Date createTime, Date updateTime) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.birthday = birthday;
		this.email = email;
		this.portraitUrl = portraitUrl;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public User(String name, String password, String phone) {
		this.name = name;
		this.password = password;
		this.phone = phone;
	}

	public User() {
	}
}
