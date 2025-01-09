package grammar;

public class StringDemo {

    public static void main(String[] args) {
        String a1 = "abc";
        String b1 = "abc";
        // 输出 ture
        System.out.println("==: " + (a1 == b1));

        String a2 = "abc";
        String b2 = new String("abc");
        // 输出 false
        System.out.println("==: " + (a2 == b2));


    }

}