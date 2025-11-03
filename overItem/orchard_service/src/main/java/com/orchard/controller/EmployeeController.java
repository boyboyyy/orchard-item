package com.orchard.controller;

import com.orchard.constant.JwtClaimsConstant;
import com.orchard.dto.EmployeePageQueryDTO;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result<PageResult> page(EmployeePageQueryDTO employeePageQueryDTO){
        log.info("员工参数",employeePageQueryDTO);
        //实现分页操作
        PageResult pageResult = employeeService.pageQuery(employeePageQueryDTO);
        //传递前端数据
        return null;
    }
}
