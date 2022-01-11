package com.turing.service;

import com.turing.entity.Dept;

public interface DeptService {

      public Dept findById(Integer id);

      public boolean insert(Dept dept);
}
