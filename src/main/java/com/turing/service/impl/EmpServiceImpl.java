package com.turing.service.impl;

import com.turing.entity.Emp;
import com.turing.entity.Emp2;
import com.turing.entity.EmpExample;
import com.turing.mapper.EmpMapper;
import com.turing.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;
    @Override
    public List<Emp2> findAll() {
        return empMapper.selectEmpAndDept();
    }

    @Override
    public List<Emp> login(String username, Integer pwd) {

        EmpExample example=new EmpExample();
        example.createCriteria().andEnameEqualTo(username).andEmpnoEqualTo(pwd);
        return empMapper.selectByExample(example);

    }

    @Override
    public boolean del(Integer empNo) {

        return empMapper.deleteByPrimaryKey(empNo)>0;
    }


}
