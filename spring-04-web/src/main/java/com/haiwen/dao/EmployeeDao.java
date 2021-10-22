package com.haiwen.dao;

import com.haiwen.pojo.Department;
import com.haiwen.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工dao

public class EmployeeDao {

    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;

    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static{
        employees = new HashMap<Integer,Employee>(); //创建一个部门表

        employees.put(101, new Employee(101,"AA","2345223@qq.com",0,new Department(101,"教学部") ));
        employees.put(102, new Employee(102,"AA","2345223@qq.com",0,new Department(101,"市场部") ));
        employees.put(103, new Employee(103,"AA","2345223@qq.com",0,new Department(101,"教研部") ));
        employees.put(104, new Employee(104,"AA","2345223@qq.com",0,new Department(101,"运营部") ));
        employees.put(105, new Employee(105,"AA","2345223@qq.com",0,new Department(101,"后勤部") ));
    }

    //主键自增
    private static Integer initId = 1006;
    //增加一个员工
    public void save(Employee employee)
    {
        if (employee.getId()==null)
        {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentByid(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeByid(Integer id)
    {
        return employees.get(id);
    }

    //通过id删除员工
    public void delete(Integer id)
    {
        employees.remove(id);
    }
}
