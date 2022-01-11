package com.turing.service;

import com.turing.entity.Emp;
import com.turing.entity.Emp2;

import java.util.List;

public interface EmpService {

    public List<Emp2> findAll();

    public List<Emp> login(String username,Integer pwd);

    /**
     * 根据id删除员工
     * @param empNo 员工编号
     * @return 是否删除成功
     */
     public boolean del(Integer empNo);

}
