package com.tgorgics.barcode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import net.sourceforge.barbecue.BarcodeServlet;

@SpringBootApplication
public class BarcodeApplication {

    @Value("${barcode.servlet.mapping}")
    private String barcodeServletMapping;

    @Bean
    public ServletRegistrationBean registerServlet() {
        return new ServletRegistrationBean(new BarcodeServlet(), this.barcodeServletMapping);
    }

    public static void main(final String[] args) {
        SpringApplication.run(BarcodeApplication.class, args);
    }

}
