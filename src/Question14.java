import java.util.List;
import java.util.Scanner;
import java.util.Vector;

class InputName {
    private final String firstName;
    private final String lastName;

    public InputName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override

    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';

    }
}

public class Question14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<InputName> name = new Vector<>();
        while (true) {
            System.out.println("To check Press one of the following options");
            System.out.println("4. accept first name and surname");
            System.out.println("5. display total name");
            System.out.println("6. exit");
            System.out.println("Enter the option : ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 4) {
                System.out.print("Enter First Name : ");
                String firstName = sc.nextLine();
                System.out.print("Enter LastName : ");
                String lastName = sc.nextLine();
                InputName tempName = new InputName(firstName, lastName);
                name.add(tempName);

            } else if (choice == 5) {
                if (name.size() == 0) {
                    System.out.println("No names are available.");
                } else {
                    System.out.println("Total name are : ");
                    for (InputName name1 : name) {
                        System.out.println(name1);
                    }
                }
            } else if (choice == 6)
                break;
            else
                System.out.println("Enter correct option." + "\n");
        }
    }
}