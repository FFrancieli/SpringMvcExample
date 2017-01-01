package config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(AppConfig.class);
        applicationContext.setServletContext(container);

        DispatcherServlet dispatcher = new DispatcherServlet(applicationContext);
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", dispatcher);

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

    }
}
