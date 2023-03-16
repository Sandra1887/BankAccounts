import java.util.Scanner;

public class Menu {
    public static void showMainMenu(){
        System.out.println("1. Create a bank account");
        System.out.println("2. Find account");
        System.out.println("3. Make a deposit");
        System.out.println("4. Make a withdrawal");
        System.out.println("5. Exit");
    }

    public static void showAccountMenu() {
        System.out.println("1. New bank account");
        System.out.println("2. New checking account");
        System.out.println("3. New savings account");
        System.out.println("4. Exit");
    }

    public static int askForNumber(int min, int max) {
        int choice = 0;
        if (choice > min || choice < max) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number between " + min + " and " + max);
            choice = sc.nextInt();
        }
        return choice;
    }
}
