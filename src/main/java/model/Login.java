package model;
public class Login {
    private String login;
    private String password;

    public Login(CourierAccount account) {
        this.login = account.getLogin();
        this.password = account.getPassword();
    }

    @Override
    public String toString() {
        return String.format("Логин курьера. Логин: %s; Пароль: %s.", login, password);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Login(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Login() {
    }
}
