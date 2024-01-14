package com.panda.Let.sTalk.Cont;

import com.panda.Let.sTalk.dto.ChangePass;
import com.panda.Let.sTalk.dto.UserLogIn;
import com.panda.Let.sTalk.dto.UserSignUp;
import com.panda.Let.sTalk.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserCont {

    private UserService service;


    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public String userSignUp(@RequestBody UserSignUp signUp){

        return service.createNewUser(signUp);
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody UserLogIn logIn){

        return service.userLogIn(logIn) ? "Login Succeed" : "Invalid Cred";
    }

    @PostMapping("/change-pass")
    public String changePass(@RequestBody ChangePass changePass){

        return service.changePassword(changePass);
    }
}
