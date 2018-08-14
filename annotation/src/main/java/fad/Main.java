package fad;

class SimpleCalculator {

    @Deprecated
    public int add(int x, int y) {
        return x+y;
    }
}

class MultiplCalculator extends SimpleCalculator {
    // 重写SimpleCalculator中方法,但不使用@Deprecated
    @Override
    public int add(int x, int y) {
        return  Math.abs(x)+Math.abs(y);
    }
}

//test code
public class Main {

    public static void main(String[] args) {
        new SimpleCalculator().add(3, 4);
        new MultiplCalculator().add(3,5);
    }
}