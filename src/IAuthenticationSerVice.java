public interface IAuthenticationSerVice {
    User signUp(String username, String password);
    User logIn(String username, String password);
}
