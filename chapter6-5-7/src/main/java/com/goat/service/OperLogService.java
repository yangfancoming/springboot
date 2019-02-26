package com.goat.service;



import com.goat.domain.OperLog;
import com.goat.repository.OpenLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperLogService {

    @Autowired
    OpenLogRepository openLogRepository;

    public void save(OperLog operLog){
        openLogRepository.save(operLog);
    }

}
