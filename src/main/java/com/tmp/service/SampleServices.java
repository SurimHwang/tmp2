package com.tmp.service;

import com.tmp.dto.SampleDTO;

import java.util.List;

public interface SampleServices {

    List<SampleDTO> sampleList();
    
    List<SampleDTO> sampleListId();
    
    List<SampleDTO> sampleListUsernm();
    
    List<SampleDTO> sampleListCrtdt();
    
    void insertUser(SampleDTO dto);
}
