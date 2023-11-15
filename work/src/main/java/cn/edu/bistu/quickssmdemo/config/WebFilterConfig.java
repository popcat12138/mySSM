package cn.edu.bistu.quickssmdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebFilterConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtWebFilter())
                .addPathPatterns("/admin/**","/collect/**","/book/addOrUpdateBook","/book/delete/**")
                .addPathPatterns("/case/addOrUpdateCase","/case/delete/**","/comb/addOrUpdateComb","/comb/delete/**")
                .addPathPatterns("/drug/addOrUpdateDrug","/drug/delete/**")// 拦截所有请求，通过判断token是否合法来决定是否需要登录
                .excludePathPatterns("/book/bookManage","/book/getBook/**","/book/moreCollect/")
                .excludePathPatterns("/case/caseManage","/case/getCase/**","/case/moreCollect/")//基本的查询放行
                .excludePathPatterns("/comb/combManage","/comb/getComb/**")
                .excludePathPatterns("/drug/drugManage","/drug/getDrug/**")
                .excludePathPatterns("/userAction/**","/admin//uploadFile")
                .excludePathPatterns( "/**/**.pdf","/**/**.png","/**/**.jpg");  // 放行静态文件
    }
    @Bean
    public JWTWebFilter jwtWebFilter() {
        return new JWTWebFilter();
    }
}
