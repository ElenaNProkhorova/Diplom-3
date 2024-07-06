package userApiEditor;

public class LoginUserDeserialization {
    private boolean success;
    private String accessToken;
    private String refreshToken;
    private UserDeserialization user;


    public LoginUserDeserialization() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public UserDeserialization getUser() {
        return user;
    }

    public void setUser(UserDeserialization user) {
        this.user = user;
    }
}
