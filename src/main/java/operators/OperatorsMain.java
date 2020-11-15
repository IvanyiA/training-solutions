package operators;

public class OperatorsMain {
    public static void main(String[] args) {
        Operators operators = new Operators();
        System.out.println(operators.isEven(1));
        System.out.println(operators.isEven(2));

        System.out.println(operators.multiplyByPowerOfTwo(16, 2));
        System.out.println(operators.multiplyByPowerOfTwo(13, 2));

        System.out.println(Integer.toBinaryString(100));

        System.out.println(16 >> 1);
        System.out.println(16 << 1);
        System.out.println(13 >> 1);
        System.out.println(13 << 1);

        System.out.println(operators.multiplyByPowerOfTwo(3,5));

        System.out.println(0333);
    }
}
