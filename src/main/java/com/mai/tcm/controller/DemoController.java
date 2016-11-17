package com.mai.tcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * O(∩_∩)O
 * Created by Billy_Cui on 2016/11/3.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/website")
    public String webSite(Model model,HttpServletRequest request){


        return "website";
    }
}
