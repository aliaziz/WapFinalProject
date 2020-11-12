package utils;

public class ErrorResponse {
    private int errorCode;
    private String errorDescription;

    public ErrorResponse(int errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }
}