package utils;

import com.google.gson.Gson;

public enum ErrorType {
    LOGIN_FAILED, REGISTER_FAILED, POST_FAILED, FAILED_ATTEMPT;

    public static String getError(ErrorType errorType) {
        Gson gson = new Gson();
        String errorResponse = null;

        switch (errorType) {
            case LOGIN_FAILED: {
                errorResponse = gson.toJson(new ErrorResponse(20, "Error logging in"));
                break;
            }
            case POST_FAILED: {
                errorResponse = gson.toJson(new ErrorResponse(21, "Error posting data"));
                break;
            }
            case FAILED_ATTEMPT: {
                errorResponse = gson.toJson(new ErrorResponse(22, "Account blocked, contact admin."));
                break;
            }
            case REGISTER_FAILED: {
                errorResponse = gson.toJson(new ErrorResponse(23, "Registration failed."));
                break;
            }
        }
        return errorResponse;
    }
}
