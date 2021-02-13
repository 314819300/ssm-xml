package com.db.common.annotation;


import java.lang.annotation.Retention;


import java.lang.annotation.Target;

/**
 * 自定义注解
 * 1.JDK1.5推出的一种元数据（描述数据的数据）
 * 2.本质上是一种特殊的class
 * 3.主要用于描述类，方法，属性，参数等对象
 * 
 * 注解的应用
 * 咱们不能定义编译时的注解，除非你自己能够写编译器，所以我们自定义的注解都是运行时生效的
 * 1)编译时，例如@Override，仅在编译时有效，这些注解会结合反射应用的
 * 2)运行时，@Controller，...
 * 
 * 自定义注解
 * 1)框架中定义（重应用）
 * 2)自己定义？
 * a)借助@interface关键字进行定义
 * b)使用@Target描述注解可以修饰哪些对象
 * c)使用@Retention描述注解何时有效。
 * 
 * 思考：spring中描述bean对象方式
 * 1)xml <bean id="" class="">
 * 2)注解@Service，@Controller ...
 * @author acer
 * @Target(ElementType.METHOD)
 */
//两种写法
//1.静态引入
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;
@Target(value = METHOD)
@Retention(value = SOURCE)
//2.
//import java.lang.annotation.ElementType;
//import java.lang.annotation.RetentionPolicy;
//@Retention(RetentionPolicy.RUNTIME)//运行时有效，@Retention(RetentionPolicy.SOURCE)，如果改成SOURCE，编译时生效，就不会有效果
//@Target(ElementType.METHOD)//只能修饰方法，要想同时修饰方法和类，就需要一个数组，例如@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
public @interface RequiredLog {
	//自定义注解中有一个默认的属性value，
	//注解里面的属性可以这样写，这个地方如果不定义默认值，只写String value();在注解中就必须写一个值
	//否则就会报错，要是想要可以不写也不会报错，就必须要定义默认值
	String value() default "";
	
	
	
}
