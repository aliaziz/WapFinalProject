package utils;

public enum ErrorType {
    LOGIN_FAILED, REGISTER_FAILED, POST_FAILED, ACCOUNT_BLOCKED_ERROR;

    public static String getError(ErrorType errorType) {
        String errorResponse = null;

        switch (errorType) {
            case LOGIN_FAILED: {
                errorResponse =  "Error logging in";
                break;
            }
            case POST_FAILED: {
                errorResponse = "Error posting data";
                break;
            }
            case ACCOUNT_BLOCKED_ERROR: {
                errorResponse = "Account blocked, contact admin.";
                break;
            }
            case REGISTER_FAILED: {
                errorResponse = "Registration failed.";
                break;
            }
        }
        return errorResponse;
    }
}
