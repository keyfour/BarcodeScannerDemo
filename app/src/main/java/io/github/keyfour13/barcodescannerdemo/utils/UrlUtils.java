package io.github.keyfour13.barcodescannerdemo.utils;

import dagger.Component;

/**
 * @author Alex Karpov <keyfour13@gmail.com> 2018
 */
@Component(modules = {UrlValidationUtil.class})
public interface UrlUtils {
    UrlValidationUtil validationUtil();
}
