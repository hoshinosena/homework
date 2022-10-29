import java.util.Scanner;

public class hanoi {
    public static void main(String arg[]) {
        int n;
        while (true) {
            System.out.print("请输入圆盘数量n（0退出）:");
            n = new Scanner(System.in).nextInt();
            if (n == 0)
                return;
            new hanoiStack().hanoi(n, 'X', 'Y', 'Z');
        }
    }
}
