package com.index;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class IndexInterceptor implements Interceptor {
	
	public void intercept(Invocation inv) {
		System.out.println("Before invoking " + inv.getActionKey());
		inv.invoke();
		inv.getController().getSession().setAttribute("url",inv.getActionKey());
		System.out.println("After invoking " + inv.getActionKey());
	}
}