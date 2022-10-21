import java.util.Scanner;

public class homework {
    public static void main(String[] args) {
        int num, e;
        LinkListClass<Integer> Link = new LinkListClass<>();
        Scanner reader = new Scanner(System.in);
        System.out.print("长度:");
        Integer[] array = new Integer[reader.nextInt()];
        System.out.print("序列:");
        for (int i=0; i<array.length; i++)
            array[i] = reader.nextInt();
        Link.CreateListF(array);
        System.out.println("头插法:" + Link.toString());
        System.out.print("元素:");
        e = reader.nextInt();
        System.out.print("插入位置:");
        num = reader.nextInt();
        Link.insert(e, num);
        System.out.println("插入完了:" + Link.toString());
        System.out.print("删除位置:");
        Link.delete(reader.nextInt());
        System.out.println("删除完了:" + Link.toString());
        System.out.print("查找位置:");
        num = reader.nextInt();
        if ((-1 < num && num < Link.size)) {
            System.out.println("查找完了:" + Link.getElem(num));
        }
        else {
            System.out.println("位置不存在");
        }
        System.out.print("查找元素:");
        e = reader.nextInt();
        if ((Link.getNo(e) >= 0)) {
            System.out.println("元素首次出现在:" + Link.getNo(e));
        }
        else {
            System.out.println("元素不存在");
        }
        num = Link.getElem(0);
        int temp = 1;
        for (int i=1; i<Link.size; i++) {
            if ((Link.getElem(i) == num))
                temp++;
            else if (num < Link.getElem(i)){
                num = Link.getElem(i);
                temp = 1;
            }
        }
        System.out.println("最大元素:" + num + ",个数:" + temp);
        for(int i=0; i<Link.size; i++)
            for(int j=i+1; j<Link.size; j++)
                if(Link.getElem(i) == Link.getElem(j)) {
                    Link.delete(j);
                    j--;
                }
        System.out.println("删除重复元素完了:" + Link.toString());
        for(int i=0, j=Link.size-1; i<j; i++, j--)
            Link.swap(i, j);
        System.out.println("逆置序列完了:" + Link.toString());
        System.out.print("输入有序列长度:");
        Integer[] array1 = new Integer[reader.nextInt()];
        System.out.print("序列:");
        for (int i=0; i<array1.length; i++)
            array1[i] = reader.nextInt();
        Link.CreateListR(array1);
        System.out.println("有序列:" + Link.toString());
        System.out.print("插入元素:");
        e = reader.nextInt();
        for (num=0; num < Link.size && Link.getElem(num) < e; num++);
        Link.insert(e, num);
        System.out.println("新的有序列:" + Link.toString());
        System.out.print("输入有序列 A 长度:");
        Integer[] array2 = new Integer[reader.nextInt()];
        System.out.print("序列:");
        for (int i=0; i<array2.length; i++)
            array2[i] = reader.nextInt();
        Link.CreateListR(array2);
        System.out.print("输入有序列 B 长度:");
        Integer[] array3 = new Integer[reader.nextInt()];
        System.out.print("序列:");
        for (int i=0; i<array3.length; i++)
            array3[i] = reader.nextInt();
        num = 0;
        for (int i=0; i<array3.length; i++){
            for (; num < Link.size && Link.getElem(num) < array3[i]; num++);
            Link.insert(array3[i], num);
        }
        System.out.print("已合并 A 和 B 为新的有序列 C :" + Link.toString());
    }
}
