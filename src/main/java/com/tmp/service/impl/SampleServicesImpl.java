package com.tmp.service.impl;

import com.tmp.dao.SampleDAO;
import com.tmp.dto.SampleDTO;
import com.tmp.service.SampleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SampleServicesImpl implements SampleServices {

    @Autowired
    private SampleDAO sampleDAO;

    public List<SampleDTO> sampleList() {
        return sampleDAO.sampleList();
    }
    
    public List<SampleDTO> sampleListId() {
        return sampleDAO.sampleListId();
    }
    
    public List<SampleDTO> sampleListUsernm() {
        return sampleDAO.sampleListUsernm();
    }
    
    public List<SampleDTO> sampleListCrtdt() {
        return sampleDAO.sampleListCrtdt();
    }

	public void insertUser(SampleDTO dto) {
		sampleDAO.insertUser(dto);
	}    
    
}
