package bingo.bobs.demo.response;

import bingo.bobs.demo.user.User;


public class UserResponse extends Response<User>{

    public UserResponse(User user) {
        super("success", user);
    }
}