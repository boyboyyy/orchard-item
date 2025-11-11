package com.orchard.mapper;

import com.github.pagehelper.Page;
import com.orchard.dto.EmployeePageQueryDTO;
import com.orchard.entity.User;
import com.orchard.result.PageResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {
    /**
     * 根据用户名查找员工
     * @param username
     * @return
     */
    @Select("select * from user where no = #{username}")
     User getUsername(String username);

    /**
     * 根据员工分页参数,查询员工
     * @param employeePageQueryDTO
     * @return
     */
    Page<User> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 根据id查找员工
     * @param id
     */
    @Select("select * from user where id = #{id}")
    User userById(Long id);

    /**
     * 员工修改信息
     * @param user
     */
    void userUpdate(User user);

    /**
     * 插入员工
     * @param user
     */
    void inserUser(User user);
}
