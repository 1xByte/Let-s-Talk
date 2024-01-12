package com.panda.Let.sTalk.service;

import com.panda.Let.sTalk.dto.UserLogIn;
import com.panda.Let.sTalk.dto.UserSignUp;
import com.panda.Let.sTalk.model.User;
import com.panda.Let.sTalk.repo.UserRepo;

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
    public String changePassword(String email, String pass) {
        Optional<User> repo = userRepo.findByUserEmail(email);

        if (repo.isPresent() && !repo.get().getPassword().equals(pass)) {
            repo.get().setPassword(pass);
        }
        userRepo.save(repo.get());

        return "Pass Changed";
    }
}
