package com.tmp.service.impl;

import com.tmp.dao.SampleDAO;
import com.tmp.dto.SampleDTO;
import com.tmp.service.SampleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleServicesImpl implements SampleServices {

    @Autowired
    private SampleDAO sampleDAO;

    public List<SampleDTO> sampleList() {
        return sampleDAO.sampleList();
    }
}
