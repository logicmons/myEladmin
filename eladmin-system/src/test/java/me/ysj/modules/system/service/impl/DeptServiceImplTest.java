package me.ysj.modules.system.service.impl;

import me.ysj.AppRun;
import me.ysj.modules.system.domain.Dept;
import me.ysj.modules.system.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptServiceImplTest {
    @Autowired
    private DeptService deptService;

    @Test
    public void queryAll() {
//        List<Dept> depts = deptService.queryAll();
//        for (Dept dept : depts) {
//            System.out.println(dept);
//        }
    }
}