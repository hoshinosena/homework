public class ExpressClass {
    public String trans(StringBuilder exp) {
        String postexp = "";
        StackClass<Character> opor = new StackClass<>();
        int i = 0;
        char ch;
        if (exp.charAt(i) == '-' || exp.charAt(i) == '+')
            exp.insert(0, '0');
        while (i < exp.length()) {
            ch = exp.charAt(i);
            if (ch == ' ');
            else if (ch == '(') {
                opor.push(ch);
                while (exp.charAt(++i) == ' ');
                i--;
                if (exp.charAt(++i) == '-' || exp.charAt(i) == '+')
                    exp.insert(i, '0');
                i--;
            }
            else if (ch == ')') {
                while (opor.peek() != '(')
                    postexp += opor.pop();
                opor.pop();
            }
            else if (ch == '+' || ch == '-') {
                while (!opor.empty() && opor.peek() != '(')
                    postexp += opor.pop();
                opor.push(ch);
            }
            else if (ch == '*' || ch == '/') {
                while (!opor.empty() && opor.peek() != '(' && opor.peek() != '+' && opor.peek() != '-')
                    postexp += opor.pop();
                opor.push(ch);
            }
            else if (ch == '^')
                if (!opor.empty() && opor.peek() == '^')
                    postexp += ch;
                else
                    opor.push(ch);
            else if (ch == '.' || '0' <= ch && ch <= '9') {
                while (ch == '.' || ch == '!' || ch == 'E' || '0' <= ch && ch <= '9') {
                    postexp += ch;
                    if (ch == 'E') {
                        ch = exp.charAt(++i);
                        if (ch == '+' || ch == '-')
                            postexp += ch;
                        else
                            ch = exp.charAt(--i);
                    }
                    if (exp.length() == ++i)
                        break;
                    ch = exp.charAt(i);
                }
                i--;
                postexp += '#';
            }
            else {
                String str = "";
                while (ch != '(' && ch != '+' && ch != '-' && ch != '*' && ch != '/' && ch != '^') {
                    str += ch;
                    if (exp.length() == ++i)
                        break;
                    ch = exp.charAt(i);
                }
                if (str.equals("e") || str.equals("π")) {
                    postexp += str + '#';
                    i--;
                }
                else if (str.equals("exp") || str.equals("log") || str.equals("ln") ||str.equals("sin") ||
                         str.equals("cos") || str.equals("tan")) {
                    String str1 = "";
                    double temp;
                    StackClass<Character> Match = new StackClass<>();
                    while (!Match.empty() || str1.equals("")) {
                        if (ch == '(')
                            Match.push(ch);
                        else if (ch == ')')
                            Match.pop();
                        str1 += ch;
                        if (exp.length() == ++i)
                            break;
                        ch = exp.charAt(i);
                    }
                    if (str.equals("exp"))
                        temp = Math.exp(getValue(getPostexp(str1)));
                    else if (str.equals("log"))
                        temp = Math.log(getValue(getPostexp(str1)));
                    else if (str.equals("ln"))
                        temp = Math.log(getValue(getPostexp(str1))) / Math.log(2.7182818284);
                    else if (str.equals("sin"))
                        temp = Math.sin(getValue(getPostexp(str1)));
                    else if (str.equals("cos"))
                        temp = Math.cos(getValue(getPostexp(str1)));
                    else
                        temp = Math.tan(getValue(getPostexp(str1)));
                    if (Double.isNaN(temp))
                        throw new ArithmeticException("数学错误:函数域错误");
                    else if (Double.isInfinite(temp))
                        throw new ArithmeticException("数学错误:未定义");
                    postexp += "0#" + Math.abs(temp) + "#" + (temp < 0 ? "-" : "+");
                    i--;
                }
                else
                    throw new UnsupportedOperationException("操作错误:不支援的函数");
            }
            i++;
        }
        while (!opor.empty())
            postexp += opor.pop();
        return postexp;
    }
    public double getValue(String postexp) {
        StackClass<Double> opand = new StackClass<>();
        double a, b, c, e;
        int i = 0, d;
        char ch;
        while (i < postexp.length()) {
            ch = postexp.charAt(i);
            if (ch == '.' || '0' <= ch && ch <= '9') {
                d = 0;
                e = 0;
                while ('0' <= ch && ch <= '9') {
                    d = d * 10 + (ch - '0');
                    ch = postexp.charAt(++i);
                }
                if (ch == '!') {
                    if (d == 0 || d == 1)
                        d = 1;
                    else if (12 < d)
                        throw new ArithmeticException("数学错误:结果溢出");
                    else {
                        int j = 2, k = 1;
                        for (; j <= d; k *= j, j++);
                        d = k;
                    }
                    i++;
                }
                else if (ch == '.') {
                    ch = postexp.charAt(++i);
                    StackClass<Integer> inversion = new StackClass<>();
                    while ('0' <= ch && ch <= '9') {
                        inversion.push(ch - '0');
                        ch = postexp.charAt(++i);
                    }
                    while (!inversion.empty())
                        e = (e + inversion.pop()) / 10;
                }
                e += d;
                d = 0;
                if (ch == 'E') {
                    double E = 10;
                    ch = postexp.charAt(++i);
                    if (ch == '+')
                        ch = postexp.charAt(++i);
                    else if (ch == '-') {
                        E = 0.1;
                        ch = postexp.charAt(++i);
                    }
                    while ('0' <= ch && ch <= '9') {
                        d = d * 10 + (ch - '0');
                        ch = postexp.charAt(++i);
                    }
                    e *= Math.pow(E, d);
                }
                opand.push(e);
            }
            else if (ch == 'e' || ch == 'π') {
                opand.push(ch == 'e' ? 2.7182818284 : 3.1415926535);
                i++;
            }
            else {
                a = opand.pop();
                b = opand.pop();
                switch (ch) {
                    case '+':
                        c = b + a; break;
                    case '-':
                        c = b - a; break;
                    case '*':
                        c = b * a; break;
                    case '/':
                        if (a == 0.0)
                            throw new ArithmeticException("数学错误:未定义");
                        c = b / a; break;
                    default:
                        c = Math.pow(b, a);
                        if (a == 0 && b == 0)
                            throw new ArithmeticException("数学错误:未定义或1");
                        else if (Double.isNaN(c))
                            throw new ArithmeticException("数学错误:未定义");
                }
                opand.push(c);
            }
            i++;
        }
        return opand.pop();
    }
    public String getPostexp(String str) {
        return trans(new StringBuilder().append(str));
    }
}
