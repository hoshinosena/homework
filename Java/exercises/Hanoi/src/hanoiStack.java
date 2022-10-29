import pers.hoshinosena.base.Stack.StackClass;

class data {
    public int n;
    public char a, b, c;
    public data(int n, char a, char b, char c) {
        this.n = n;
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
public class hanoiStack {
    private int i = 0;
    private StackClass<data> hanoiData = new StackClass<>();
    private StackClass<Boolean> bool = new StackClass<>();
    public hanoiStack() {

    }
    public void hanoi(int n, char a, char b, char c) {  //n盘从a移动到c，b用于保存信息而不必判断得出
        hanoiData.push(new data(n, a, b, c));
        bool.push(true);
        while (!hanoiData.empty()) {
            data temp = new data(hanoiData.peek().n, hanoiData.peek().a, hanoiData.peek().b, hanoiData.peek().c); //需使用深拷贝而不是直接new temp = hanoiData.peek()
            if (hanoiData.peek().n == 1) {
                System.out.println("(第" + ++i + "次移动)" + hanoiData.peek().n + "号盘:" + hanoiData.peek().a + "-->" + hanoiData.peek().c);
                hanoiData.pop();
                bool.pop();
                int j = 0;
                boolean loop = true;
                while (loop && !hanoiData.empty()) {
                    if (bool.peek()) {
                        System.out.println("(第" + ++i + "次移动)" + hanoiData.peek().n + "号盘:" + hanoiData.peek().a + "-->" + hanoiData.peek().c);
                        do {
                            bool.pop();
                            j++;
                        }while(!bool.empty() && !bool.peek());
                        for (; j != 0; j--)
                            bool.push(false);
                        loop = false;
                    }
                    else {
                        hanoiData.pop();
                        bool.pop();
                    }
                }
            }
            else if (bool.peek()) {
                hanoiData.push(new data(--temp.n, temp.a, temp.c, temp.b));
                bool.push(true);
            }
            else {
                hanoiData.push(new data(--temp.n, temp.b, temp.a, temp.c));
                bool.push(true);
                }
        }
    }
}
