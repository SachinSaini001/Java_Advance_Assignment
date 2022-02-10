import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.*;

public class Question4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int studentID, credHrs = 0, recordLength = 0;
        String name, lastName, IDString = "", credString = "", fullEntry, selection;
        boolean b, done = false;

        String delimiter = ",";
        StringBuilder nameFormat;
        DecimalFormat ID = new DecimalFormat("0000000");
        DecimalFormat creeds = new DecimalFormat("000");
        Path lower, upper;

        lower = Paths.get("LowerClassmen.txt");
        upper = Paths.get("UpperClassmen.txt");

        try {
            OutputStream lowStr = new BufferedOutputStream(Files.newOutputStream(lower, CREATE, WRITE));
            BufferedWriter writeLower = new BufferedWriter(new OutputStreamWriter(lowStr));

            OutputStream upStr = new BufferedOutputStream(Files.newOutputStream(upper, CREATE, WRITE));
            BufferedWriter writeUpper = new BufferedWriter(new OutputStreamWriter(upStr));

            do {
                b = false;
                do {
                    System.out.print("Enter the student's 7-digit ID number > ");
                    try {
                        studentID = input.nextInt();
                        input.nextLine();

                        if (studentID < 0 || studentID > 9999999)
                            throw (new Exception());
                        else {
                            b = true;
                            IDString = ID.format(studentID) + "";
                        }
                    } catch (Exception error) {
                        System.out.println("That's not a valid ID.");
                        input.nextLine();
                    }
                } while (!b);//takes student ID number

                System.out.print("Please enter the student's first name > ");
                name = input.nextLine();
                nameFormat = new StringBuilder(name);
                nameFormat.setLength(10);
                name = nameFormat.toString();

                System.out.print("Enter the student's last name > ");
                lastName = input.nextLine();
                nameFormat = new StringBuilder(lastName);
                nameFormat.setLength(10);
                lastName = nameFormat.toString();

                b = false;
                do {
                    System.out.print("Enter the student's total earned credits > ");
                    try {
                        credHrs = input.nextInt();
                        input.nextLine();

                        if (credHrs < 0 || credHrs > 999)
                            throw (new Exception());
                        else {
                            b = true;
                            credString = creeds.format(credHrs) + "";
                        }
                    } catch (Exception error) {
                        System.out.println("That's not a valid number of hours.");
                    }
                } while (!b);//takes credit hours

                fullEntry = "ID " + IDString + delimiter + lastName + delimiter + name + delimiter +
                        credString + " credits" + System.getProperty("line.separator");

                if (recordLength == 0)
                    recordLength = fullEntry.length();//sets standard record length

                if (credHrs < 60) {
                    System.out.println("This student's credit hours sorts them with the " +
                            "lowerClassmen.");
                    writeLower.write(fullEntry, 0, fullEntry.length());
                } else {
                    System.out.println("This student's credit hours sorts them with the " +
                            "upperclassmen.");
                    writeUpper.write(fullEntry, 0, fullEntry.length());
                }

                b = false;
                do {
                    System.out.print("Would you like to enter another student? (Y/N) > ");
                    selection = input.nextLine().charAt(0) + "";

                    if (selection.equalsIgnoreCase("Y"))
                        b = true;
                    else if (selection.equalsIgnoreCase("N")) {
                        done = true;
                        b = true;
                    }
                } while (!b);
            } while (!done);

            writeLower.close();
            writeUpper.close();

            System.out.println("\nThe records have been stored.");
        } catch (Exception error) {
            System.out.println("Error: " + error.getMessage());
        }

        String[] array;
        String data;
        int credit;
        StringBuilder extract;
        final int GRAD_CREDITS = 120;

        try {
            InputStream lowIn = new BufferedInputStream(Files.newInputStream(lower,
                    READ));
            BufferedReader readLower = new BufferedReader(new InputStreamReader(lowIn));

            InputStream uppIn = new BufferedInputStream(Files.newInputStream(upper,
                    READ));
            BufferedReader readUpper = new BufferedReader(new InputStreamReader(uppIn));

            System.out.println("LowerClassman records:");
            data = readLower.readLine();
            while (data != null) {
                array = data.split(delimiter);
                extract = new StringBuilder(array[3]);
                extract.setLength(3);
                credit = Integer.parseInt(extract.toString());

                System.out.println(array[0] + delimiter + " Name " + array[1] + delimiter + " " +
                        array[2] + delimiter + " " + array[3] + delimiter + " " + (GRAD_CREDITS - credit) +
                        " credit hours remain for graduation eligibility.");

                data = readLower.readLine();
            }
            System.out.println();

            System.out.println("Upperclassman records:");
            data = readUpper.readLine();
            while (data != null) {
                array = data.split(delimiter);
                extract = new StringBuilder(array[3]);
                extract.setLength(3);
                credit = Integer.parseInt(extract.toString());

                System.out.println(array[0] + delimiter + " Name " + array[1] + delimiter + " " +
                        array[2] + delimiter + " " + array[3] + delimiter + " " + (GRAD_CREDITS - credit) +
                        " credit hours remain for graduation eligibility.");

                data = readUpper.readLine();
            }

            readLower.close();
            readUpper.close();

            System.out.println("\nAll stored records have been displayed.");
        } catch (Exception error) {
            System.out.println("Error: " + error.getMessage());
        }
    }
}