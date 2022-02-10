import java.util.HashMap;
import java.util.Scanner;

public class Question2 {
    static private final HashMap<String, String> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Press 1 to Add new phone book entry");
            System.out.println("Press 2 to Search a Phone Number");
            System.out.println("Press 3 to Quit.");
            int flag = sc.nextInt();
            if (flag == 1) {
                System.out.println("Enter Name : ");
                String userName = sc.next();
                System.out.println("Enter phone number : ");
                String phoneNum = sc.next();
                if (!phoneBook.containsKey(userName)) {
                    phoneBook.put(userName, phoneNum);
                } else
                    System.out.println("Number already exist");
            } else if (flag == 2) {
                System.out.println("Enter Name in Phone Book to search : ");
                String userName = sc.next();
                if (phoneBook.containsKey(userName)) {
                    System.out.println("Name : " + userName + "Phone Number : " + phoneBook.get(userName));
                }
            } else if (flag == 3)
                break;
        }
    }
}