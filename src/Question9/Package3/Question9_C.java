package Question9.Package3;

import Question9.Package2.Question9_B;



public class Question9_C extends Question9_B {
    private final double z;

    public Question9_C(double x, double y, double z){
        super(x,y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "Question9_C{" +
                "z=" + z +
                '}';
    }
}