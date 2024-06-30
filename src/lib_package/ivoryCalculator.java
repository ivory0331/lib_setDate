package lib_package;

public class ivoryCalculator {

    int result = 0;

    public int Calculator(int one, int two, String cal) {

        if (cal.equals("+")) {
           result = one + two;
        }
        else if (cal.equals("-")) {
            result = one - two;
        }
        else if (cal.equals("*")) {
            result = one * two;
        }
        else if (cal.equals("/")) {
            result = one/two;
        }

        return result;
    }

    public void print(String text) {
        System.out.println(text);
    }
}
