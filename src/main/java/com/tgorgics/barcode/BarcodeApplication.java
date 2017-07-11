package com.tgorgics.barcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import net.sourceforge.barbecue.BarcodeServlet;

@SpringBootApplication
public class BarcodeApplication {

    @Autowired
    private Environment env;

    @Bean
    public ServletRegistrationBean registerServlet() {
        return new ServletRegistrationBean(new BarcodeServlet(), this.env.getProperty("barcode.servlet.mapping"));
    }

    public static void main(final String[] args) {
        SpringApplication.run(BarcodeApplication.class, args);
    }

}
