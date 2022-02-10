public class Question7 {
    public static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3, 4, 5};
            for (int i = 0; i <= 5; i++) {
                System.out.print("Array elements are : " + arr[i] + "\n");
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
//        catch (ArrayIndexOutOfBoundsException ex) {
//            System.out.println("ArrayIndexOutOfBoundsException : " + ex);
//        }
    }
}

/*
Output
In case multiple try catch block the relationship should be child to parent.
 Here in this example the relationship is parent to child which will create an error
 */
