package Question9.Package1;

import Question9.Package2.Question9_B;
import Question9.Package3.Question9_C;

public class Question9_A {
    public static void main(String[] args) {
        Question9_B obj=new Question9_B(2.3,4.5);
        System.out.println(obj.toString());
        System.out.println("Dynamic method dispatch");
        obj=new Question9_C(2.3,4.5,5.6);
        System.out.println(obj.toString());

    }
}