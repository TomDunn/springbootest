package demo.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.mustache.MustacheViewResolver;
import org.springframework.web.servlet.view.mustache.java.MustacheJTemplateFactory;

/**
 * Allows Spring to resolve Mustache views/templates
 */

@Configuration
public class ViewResolverProvider {

    // View location
    @Value("${application.view.prefix}") private String viewPrefix;
    @Value("${application.view.suffix}") private String viewSuffix;

    // View content type
    @Value("${application.view.contentType}") private String viewContentType;

    @Bean
    public ViewResolver viewResolver(final ResourceLoader resourceLoader) {
        final MustacheViewResolver mustacheViewResolver = new MustacheViewResolver();

        mustacheViewResolver.setPrefix(viewPrefix);
        mustacheViewResolver.setSuffix(viewSuffix);
        mustacheViewResolver.setCache(true);
        mustacheViewResolver.setContentType(viewContentType);

        final MustacheJTemplateFactory mustacheJTemplateFactory = new MustacheJTemplateFactory();
        mustacheJTemplateFactory.setResourceLoader(resourceLoader);

        mustacheViewResolver.setTemplateFactory(mustacheJTemplateFactory);
        return mustacheViewResolver;
    }
}
