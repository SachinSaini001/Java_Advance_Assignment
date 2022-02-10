import java.util.ArrayList;
import java.util.Scanner;

class Dish {
     private final int dishID;
     private String dishName;
     private String time;

     public Dish(int dishID,String dishName,String time) {
         this.dishID=dishID;
         this.dishName=dishName;
         this.time=time;
     }

     public int getDishID() {
         return dishID;
     }

    public String getDishName() {
         return dishName;
     }

     public void setDishName(String dishName) {
         this.dishName = dishName;
     }

     public String getTime() {
         return time;
     }

     public void setTime(String time) {
         this.time = time;
     }

     @Override
     public String toString() {
         return "Dish{" +
                 "dishID=" + dishID +
                 ", dishName='" + dishName + '\'' +
                 ", time='" + time + '\'' +
                 '}';
     }
 }

 class Menu {
     static ArrayList<Dish> MenuList = new ArrayList<>();
     static {
         MenuList.add(new Dish(1,"Tea","$20.00"));
         MenuList.add(new Dish(2,"Coffee","$50.00"));
         MenuList.add(new Dish(3,"Pizza","$200.00"));
         MenuList.add(new Dish(4,"Pasta","$60.00"));
     }
 }

public class Question1 {
    public static void main(String[] args) {
        System.out.println("Press 1 to display menu");
        System.out.println("Press 2 to Search Dish");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println();
        if( n == 1){
            int i = 1;
            for (Dish dish: Menu.MenuList){
                System.out.println("Dish -->> " + i + " " + dish.getDishName());
                i++;
            }
        }
        else if ( n == 2 ){
            System.out.println("Enter the Dish ID : ");
            int checkId = scanner.nextInt();
            System.out.println();
            for (Dish dish: Menu.MenuList){
                if( checkId == dish.getDishID()){
                    System.out.println("Dish Id -- " + dish.getDishID());
                    System.out.println("Dish Name -- " + dish.getDishName());
                    System.out.println("Time -- " + dish.getTime());
                    break;
                }
            }
        }

        else
            System.out.println("Please enter correct option");
    }
}
