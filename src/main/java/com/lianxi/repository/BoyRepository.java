package com.lianxi.repository;

import com.lianxi.domain.Boy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoyRepository extends JpaRepository<Boy,Integer> {

    List<Boy> findByAge(Integer age);
}
