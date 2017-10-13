package com.example.bindview;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 喜欢用$代替BindView
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface $ {
        int value();
}
