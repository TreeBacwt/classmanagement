package com.classmanagement.controller;

import com.classmanagement.entity.Parent;
import com.classmanagement.entity.Student;
import com.classmanagement.entity.User;
import com.classmanagement.service.ParentService;
import com.classmanagement.service.StudentService;
import com.classmanagement.service.UserService;
import com.classmanagement.util.Md5Util;
import com.classmanagement.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    final
    UserService userService;
    final
    StudentService studentService;
    final
    ParentService parentService;

    static Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService, StudentService studentService, ParentService parentService) {
        this.userService = userService;
        this.studentService = studentService;
        this.parentService = parentService;
    }

    /*处理账户名重复异常*/
    @ExceptionHandler({DuplicateKeyException.class})
    protected Result handleDuplicateKeyException(DuplicateKeyException e){
        logger.error(e.toString());
        return Result.fail("账户名已存在！");
    }

    @PostMapping("/login")
    public Result login(User user){
        User userFromDB = userService.queryUserByAccount(user.getAccount());
        if (userFromDB != null) {
            if (Md5Util.verify(user.getPassword(), userFromDB.getPassword())) {
                //密码正确
                User u = new User();
                u.setId(userFromDB.getId());
                u.setAccount(userFromDB.getAccount());
                u.setRole(userFromDB.getRole());
                return Result.success("登录成功", u);
            }else return Result.fail("密码错误");
        }else return Result.fail("用户名不存在！");
    }

    /*注册学生账号*/
    @PostMapping("/register/stu")
    public Result registerStudent(Student student, @RequestParam("account") String account){
        User user = new User(account, "123456", 2);//密码默认为123456
        Integer userId = studentService.addStudent(user, student);
        return new Result(userId, "用户ID");
    }

    /*注册家长账号*/
    @PostMapping("/register/par")
    public Result registerParent(Parent parent, @RequestParam("account") String account){
        Result result = new Result();
        User user = new User(account, "123456", 3);
        parentService.addParent(user, parent);
        result.setCode(Result.SUCCESS);
        result.setMessage("注册成功");
        user.setPassword(null);
        result.setData(user);
        return result;
    }

    @PutMapping("/upd/psw")
    public Result updatePassword(@RequestParam("id") Integer id, @RequestParam("password") String psw){
        Integer updatePasswordById = userService.updatePasswordById(id, Md5Util.md5(psw));
        if (updatePasswordById == 1) {
            return Result.success("密码修改成功！");
        }else return Result.fail("密码修改失败！");
    }
}
