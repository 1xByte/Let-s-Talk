package com.panda.Let.sTalk.service;

import com.panda.Let.sTalk.dto.UserLogIn;
import com.panda.Let.sTalk.dto.UserSignUp;
import com.panda.Let.sTalk.model.User;

public interface UserService {

    String createNewUser(UserSignUp userSignUp);

    Boolean userLogIn(UserLogIn userLogIn);

    String changePassword(String email, String pass);
}
