package com.whyischen.jseed.springlearn;

import com.whyischen.jseed.autumn.ApplicationContext;
import com.whyischen.jseed.springlearn.config.AppConfig;

public class SpringLearnAutumnApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext(AppConfig.class);
    }

}
