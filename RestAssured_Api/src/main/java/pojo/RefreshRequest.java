package pojo;

public class RefreshRequest {

    private String refreshToken;
    private int expiresInMins;

    public RefreshRequest(String refreshToken, int expiresInMins) {
        this.refreshToken = refreshToken;
        this.expiresInMins = expiresInMins;
    }

    public String getRefreshToken() { return refreshToken; }
    public int getExpiresInMins() { return expiresInMins; }
}
