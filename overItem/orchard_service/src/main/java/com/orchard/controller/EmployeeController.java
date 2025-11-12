package com.orchard.controller;

import com.orchard.constant.JwtClaimsConstant;
import com.orchard.dto.EmployeeDTO;
import com.orchard.dto.EmployeePageQueryDTO;
import com.orchard.dto.EmployeeStartOrStopDTO;
import com.orchard.dto.UserLoginDTO;
import com.orchard.entity.User;
import com.orchard.properties.JwtProperties;
import com.orchard.result.PageResult;
import com.orchard.result.Result;
import com.orchard.service.EmployeeService;
import com.orchard.utils.JwtUtil;
import com.orchard.vo.UserLoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/user")
@Api(tags="员工相关接口")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 登录
     * @param userLoginDTO
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("员工登录")
    public Result<UserLoginVo> login(@RequestBody UserLoginDTO userLoginDTO){
        log.info("员工登录",userLoginDTO);
        User employeeLogin = employeeService.login(userLoginDTO);
        //员工登录成功后,生成jwt令牌
        HashMap<String, Object> claims = new HashMap<>();
        //定于用户的id
        claims.put(JwtClaimsConstant.EMP_ID,employeeLogin.getId());
        //创建jwt令牌
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey()
                ,jwtProperties.getAdminTtl()
                ,claims);
        //将token等数据返回给前端,将数据拷贝并传递给前端
        UserLoginVo userLoginVo = UserLoginVo.builder()
                .id(employeeLogin.getId())
                .username(employeeLogin.getNo())
                .name(employeeLogin.getName())
                .token(token)
                .phone(employeeLogin.getPhone())
                .no(employeeLogin.getNo())
                .build();
        return Result.success(userLoginVo);

    }

    /**
     * 员工分页查询
     * @param employeePageQueryDTO
     * @return
     */
    @GetMapping ("/listPageData")
    @ApiOperation("员工分页查询")
    public Result<PageResult> page(EmployeePageQueryDTO employeePageQueryDTO){
        log.info("员工参数",employeePageQueryDTO);
        //实现分页操作
        PageResult pageResult = employeeService.pageQuery(employeePageQueryDTO);
        //传递前端数据
        return Result.success(pageResult);
    }
    @ApiOperation("根据id查询员工")
    @GetMapping("/{id}")
    public Result<User> userById(@PathVariable Long id){
        log.info("员工id",id);
        User user = employeeService.userById(id);
        return Result.success(user);
    }
    @ApiOperation("修改用户信息")
    @PutMapping("/mod")
    public Result userUpdate(@RequestBody EmployeeDTO employeeDTO){
        log.info("员工信息",employeeDTO);
        employeeService.userUpdate(employeeDTO);
        return Result.success();
    }
    @ApiOperation("禁用或启动员工")
    @GetMapping("/status/{isValid}/{id}")
    public Result startOrStop (@PathVariable Integer isValid,@PathVariable  Long id){
        log.info("isValid",isValid);
        employeeService.startOrStop(isValid,id);
        return Result.success();
    }
    @ApiOperation("员工新增功能")
    @PostMapping("/UserAdd")
    public  Result UserAdd(@RequestBody EmployeeDTO employeeDTO){
        log.info("userAddinfo",employeeDTO);
        employeeService.UserAdd(employeeDTO);
        return  Result.success();
    }
}
