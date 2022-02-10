import java.io.*;

public class Question6 {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/knoldus/Desktop/Java_Advance_Assignment/src/MidTermScores.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        int range0to9 = 0, range10to19 = 0, range20to29 = 0, range30to39 = 0, range40to49 = 0, range50to59 = 0,
                range60to69 = 0, range70to79 = 0, range80to89 = 0, range90to99 = 0, range100 = 0;
        while ((str = br.readLine()) != null) {
            int y = Integer.parseInt(str);
            if (y >= 0 && y <= 9)
                range0to9++;
            else if (y >= 10 && y <= 19)
                range10to19++;
            else if (y >= 20 && y <= 29)
                range20to29++;
            else if (y >= 30 && y <= 39)
                range30to39++;
            else if (y >= 40 && y <= 49)
                range40to49++;
            else if (y >= 50 && y <= 59)
                range50to59++;
            else if (y >= 60 && y <= 69)
                range60to69++;
            else if (y >= 70 && y <= 79)
                range70to79++;
            else if (y >= 80 && y <= 89)
                range80to89++;
            else if (y >= 90 && y <= 99)
                range90to99++;
            else if (y == 100)
                range100++;
        }
        System.out.print("00 to 09 : ");
        for (int i = 0; i < range0to9; i++)
            System.out.print("*");
        System.out.println();

        System.out.print("10 to 19 : ");
        for (int i = 0; i < range10to19; i++)
            System.out.print("*");
        System.out.println();

        System.out.print("20 to 29 : ");
        for (int i = 0; i < range20to29; i++)
            System.out.print("*");
        System.out.println();

        System.out.print("30 to 39 : ");
        for (int i = 0; i < range30to39; i++)
            System.out.print("*");
        System.out.println();

        System.out.print("40 to 49 : ");
        for (int i = 0; i < range40to49; i++)
            System.out.print("*");
        System.out.println();

        System.out.print("50 to 59 : ");
        for (int i = 0; i < range50to59; i++)
            System.out.print("*");
        System.out.println();

        System.out.print("60 to 69 : ");
        for (int i = 0; i < range60to69; i++)
            System.out.print("*");
        System.out.println();

        System.out.print("70 to 79 : ");
        for (int i = 0; i < range70to79; i++)
            System.out.print("*");
        System.out.println();

        System.out.print("80 to 89 : ");
        for (int i = 0; i < range80to89; i++)
            System.out.print("*");
        System.out.println();

        System.out.print("90 to 99 : ");
        for (int i = 0; i < range90to99; i++)
            System.out.print("*");
        System.out.println();

        System.out.print("100 : ");
        for (int i = 0; i < range100; i++)
            System.out.print("*");
        System.out.println();

    }
}