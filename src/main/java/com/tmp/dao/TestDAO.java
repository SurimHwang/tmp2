package com.tmp.dao;

import com.tmp.dto.TestDTO;
import java.util.List;


public interface TestDAO {
	
    List<TestDTO> login(TestDTO dto);  
        
    void signUp(TestDTO dto);
    
    void updateUserName(TestDTO dto);
    
    void deleteUser(TestDTO dto);
    
}
