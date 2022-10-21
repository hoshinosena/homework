import java.util.Scanner;

public class Express {
    public static boolean isMatch(String str) {
        int i = 0;
        char ch;
        StackClass<Character> Match = new StackClass<>();
        while (i < str.length()) {
            ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
                Match.push(ch);
            else if (ch == ')')
                if (Match.empty() || Match.peek() != '(')
                    return false;
                else
                    Match.pop();
            else if (ch == ']')
                if (Match.empty() || Match.peek() != '[')
                    return false;
                else
                    Match.pop();
            else if (ch == '}')
                if (Match.empty() || Match.peek() != '{')
                    return false;
                else
                    Match.pop();
            i++;
        }
        return Match.empty();
    }
    public static void main(String[] args) {
        String str;
        do {
            System.out.println("请输入算数表达式:");
            Scanner reader = new Scanner(System.in);
            str = reader.nextLine();
        } while (!isMatch(str));
        ExpressClass temp = new ExpressClass();
        System.out.println("后缀表达式:" + temp.getPostexp(str));
        System.out.println("求值结果:" + temp.getValue(temp.getPostexp(str)));
    }
}
