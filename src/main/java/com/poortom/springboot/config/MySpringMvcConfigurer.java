//package com.poortom.springboot.config;
//
//import com.poortom.springboot.component.MyLocaleResolver;
//import com.poortom.springboot.interceptor.LoginHandlerInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * Created by 13620 on 2019/5/26.
// */
//@Configuration
//public class MySpringMvcConfigurer {
//
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer(){
//       return new WebMvcConfigurer(){
//           //添加了视图控制器
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("/api/user/logging");
//                registry.addViewController("index.html").setViewName("/api/user/logging");
//                registry.addViewController("main.html").setViewName("/api/user/logging");
//
//            }
//
//           @Override
//           public void addInterceptors(InterceptorRegistry registry) {
//
//                registry.addInterceptor(new LoginHandlerInterceptor())
//                        //指定要拦截的请求  /**标识拦截所有请求
//                        .addPathPatterns("/**")
//                        //排除不需要拦截的路径
//                        .excludePathPatterns("/","/index.html","/login","/api/*")
//                        //springboot2之后需要将静态资源文件的访问路径 也排除
//                        .excludePathPatterns("/css/*","/img/*","/js/*");
//           }
//       };
//    }
//
//    @Bean
//    public LocaleResolver localeResolver(){
//        return new MyLocaleResolver();
//    }
//}
