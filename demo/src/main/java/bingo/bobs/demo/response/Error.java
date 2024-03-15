package bingo.bobs.demo.response;

import lombok.Getter;

@Getter
public class Error {
    private String message;

    public Error (String message) {
        this.message = message;
    }
}
