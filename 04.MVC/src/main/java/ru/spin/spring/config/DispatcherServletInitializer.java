package ru.spin.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Вместо файла web.xml
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //AbstractAnnotationConfigDispatcherServletInitializer реализует интерфейс WebApplicationInitializer за нас
    /*@Override
    public void onStartup(ServletContext container) {
        //Код из web.xml
    }*/

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
