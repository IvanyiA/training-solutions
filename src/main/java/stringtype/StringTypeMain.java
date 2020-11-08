package stringtype;

public class StringTypeMain {
    public static void main(String[] args) {
        String prefix = "Hello ";
        String name = "John Doe";
        String message = prefix + prefix;
        message = message + 444;
        boolean b = message.equals("Hello John Doe");
        boolean c = message.equals("Hello John Doe444");
        String ures = "" + "";
        System.out.println(ures.length());

        String s = "Abcde";
        System.out.println(s.length());
        System.out.println(s.charAt(0) + ", " + s.charAt(2));
        System.out.println(s.substring(0,3));
    }
}
