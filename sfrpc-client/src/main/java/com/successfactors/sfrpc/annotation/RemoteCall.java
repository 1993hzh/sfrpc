package com.successfactors.sfrpc.annotation;

import java.lang.annotation.*;

/**
 * Created by I322901 on 2/18/2017.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface RemoteCall {
}
