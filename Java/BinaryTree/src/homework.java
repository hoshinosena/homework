import java.util.Scanner;

public class homework {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("由二叉树的括号表示串建立二叉链表bt1...\n输入二叉树的括号表示串:");
        BTreeClass<Character> bt1 = new BTreeClass<>();
        bt1.CreateBTree(reader.nextLine());
        System.out.print("bt1的 非 递归先序遍历序列:");bt1.preOrder();System.out.println();
        System.out.print("bt1的 非 递归中序遍历序列:");bt1.inOrder();System.out.println();
        System.out.print("bt1的 非 递归后序遍历序列:");bt1.postOrder();System.out.println();
        System.out.print("bt1的 非 递归层次遍历序列:");bt1.leverOrder();System.out.println();
        System.out.println("bt1的节点个数:" + bt1.size());System.out.println("bt1的深度:" + bt1.height() + "\n");
        System.out.print("由后序遍历序列和中序遍历序列建立二叉链表bt2...\n输入bt1的后序遍历序列:");
        BTreeClass<Character> bt2 = new BTreeClass<>();
        String str1 = reader.nextLine();System.out.print("输入bt1的中序遍历序列:");String str2 = reader.nextLine();
        bt2.CreateBTree(str1, str2);
        System.out.print("bt2的 非 递归先序遍历序列:");bt2.preOrder();System.out.println();
        System.out.print("bt2的 非 递归层次遍历序列:");bt2.leverOrder();System.out.println();
        System.out.println("bt2的节点个数:" + bt2.size());System.out.println("bt1的深度:" + bt2.height() + "\n");
    }
}
