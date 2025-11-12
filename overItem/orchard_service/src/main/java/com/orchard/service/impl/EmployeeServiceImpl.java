package com.orchard.service.impl;


import com.alibaba.fastjson.serializer.BeanContext;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.orchard.constant.MessageConstant;
import com.orchard.constant.PasswordConstant;
import com.orchard.constant.StatusConstant;
import com.orchard.context.BaseContext;
import com.orchard.dto.EmployeeDTO;
import com.orchard.dto.EmployeePageQueryDTO;
import com.orchard.dto.EmployeeStartOrStopDTO;
import com.orchard.dto.UserLoginDTO;
import com.orchard.entity.User;
import com.orchard.exception.AccountLockedException;
import com.orchard.exception.AccountNotFoundException;
import com.orchard.exception.PasswordErrorException;
import com.orchard.mapper.EmployeeMapper;
import com.orchard.result.PageResult;
import com.orchard.service.EmployeeService;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getNo();
        String password = userLoginDTO.getPassword();
        User user = employeeMapper.getUsername(username);
        //判断账号不存在
        if(user == null){
            throw new  AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        //密码md5加密,string转Bytes
         password = DigestUtils.md5DigestAsHex(password.getBytes());
        //判断密码是否符合数据库密码
        if(!password.equals(user.getPassword())){
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        //如果账户已被禁止
        if(user.getIsValid() == StatusConstant.DISABLE){
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }
        //返回所有的成员
        return user;
    }

    /**
     * 员工分页查询
     * @param employeePageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO) {
        //使用PageHelper分页管理器
        PageHelper.startPage(employeePageQueryDTO.getPageNumber(),employeePageQueryDTO.getPageSize());
        //模糊查询员工
        Page<User> page =  employeeMapper.pageQuery(employeePageQueryDTO);
        long total = page.getTotal();
        List<User>  records  = page.getResult();
        //返回前端分页数据
        return new PageResult(total,records);
    }

    /**
     * 根据id查找员工
     * @param id
     */
    @Override
    public User userById(Long id) {
      User employy = employeeMapper.userById(id);
      //考虑返回员工会返回密码，故设置密码防止暴露出去
        employy.setPassword("********");
      return employy;
    }

    /**
     * 修改员工信息
     * @param employeeDTO
     */
    @Override
    public void userUpdate(EmployeeDTO employeeDTO) {
        //将数据拷贝给后端
        User user = new User();
        BeanUtils.copyProperties(employeeDTO,user);
        user.setUpdateTime(LocalDateTime.now());
        user.setUpdateUser(BaseContext.getCurrentId());
        employeeMapper.userUpdate(user);
    }




    /**
     * 启动或禁用员工
     * @param isValid
     * @param id
     */
    @Override
    public void startOrStop(Integer isValid, Long id) {
      User user =  new User().builder()
                .isValid(isValid)
              .id(id).build();
      employeeMapper.userUpdate(user);
    }

    /**
     * 新增员工
     * @param employeeDTO
     */
    @Override
    public void UserAdd(EmployeeDTO employeeDTO) {
        User user = new User();
        BeanUtils.copyProperties(employeeDTO,user);
        //没有copy密码这里需要自定义,和isValid
        user.setIsValid(StatusConstant.ENABLE);
        user.setPassword(DigestUtils.md5DigestAsHex(PasswordConstant.DEFAULT_PASSWORD.getBytes()));
        //自定义时间和人
//        user.setCreateUser(BaseContext.getCurrentId());
//        user.setCreateTime(LocalDateTime.now());
        user.setUpdateUser(BaseContext.getCurrentId());
        user.setUpdateTime(LocalDateTime.now());

        employeeMapper.inserUser(user);
    }


}
