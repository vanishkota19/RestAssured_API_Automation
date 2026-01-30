package pojo;

public class LoginResponse {

    private int id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String accessToken;
    private String refreshToken;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
