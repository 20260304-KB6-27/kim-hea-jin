package basic.ch01.sec12;

public class TypeCasting {
    public static void main(String[] args) {
        String str1 = "10";
        String str2 = "3.14";
        String str3 = "true";

        int value1 = Integer.parseInt(str1);       // String -> int
        double value2 = Double.parseDouble(str2);   // String -> double
        boolean value3 = Boolean.parseBoolean(str3); // String -> boolean

        System.out.println(value1);    // 10
        System.out.println(value2);    // 3.14
        System.out.println(value3);    // true
    }
}
