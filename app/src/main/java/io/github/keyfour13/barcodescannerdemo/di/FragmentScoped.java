/*
 * Copyright (c) Alexander Karpov 2018.
 */

package io.github.keyfour13.barcodescannerdemo.di;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Scope;

/**
 * @author Alex Karpov <keyfour13@gmail.com> 2018
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface FragmentScoped {}


