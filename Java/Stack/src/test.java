import java.util.Stack;

public class test {
    public static void main(String[] args) {
        ExpressClass abc = new ExpressClass();
        /*
        System.out.println(Math.sin(3.1));
        System.out.println(abc.getValue("56#20#-4#2#+/"));
        System.out.println(abc.getValue("2#1!#*6#-2#^"));
        System.out.println(abc.getValue("0#7!#3#^2#+5#*-"));
        System.out.println(abc.getValue("e#π#^"));
        System.out.println(abc.getValue("π#e#^"));
        System.out.println(abc.getValue("0#0.5#-"));
         */
        System.out.println(abc.getValue("0#0.8414709848078965#+"));
        System.out.println(abc.getValue(abc.getPostexp("sin(sin(sin(3+sin(sin(1+2)*2)*6)))")));
        System.out.println(abc.getValue(abc.getPostexp("-2+8*7")));
        System.out.println(abc.getValue(abc.getPostexp("3! + ln(7)")));
        System.out.println(abc.getValue(abc.getPostexp("-3! +.752^5- ln(7)*sin(cos(5)) - 666")));
    }
}
