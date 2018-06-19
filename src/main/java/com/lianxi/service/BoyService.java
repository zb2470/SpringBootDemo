package com.lianxi.service;

import com.lianxi.domain.Boy;
import com.lianxi.enums.ResultEnum;
import com.lianxi.exception.BoyException;
import com.lianxi.repository.BoyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoyService {
    @Autowired
    private BoyRepository boyRepository;

    public void insertBoy() {
        Boy bA = new Boy() {
        };
        bA.setAge(18);
        bA.setName("xi");
        bA = boyRepository.save(bA);
    }

    @Transactional
    public void insertTwoBoy() {
        Boy bA = new Boy() {
        };
        bA.setAge(18);
        bA.setName("xi");
        bA = boyRepository.save(bA);

        Boy bB = new Boy() {
        };
        bB.setAge(18);
        bB.setName("xiaowang");
        bB = boyRepository.save(bB);
    }

    public void getAge(Integer id) throws Exception {
        Boy boy = boyRepository.findById(id).get();
        Integer age = boy.getAge();
        if (age <= 10) {
            throw new BoyException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10&&age<=16){
            throw new BoyException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
}
