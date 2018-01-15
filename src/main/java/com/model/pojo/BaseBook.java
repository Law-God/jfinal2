package com.model.pojo;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseBook<M extends BaseBook<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Long id) {
		set("id", id);
		return (M)this;
	}

	public java.lang.Long getId() {
		return getLong("id");
	}

	public M setBookname(java.lang.String bookname) {
		set("bookname", bookname);
		return (M)this;
	}

	public java.lang.String getBookname() {
		return getStr("bookname");
	}

	public M setDescript(java.lang.String descript) {
		set("descript", descript);
		return (M)this;
	}

	public java.lang.String getDescript() {
		return getStr("descript");
	}

	public M setContent(java.lang.String content) {
		set("content", content);
		return (M)this;
	}

	public java.lang.String getContent() {
		return getStr("content");
	}

	public M setAuth(java.lang.String auth) {
		set("auth", auth);
		return (M)this;
	}

	public java.lang.String getAuth() {
		return getStr("auth");
	}

	public M setCreatetime(java.util.Date createtime) {
		set("createtime", createtime);
		return (M)this;
	}

	public java.util.Date getCreatetime() {
		return get("createtime");
	}

}
