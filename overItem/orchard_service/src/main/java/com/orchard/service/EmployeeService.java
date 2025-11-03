package com.orchard.service;


import com.orchard.dto.EmployeePageQueryDTO;
import com.orchard.dto.UserLoginDTO;
import com.orchard.entity.User;
import com.orchard.result.PageResult;

public interface EmployeeService {
    /**
     * 员工登录
     * @param userLoginDTO
     * @return
     */
    User login(UserLoginDTO userLoginDTO);

    /**
     * 员工分页查询
     * @param employeePageQueryDTO
     * @return
     */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);
}
