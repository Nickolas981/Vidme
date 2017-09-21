package com.example.nickolas.vidme.di.scopes;

/**
 * Created by  on 11.04.2017.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@javax.inject.Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface Scope {

    String value() default "";

}
