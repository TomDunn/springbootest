package demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Renders index page
 */
@Controller
@Slf4j
public class Home {

    @Value("${application.author}") private String appAuthor = "default";
    private static final String builtByMessage = "Built by: ";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(final Map<String, Object> model) {
        model.put("message", builtByMessage + appAuthor);
        log.info(String.format("Author is [%s]", appAuthor));
        return "pages/index";
    }
}
