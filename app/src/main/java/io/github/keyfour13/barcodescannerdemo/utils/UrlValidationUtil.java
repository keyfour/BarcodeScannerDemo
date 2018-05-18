package io.github.keyfour13.barcodescannerdemo.utils;

import java.net.URL;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Alex Karpov <keyfour13@gmail.com> 2018
 */
@Module
public class UrlValidationUtil {

    @Inject
    UrlValidationUtil() {}

    @Provides @Singleton
    public boolean validateHTTP_URI(String uri) {
        final URL url;
        try {
            url = new URL(uri);
        } catch (Exception e1) {
            return false;
        }
        return "http".equals(url.getProtocol());
    }
}
