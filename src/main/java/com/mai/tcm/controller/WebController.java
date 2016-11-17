package com.mai.tcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * O(∩_∩)O
 * Created by Billy_Cui on 2016/11/14.
 */
@Controller
@RequestMapping("/web")
public class WebController {

    @RequestMapping("/index")
    public String index() {
        return "/main";
    }

}
