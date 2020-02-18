package com.babyvote.work.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter buildConfig() {
        //1.添加CORS配置信息
        final CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // 1允许任何域名使用
        config.addAllowedHeader("*"); // 2允许任何头
        config.addAllowedMethod("*"); // 3允许任何方法（post、get等）
        //2) 是否发送Cookie信息
        config.setAllowCredentials(true);
        //5,有效时长
        config.setMaxAge(3600L);
        //2.添加映射路径，我们拦截一切请求
        final UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }
}