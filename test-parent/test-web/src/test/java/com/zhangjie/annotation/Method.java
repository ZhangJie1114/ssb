package com.zhangjie.annotation;
import java.lang.reflect.*;

public class Method {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		// 获取类
		Class<?> c = Class.forName("java.lang.String");
		// 获取所有的方法
		java.lang.reflect.Method[] ms = c.getDeclaredMethods();
		// 遍历输出所有方法
		for (java.lang.reflect.Method method : ms) {
			// 获取方法所有参数
			Parameter[] parameters = method.getParameters();
			String params = "";
			if (parameters.length > 0) {
				StringBuffer stringBuffer = new StringBuffer();
				for (Parameter parameter : parameters) {
					stringBuffer.append(parameter.getType().getSimpleName() + " " + parameter.getName() + ",");
				}
				// 去掉最后一个逗号
				params = stringBuffer.substring(0, stringBuffer.length() - 1);
			}
			System.err.println(Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getSimpleName()
					+ " " + method.getName() + " (" + params + ")");
		}
	}

}
