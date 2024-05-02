package demon.controller;

import demon.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

//    private UserServiceImpl userService;
//
//    @Autowired
//    public void setUserService(UserServiceImpl userService) {
//        this.userService = userService;
//    }
//
//    @Autowired
//    public UserController(@Autowired UserServiceImpl userService) {
//        this.userService = userService;
//    }

    public void add() {
        System.out.println("User controller...");
        userService.add();
    }
}
