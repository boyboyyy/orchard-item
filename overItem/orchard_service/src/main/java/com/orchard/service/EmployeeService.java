package com.orchard.service;


import com.orchard.dto.EmployeeDTO;
import com.orchard.dto.EmployeePageQueryDTO;
import com.orchard.dto.EmployeeStartOrStopDTO;
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

    /**
     * 根据员工id查找员工
     * @param id
     */
    User userById(Long id);

    /**
     * 修改员工信息
     * @param employeeDTO
     */

    void userUpdate(EmployeeDTO employeeDTO);

    /**
     * 禁用或启动员工
     * @param isValid
     * @param id
     */

    void startOrStop(Integer isValid, Long id);

    /**
     * 新增员工
     * @param employeeDTO
     */
    void UserAdd(EmployeeDTO employeeDTO);
}
