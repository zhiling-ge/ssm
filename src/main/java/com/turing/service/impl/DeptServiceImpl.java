package com.turing.service.impl;

import com.turing.entity.Dept;
import com.turing.mapper.DeptMapper;
import com.turing.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class DeptServiceImpl  implements DeptService{

     @Resource
     private DeptMapper deptMapper;

    @Override
    public Dept findById(Integer id) {

        return deptMapper.selectByPrimaryKey(id);
    }

    @Override
   // @Transactional
    public boolean insert(Dept dept) {

        for(int i=1;i<=10;i++){
            if(i==5){
                throw new RuntimeException("出错了！");
            }
            deptMapper.insertSelective(dept);
        }
         return true;
    }


}
