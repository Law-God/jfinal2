package com.model.pojo;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseLog<M extends BaseLog<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Long id) {
		set("id", id);
		return (M)this;
	}

	public java.lang.Long getId() {
		return getLong("id");
	}

	public M setUserid(java.lang.Long userid) {
		set("userid", userid);
		return (M)this;
	}

	public java.lang.Long getUserid() {
		return getLong("userid");
	}

	public M setUrl(java.lang.String url) {
		set("url", url);
		return (M)this;
	}

	public java.lang.String getUrl() {
		return getStr("url");
	}

	public M setCreateTime(java.util.Date createTime) {
		set("createTime", createTime);
		return (M)this;
	}

	public java.util.Date getCreateTime() {
		return get("createTime");
	}

	public M setErrorStack(java.lang.String errorStack) {
		set("errorStack", errorStack);
		return (M)this;
	}

	public java.lang.String getErrorStack() {
		return getStr("errorStack");
	}

}
