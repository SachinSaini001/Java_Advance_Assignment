import java.io.*;

public class Question5 {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/knoldus/Desktop/Java_Advance_Assignment/src/lear.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int words = 0, lines = 0, characters = 0;
        String str;
        while ((str = br.readLine()) != null) {
            characters = characters + str.length();
            String[] word = str.split("\\s");
            words = words + word.length;
            lines++;
        }
        System.out.println("Total Lines = " + lines + "\n" + "Total words = " + words + "\n" + "Total characters = " + characters);
    }
}