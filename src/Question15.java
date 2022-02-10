import java.io.File;
import java.util.Date;

public class Question15 {
    public static void main(String[] args) {
        File file = new File("/home/knoldus/Desktop/Java_Advance_Assignment/src/LastModifiedFileTime.txt");
        Date date = new Date(file.lastModified());
        System.out.println("\nThe file was last modified on: " + date + "\n");
    }
}
