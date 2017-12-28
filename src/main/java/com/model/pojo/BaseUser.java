package com.model.pojo;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseUser<M extends BaseUser<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Long id) {
		set("id", id);
		return (M)this;
	}

	public java.lang.Long getId() {
		return getLong("id");
	}

	public M setUsername(java.lang.String username) {
		set("username", username);
		return (M)this;
	}

	public java.lang.String getUsername() {
		return getStr("username");
	}

	public M setAge(java.lang.Integer age) {
		set("age", age);
		return (M)this;
	}

	public java.lang.Integer getAge() {
		return getInt("age");
	}

	public M setAddress(java.lang.String address) {
		set("address", address);
		return (M)this;
	}

	public java.lang.String getAddress() {
		return getStr("address");
	}

	public M setBirthday(java.util.Date birthday) {
		set("birthday", birthday);
		return (M)this;
	}

	public java.util.Date getBirthday() {
		return get("birthday");
	}

	public M setSummary(java.lang.String summary) {
		set("summary", summary);
		return (M)this;
	}

	public java.lang.String getSummary() {
		return getStr("summary");
	}

	public M setPhone(java.lang.String phone) {
		set("phone", phone);
		return (M)this;
	}

	public java.lang.String getPhone() {
		return getStr("phone");
	}

	public M setEmail(java.lang.String email) {
		set("email", email);
		return (M)this;
	}

	public java.lang.String getEmail() {
		return getStr("email");
	}

	public M setUrl(java.lang.String url) {
		set("url", url);
		return (M)this;
	}

	public java.lang.String getUrl() {
		return getStr("url");
	}

	public M setIdcard(java.lang.String idcard) {
		set("idcard", idcard);
		return (M)this;
	}

	public java.lang.String getIdcard() {
		return getStr("idcard");
	}

}
