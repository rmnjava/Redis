/**
 * 
 */
package com.luoaijun.redis.bean;

/**
 * TODO
 * @author 罗爱军
 * @date 2018年4月13日
 * @email 3191287315@qq.com
 * @package Redis.com.luoaijun.redis.bean.User.java
 * @describe TODO:
 * @extends :
 */
public class User {
	String phone_no;
	String verify_code;
	String prodid;
	
	public String getProdid() {
		return prodid;
	}
	public void setProdid(String prodid) {
		this.prodid = prodid;
	}
	public String getphone_no() {
		return phone_no;
	}
	public void setphone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getverify_code() {
		return verify_code;
	}
	public void setverify_code(String verify_code) {
		this.verify_code = verify_code;
	}
	 
	public User(String phone_no, String verify_code, String prodid) {
		super();
		this.phone_no = phone_no;
		this.verify_code = verify_code;
		this.prodid = prodid;
	}
	@Override
	public String toString() {
		return "User [phone_no=" + phone_no + ", verify_code=" + verify_code + ", prodid=" + prodid + "]";
	}
	public User() {
		super();
	}
	
}
