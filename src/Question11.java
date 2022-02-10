class Question11 {
    void outerMethod() {
        System.out.println("Inside outerMethod");
// Inner class is local to outerMethod()
        class Inner {
            void innerMethod() {
                System.out.println("Inside innerMethod");
            }
        }
        Inner y = new Inner();
        y.innerMethod();
    }
}

class Test1 {
    public static void main(String[] args) {
        Question11 x = new Question11();
        x.outerMethod();
    }
}
/*
output
Inside outerMethod
Inside innerMethod
*/