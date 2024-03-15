package bingo.bobs.demo.response;

import bingo.bobs.demo.user.User;

import java.util.List;

public class UserListResponse extends Response<List<User>> {

    public UserListResponse(List<User> data) {
        super("success", data);
    }
}