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
        List<SampleDTO> Idlist = sampleServices.sampleListId();
        List<SampleDTO> Usernmlist = sampleServices.sampleListUsernm();
        List<SampleDTO> Crtdtlist = sampleServices.sampleListCrtdt();
        
        model.addAttribute("list", list);
        model.addAttribute("Idlist", Idlist);
        model.addAttribute("Usernmlist", Usernmlist);
        model.addAttribute("Crtdtlist", Crtdtlist);
        return "sample";
    }
    
    @RequestMapping(value = "/action1", method = RequestMethod.POST)
    public String action1(SampleDTO dto) {
    	
    	sampleServices.insertUser(dto);
    	
    	System.out.println("여기.");
    	
    	return "sample";
    }
}
