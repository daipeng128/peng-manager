package com.peng.manager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

	private Integer yn;

	public User(String name,String password,String phone){
		this.name = name;
		this.password = password;
		this.phone = phone;
	}


}
