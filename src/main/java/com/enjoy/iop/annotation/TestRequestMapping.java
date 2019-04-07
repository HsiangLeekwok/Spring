package com.enjoy.iop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2019/04/07 21:02<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Description</b>:
 */
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface TestRequestMapping {
}
