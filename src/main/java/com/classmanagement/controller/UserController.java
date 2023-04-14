package com.classmanagement.controller;

import com.classmanagement.entity.Parent;
import com.classmanagement.entity.Student;
import com.classmanagement.entity.User;
import com.classmanagement.entity.UserWithName;
import com.classmanagement.service.ParentService;
import com.classmanagement.service.StudentService;
import com.classmanagement.service.UserService;
import com.classmanagement.util.Md5Util;
import com.classmanagement.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
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
    protected Result handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.toString());
        return Result.fail("账户名已存在！");
    }

    @PostMapping("/login")
    public Result login(User user) {
        User userFromDB = userService.queryUserByAccount(user.getAccount());
        if (userFromDB != null) {
            if (Md5Util.verify(user.getPassword(), userFromDB.getPassword())) {
                //密码正确
                User u = new User();
                u.setId(userFromDB.getId());
                u.setAccount(userFromDB.getAccount());
                u.setRole(userFromDB.getRole());
                return Result.success("登录成功", u);
            } else return Result.fail("密码错误");
        } else return Result.fail("用户名不存在！");
    }

    /*注册学生账号*/
    @PostMapping("/register/stu")
    public Result registerStudent(Student student, @RequestParam("account") String account) {
        User user = new User(account, "123456", 2);//密码默认为123456
        Integer addStudent = studentService.addStudent(user, student);
        if (addStudent != 0) {
            return Result.success("学生账户添加成功！");
        } else return Result.fail("添加出错，请稍后再试！");
    }

    /*注册家长账号*/
    @PostMapping("/register/par")
    public Result registerParent(Parent parent, @RequestParam("account") String account) {
        User user = new User(account, "123456", 3);
        Integer addParent = parentService.addParent(user, parent);
        if (addParent != 0) {
            return Result.success("家长账户添加成功！");
        } else return Result.fail("添加出错，请稍后再试！");
    }

    @PutMapping("/upd/psw")
    public Result updatePassword(@RequestParam("id") Integer id, @RequestParam("oldPassword") String oldPsw, @RequestParam("newPassword") String newPsw) {
        User userFromDB = userService.queryUserById(id);
        if (userFromDB != null) {
            if (Md5Util.verify(oldPsw, userFromDB.getPassword())) {
                //密码正确
                Integer updatePasswordById = userService.updatePasswordById(id, Md5Util.md5(newPsw));
                if (updatePasswordById == 1) {
                    return Result.success("密码修改成功！");
                } else return Result.fail("发生错误,请稍后再试！");
            } else return Result.fail("密码错误");
        } else return new Result(-1, "没有相关数据，请重新登录！");
    }

    /*分页方式返回user，页面大小为10*/
    @GetMapping("/list/{page}")
    public Result getUsersByPageSize10(@PathVariable("page") Integer page) {
        List<User> users = userService.queryUsersLimitIn10(page);
        if (users.size() != 0) {
            return Result.success("第" + page + "页查找成功！", users);
        } else return Result.fail("没有相关数据！");
    }

    @GetMapping("/all")
    public Result getAllUsers() {
        List<UserWithName> userWithNames = userService.queryAllUsersWithName();
        if (userWithNames.size() != 0) {
            return Result.success("查找成功！", userWithNames);
        } else return Result.fail("没有相关数据！");
    }

    @DeleteMapping("/delete")
    public Result deleteUserById(@RequestParam("id") Integer id) {
        Integer deleteUserById = userService.deleteUserById(id);
        if (deleteUserById == 1) {
            return Result.success("删除用户成功！");
        } else return Result.fail("删除用户失败！");
    }

    @GetMapping("/checkAccount/{account}")
    public Result checkAccountIsDuplicate(@PathVariable("account") String account) {
        User user = userService.queryUserByAccount(account);
        if (user != null) {
            return Result.fail("该账户名已存在！");
        } else return Result.success("该账户名可用！");
    }
}
