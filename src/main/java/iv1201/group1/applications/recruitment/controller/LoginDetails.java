package iv1201.group1.applications.recruitment.controller;

public class LoginDetails {
    String username;
    String password;

    LoginDetails(String username, String password) {
        this.password = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
