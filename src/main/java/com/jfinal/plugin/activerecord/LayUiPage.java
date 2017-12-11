/**
 * Copyright (c) 2011-2017, James Zhan 詹波 (jfinal@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jfinal.plugin.activerecord;

import java.io.Serializable;
import java.util.List;

/**
 * Page is the result of Model.paginate(......) or Db.paginate(......)
 */
public class LayUiPage<T> implements Serializable {

	private static final long serialVersionUID = -5395997221963176643L;

	private int totalPage;				// total page
	private List<T> data;
	private int count;//数据总数
	private int limit;//每页显示的条数
	private int curr;//当前页
	private int code;
	private String msg;
	private boolean first;
	private boolean list;

	public LayUiPage(Page page){
		if(page != null){
			this.totalPage = page.getTotalPage();
			this.data = page.getList();
			this.count = page.getTotalRow();
			this.limit = page.getPageSize();
			this.curr = page.getPageNumber();
		}
	}

	/**
	 * Return list of this page.
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * Return page number.
	 */
	public int getCurr() {
		return curr;
	}

	/**
	 * Return page size.
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * Return total page.
	 */
	public int getTotalPage() {
		return totalPage;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	/**
	 * Return total row.
	 */
	public int getCount() {
		return count;
	}

	public boolean getFirst() {
		return this.first = curr == 1;
	}

	public boolean getList() {
		return this.list = curr >= totalPage;
	}

	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append("curr : ").append(curr);
		msg.append("\nlimit : ").append(limit);
		msg.append("\ntotalPage : ").append(totalPage);
		msg.append("\ncount : ").append(count);
		msg.append("\ncode : ").append(code);
		msg.append("\nmsg : ").append(msg);
		return msg.toString();
	}
}

