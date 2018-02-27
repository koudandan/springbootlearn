package com.chinamobile.cmss.tbd.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hjb on 2018/2/23.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        return "index";
    }
    @RequestMapping(value = "/goods",method = RequestMethod.GET)
    public String goods(Model model){
        return "goods";
    }

    @RequestMapping(value = "/shop",method = RequestMethod.GET)
    public String shop(Model model){
        return "flow";
    }
}
