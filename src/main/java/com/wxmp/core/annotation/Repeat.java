
package com.wxmp.core.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.METHOD) 
@Documented 
@Inherited
public @interface  Repeat {
	/**
	 * 重发时间
	 * @return
	 */
	 public boolean repeatTime() default true;
	 
	 
	
}
