package com.business.item;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class ItemInterceptor implements Interceptor {
	
	public void intercept(Invocation inv) {
		System.out.println("Before invoking " + inv.getActionKey());
		inv.invoke();
		System.out.println("After invoking " + inv.getActionKey());
	}
}