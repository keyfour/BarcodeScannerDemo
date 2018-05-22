/*
 * Copyright (c) Alexander Karpov 2018.
 */

package io.github.keyfour13.barcodescannerdemo.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author Alex Karpov <keyfour13@gmail.com> 2018
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScoped {
}
