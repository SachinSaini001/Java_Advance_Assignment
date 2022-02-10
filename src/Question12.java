import java.io.*;
import java.util.Scanner;

class Employee {
    private final int EmpID;
    private final String EmpName;
    private final int age;

    public Employee(int EmpID, String EmpName, int age) {
        this.EmpID = EmpID;
        this.EmpName = EmpName;
        this.age = age;
    }

    public int getEmpID() {
        return EmpID;
    }

    public String getEmpName() {
        return EmpName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + EmpID +
                ", empName='" + EmpName + '\'' +
                ", age=" + age +
                '}';

    }
}


public class Question12 {
    static Employee[] array;

    static {
        array = new Employee[1];
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/home/knoldus/Desktop/Java_Advance_Assignment/src/Employee.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        System.out.println("Employee Details Currently inside Employee.txt: ");
        while ((str = br.readLine()) != null) {
            String[] varTemp = str.trim().split("\\,");
            Employee emp = new Employee(Integer.parseInt(varTemp[0]), varTemp[1], Integer.parseInt(varTemp[2]));
            array[0] = emp;
        }
        br.close();
        System.out.println(array[0]);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the detail of another employee ");
        System.out.println("Enter the Name : ");
        String name = sc.nextLine();
        System.out.println("Enter the ID : ");
        int id = sc.nextInt();
        System.out.println("Enter the age : ");
        int age = sc.nextInt();
        String text = id + "," + name + "," + age;
        FileWriter fw = new FileWriter(file);
        fw.write(text);
        fw.flush();
        fw.close();
        br = new BufferedReader(new FileReader(file));
        System.out.println("New employee details are : ");
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
    }
}
