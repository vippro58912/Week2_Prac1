import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<User> users = new ArrayList<>();
    private static IAuthenticationSerVice authService = new IAuthenticationSerVice() {
        @Override
        // Muc dang ky
        public User signUp(String username, String password) {
            //Kiem tra xem user co ton tai hay khong?
          for (User user: users) {
              if (user.getUsername().equals(username)) {
                  System.out.println("Tai khoan da ton tai");
                  return null;
              }
          }
          User newUser = new User(username, password);
          users.add(newUser);
            System.out.println("Dang ky thanh cong");
            return newUser;
        }

        @Override
        public User logIn(String username, String password) {
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return user;
                }
            }
            return null;
        }
    };
    private static boolean isRunning = true;

    public static void main(String[] args) {
        while (isRunning) {
            showMenu();

        }
    }


    public static void onLogin() {
        System.out.println("Nhap tai khoan dang nhap: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Nhap mat khau dang nhap: ");
        String password = scanner.nextLine();
        User user = authService.logIn(username, password);

        if (user != null) {
            System.out.println("Dang nhap thanh cong! Xin chao, " + user.getUsername());
        } else {
            System.out.println("Dang nhap that bai! Tai khoan hoac mat khau khong dung.");
        }
    }
    public static void onSignUp() {
        System.out.println("Nhap tai khoan: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        User user = authService.signUp(username, password);
    }
    public static void onExit() {
        isRunning = false;
    }
    public static void handleMenu(int choice) {
        switch (choice) {
            case 1:
                onLogin();
                break;
            case 2:
                onSignUp();
                break;
            case 3:
                onExit();
                break;
            default:
                System.out.println("Invalid choice!");
                showMenu();
        }
    }
    public static void showMenu() {
        System.out.println("Day la To-Do List Application");
        System.out.println("1. Dang nhap ");
        System.out.println("2. Dang ky ");
        System.out.println("3. Exit");
        System.out.println("Moi nhap so de lua chon ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        handleMenu(choice);
    }

}