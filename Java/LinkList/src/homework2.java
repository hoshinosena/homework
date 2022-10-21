import java.util.Scanner;
import java.util.Stack;

/*    利用重写过的单链表类LinkListClass，
      通过手动管理head节点与tail节点的逻辑，
      实现循环链表功能，代码量大幅减少
 */
public class homework2 {
    public static void main(String[] args){
        int child, num;
        LinkListClass<Integer> List = new LinkListClass<>();
        Scanner reader = new Scanner(System.in);
        System.out.print("人数:");
        child = reader.nextInt();
        System.out.print("密码:");
        num = reader.nextInt();
        for (int i=1; i<=child; i++)
            List.add(i);
        System.out.print("出列序列:");
        List.point = List.head;
        List.tail.next = List.head;
        while(0 < List.size){
            for(int i=1; i<num; i++)
                List.point = List.point.next;
            System.out.print(List.point.data + " ");
            List.tail.next = null;
            List.delete(List.getNo(List.point.data));
            List.tail.next = List.head;
            List.point = List.point.next == null ? List.head : List.point.next;
        }
    }
}