package ma.youcode.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Root (Business/Persistence) Configuration - ContextLoaderListener equivalent
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{DataConfig.class, ServiceConfig.class};
    }

    // Web (MVC) Configuration - DispatcherServlet equivalent
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    // Map the DispatcherServlet to the root path
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/api/*"}; // All API calls start with /api
    }
}
