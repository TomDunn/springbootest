package demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by tom on 7/18/15.
 */
@Controller
public class Home {

    @Value("${application.author}")
    private String appAuthor = "default";
    private static final String builtByMessage = "Built by: ";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(final Map<String, Object> model) {
        model.put("message", builtByMessage + appAuthor);
        return "pages/index";
    }
}
