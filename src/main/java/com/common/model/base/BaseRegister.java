package com.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseRegister<M extends BaseRegister<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}

	public java.lang.Integer getId() {
		return getInt("id");
	}

	public M setUsername(java.lang.String username) {
		set("username", username);
		return (M)this;
	}

	public java.lang.String getUsername() {
		return getStr("username");
	}

	public M setBirthday(java.util.Date birthday) {
		set("birthday", birthday);
		return (M)this;
	}

	public java.util.Date getBirthday() {
		return get("birthday");
	}

	public M setCardtype(java.lang.String cardtype) {
		set("cardtype", cardtype);
		return (M)this;
	}

	public java.lang.String getCardtype() {
		return getStr("cardtype");
	}

	public M setCardno(java.lang.String cardno) {
		set("cardno", cardno);
		return (M)this;
	}

	public java.lang.String getCardno() {
		return getStr("cardno");
	}

	public M setAddress(java.lang.String address) {
		set("address", address);
		return (M)this;
	}

	public java.lang.String getAddress() {
		return getStr("address");
	}

}