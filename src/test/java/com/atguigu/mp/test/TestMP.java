package com.atguigu.mp.test;

import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author gxl
 * @date 2021年08月22日 12:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMP {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * AR 分页复杂操作
     */
    @Test
    public void testARPage(){
        Employee employee = new Employee();
        Page<Employee> emps = employee.selectPage(new Page<>(1, 1), new QueryWrapper<Employee>().like("last_name", "老"));
        emps.getRecords().forEach(System.out::println);
    }

    /**
     * AR 删除操作
     */
    @Test
    public void testARDelete(){
        Employee employee = new Employee();
//        boolean result = employee.deleteById(2);

//        employee.setId(2);
//        boolean result = employee.deleteById();
//        System.out.println("result："+result);

        boolean result = employee.delete(new QueryWrapper<Employee>().like("last_name", "M"));
        System.out.println("result："+result);
    }

    /**
     * AR 查询操作
     */
    @Test
    public void testARSelect(){
        Employee employee = new Employee();
//        Employee result = employee.selectById(13);

//        employee.setId(13);
//        Employee result = employee.selectById();
//        System.out.println(result);

//        List<Employee> emps = employee.selectAll();
//        emps.forEach(System.out::println);

//        List<Employee> emps = employee.selectList(new QueryWrapper<Employee>().like("last_name", "ls"));
//        emps.forEach(System.out::println);

        Integer count = employee.selectCount(new QueryWrapper<Employee>().eq("gender", 0));
        System.out.println(count);
    }

    /**
     * AR 修改操作
     */
    @Test
    public void testARUpdate(){
        Employee employee = new Employee(13,"sslaoshi","ss@sina.com",1,18);

        boolean result = employee.updateById();
        System.out.println("result："+result);
    }

    /**
     * AR 插入操作
     */
    @Test
    public void testARInsert(){
        Employee employee = new Employee("ss","ss@qq.com",1,35);

        boolean result = employee.insert();
        System.out.println("result："+result);
    }
}
