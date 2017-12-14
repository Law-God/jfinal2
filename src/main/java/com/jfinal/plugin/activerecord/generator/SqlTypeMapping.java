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

package com.jfinal.plugin.activerecord.generator;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * SqlTypeMapping 建立起 getColumnType(i) 到int string double text date blog
 */
public class SqlTypeMapping {
	
	@SuppressWarnings("serial")
	private static Map<Integer, String> map = new HashMap<Integer, String>() {{
		//date
		put(Types.DATE,"date" );
		put(Types.TIME,"date");
		put(Types.TIMESTAMP,"date");

		//int
		put(Types.BIGINT, "int");
		put(Types.INTEGER, "int");
		put(Types.TINYINT, "int");
		put(Types.SMALLINT, "int");
		put(Types.BIT, "int");

		//string
		put(Types.VARCHAR, "string");
		//char
		put(Types.CHAR, "char");

		//double
		put(Types.FLOAT, "double");
		put(Types.DOUBLE, "double");
		put(Types.DECIMAL, "double");

		//text
		put(Types.LONGVARCHAR,"text");
		put(-1000,"longtext");

		//blog
		put(Types.BLOB,"blob");
		put(Types.CLOB,"blob");
		put(Types.LONGVARBINARY,"blob");

	}};
	
	public static String getSqlType(Integer typeString) {
		return map.get(typeString);
	}
}
