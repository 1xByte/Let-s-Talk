package com.panda.Let.sTalk.service;

import com.panda.Let.sTalk.dto.ChangePass;
import com.panda.Let.sTalk.dto.UserLogIn;
import com.panda.Let.sTalk.dto.UserSignUp;
import com.panda.Let.sTalk.model.User;
import com.panda.Let.sTalk.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public String createNewUser(UserSignUp userSignUp) {

        User user = User.builder()
                .userEmail(userSignUp.getUserEmail())
                .username(userSignUp.getUsername())
                .password(userSignUp.getPassword())
                .build();

        userRepo.save(user);

        return "User Created";
    }

    @Override
    public Boolean userLogIn(UserLogIn userLogIn) {

        Optional<User> repo = userRepo.findByUserEmail(userLogIn.getUserEmail());

        if (repo.isPresent() && repo.get().getPassword().equals(userLogIn.getPassword())) {

            return true;
        }
        return false;
    }

    @Override
    public String changePassword(ChangePass changePass) {
        Optional<User> repo = userRepo.findByUserEmail(changePass.getUserEmail());

        if (repo.isPresent() && !repo.get().getPassword().equals(changePass.getUserPass())) {
            repo.get().setPassword(changePass.getNewPass());
        }
        userRepo.save(repo.get());

        return "Pass Changed";
    }
}
