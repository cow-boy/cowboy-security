/**
 *
 */
package com.cowboy.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author huxu
 * 自定义注解
 */
@Target({ElementType.METHOD, ElementType.FIELD})    //可以标注在方法上  和  字段上
@Retention(RetentionPolicy.RUNTIME)                 //运行时注解
@Constraint(validatedBy = MyConstraintValidator.class)    //当前注解要哪一个逻辑来注解
public @interface MyConstraint {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
