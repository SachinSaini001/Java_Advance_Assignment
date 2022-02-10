/*public class Question10
{
    String s = "AAA";

    void methodA()
    {
        System.out.println(s);
    }

    static class B
    {
        void methodB()
        {
            methodA();
        }
    }
}
*/


/*
Output
We can not call non-static method from the static method.
Hence ,the program will give the compileTime error as below:

    java: non-static method methodA() cannot be referenced from a static context
 */