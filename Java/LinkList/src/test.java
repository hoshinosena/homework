import java.util.LinkedList;
import java.util.Scanner;

public class test {
    public static void main(String args[]){
        Integer[] test = {1,2,3,4,5,6,7,8,9,10};
        LinkListClass<Integer> array = new LinkListClass<>();
        array.CreateListR(test);
        for(int i=0; i<array.size; i++)
            System.out.print(i + ":" + array.getElem(i) + " ");
        System.out.println();
        array.insert(666, 10);
        for(int i=0; i<array.size; i++)
            System.out.print(i + ":" + array.getElem(i) + " ");
        System.out.println();
        array.insert(777, 0);
        for(int i=0; i<array.size; i++)
            System.out.print(i + ":" + array.getElem(i) + " ");
        System.out.println();
        array.insert(888, 7);
        for(int i=0; i<array.size; i++)
            System.out.print(i + ":" + array.getElem(i) + " ");
        System.out.println();
        System.out.print(array.head.data + " " + array.tail.data);
        System.out.println(" " + array.size);
        System.out.println(array.toString());
        array.setSize(9);
        System.out.println(" " + array.size);
        System.out.println(array.toString());
        array.delete(4);
        System.out.println(" " + array.size);
        System.out.println(array.toString());
        System.out.print(array.head.data + " " + array.tail.data);
        /*for(int i=0; i<test.length; i++)
            array.Add(test[i]);
        array.Swap(1, 2);
        for(int i=0; i<array.size; i++)
            System.out.print(i + ":" + array.GetElem(i) + " ");*/


        /*for(int i=0; i<array.size; i++)
            System.out.print(i + ":" + array.GetElem(i) + " ");
        System.out.println();
        array.CreateListR(test);
        for(int i=0; i<array.size; i++)
            System.out.print(i + ":" + array.GetElem(i) + " ");
        System.out.println();
        array.Add(666);
        System.out.println(array.tail.data);
        array.Swap(0, 9);
        for(int i=0; i<array.size; i++)
            System.out.print(i + ":" + array.GetElem(i) + " ");*/
    }
}
