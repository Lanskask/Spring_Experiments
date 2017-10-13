package ru.smurtazin.ownsprtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/one/")
public class OneController {

    @Resource(name="firstService")
    private FirstService firstService;

    @GetMapping("/first/")
//    @RequestMapping("/first/")
    public String firstResponse() {
        return "Hello in firstResponse " + firstService.backString("World ");
    }
}
