package com.consultar.config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

//@Configuration
//@EnableWebMvc
@ComponentScan("com.thymeleafexamples")
public class ThymeleafConfig  {

//    private ApplicationContext applicationContext;
//
//    public void setApplicationContext(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }
//
//    @Bean
//    public ViewResolver viewResolver() {
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine(templateEngine());
//        resolver.setCharacterEncoding("UTF-8");
//        return resolver;
//    }
//
//    @Bean
//    public TemplateEngine templateEngine() {
//        SpringTemplateEngine engine = new SpringTemplateEngine();
//        engine.setEnableSpringELCompiler(true);
//        engine.setTemplateResolver(templateResolver());
//        return engine;
//    }
//
//    private ITemplateResolver templateResolver() {
//        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//        resolver.setApplicationContext(applicationContext);
//        resolver.setPrefix("/resources/templates/");
//        resolver.setTemplateMode(TemplateMode.HTML);
//        return resolver;
//    }
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/resources");
//        viewResolver.setSuffix(".html");
//        registry.viewResolver(viewResolver);
//    }
//
//    @Bean(name = "multipartResolver")
//    public StandardServletMultipartResolver resolver() {
//        return new StandardServletMultipartResolver();
//    }
//
//    @Bean
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasename("messages");
//        return messageSource;
//    }
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations(
//                "/static/");
//
//    }
}