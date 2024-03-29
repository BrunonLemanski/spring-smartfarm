package pl.retrix.smartfarm.payload;

public class JWTLoginSuccesResponse {
    private boolean success;
    private String token;

    public JWTLoginSuccesResponse(boolean success, String token) {
        this.success = success;
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "JWTLoginSuccesResponse{" +
                "success=" + success +
                ", token='" + token + '\'' +
                '}';
    }
}
