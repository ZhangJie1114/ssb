package com.zhangjie.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
	String str();
	int val();
}
public class Meta {
	@MyAnno(str = "Annotation Example", val = 100)
	public static void myMeth(){
		Meta ob = new Meta();
		
		try{
			//getClass()获取该对象的class对象，相当于Class<?> c = Meta.class;
			Class<?> c = ob.getClass();
			//getMethod获取改对象的方法
			java.lang.reflect.Method m =c.getMethod("myMeth");
			
			MyAnno anno = m.getAnnotation(MyAnno.class);
			
			System.out.println(anno.str() + " " + anno.val());
		}catch(NoSuchMethodException exc){
			System.out.println("Method Not Found.");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMeth();
	}
}
