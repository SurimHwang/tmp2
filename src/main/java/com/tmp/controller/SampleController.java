package com.tmp.controller;

import com.tmp.dto.SampleDTO;
import com.tmp.service.SampleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SampleController {

    @Autowired
    private SampleServices sampleServices;

    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    public String sampleIndex(Model model) {
        List<SampleDTO> list = sampleServices.sampleList();
        model.addAttribute("list", list);
        model.addAttribute("test", "sadfsadf");
        return "sample";
    }
}
