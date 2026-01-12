public class Practice1 {
    public static void poorlyFormattedCalculator() {
        int a=10,b=5,c;
        c=a+b;
        System.out.println("Sum is "+c);
        c=a-b;
        System.out.println("Difference is "+c);
        c=a*b;
        System.out.println("Product is "+c);
        c=a/b;
        System.out.println("Quotient is "+c);
    }
    public static void refactoredCalculator() {
        int firstNo = 10;
        int secondNo = 5;
        int sum = firstNo + secondNo;
        System.out.println("Sum is " + sum);
        int d = firstNo - secondNo;
        System.out.println("Difference is " + d);
        int p = firstNo * secondNo;
        System.out.println("Product is " + p);
        int q = firstNo / secondNo;
        System.out.println("Quotient is " + q);
    }
    public static void main(String[] args) {
        System.out.println("Value of first number: 10");
        System.out.println("Value of second number: 5");
        System.out.println("\nRunning refactored version:");
        System.out.println("Running poorly formatted version:");
        poorlyFormattedCalculator();
        System.out.println("\nRunning refactored version:");
        refactoredCalculator();
    }
}
