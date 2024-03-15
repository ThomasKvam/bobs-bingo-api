package bingo.bobs.demo.response;

public class ErrorResponse extends Response<java.lang.Error>{

    public ErrorResponse(java.lang.Error data) {
        super("Error", data);
    }
}
