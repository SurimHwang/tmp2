package com.tmp.service;

import com.tmp.dto.TestDTO;

import java.util.List;

public interface TestServices {

    TestDTO login(TestDTO dto);
    
    void signUp(TestDTO dto);
    
    void updateUserName(TestDTO dto);
    
    void deleteUser(TestDTO dto);
    
}
