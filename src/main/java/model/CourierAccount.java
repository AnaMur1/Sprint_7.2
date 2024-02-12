package model;

public class CourierAccount {
    private String login;
    private String password;
    private String firstName;

    @Override
    public String toString() {
        return String.format("Аккаунт курьера. Логин: %s; Пароль: %s; Имя: %s.", login, password, firstName);
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public CourierAccount(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public CourierAccount() {
    }
}
