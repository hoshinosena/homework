package pers.hoshinosena.base.Stack;

class SqStackClass<E> {
    private final int initcapacity = 10;
    private int capacity;
    private E[] data;
    private int top;
    public SqStackClass(){
        data = (E[])new Object[initcapacity];
        capacity = initcapacity;
        top = -1;
    }
    public void updatacapacity(int newcapacity) { //public方法允许手动控制栈的容量，支援自动扩容不支援自动减容
        if (newcapacity < 10)
            throw new IllegalArgumentException("操作非法:不支援的容量");
        E[] newdata = (E[])new Object[newcapacity];
        for(int i=0; i<capacity && i<newcapacity; i++)
            newdata[i] = data[i];
        capacity = newcapacity;
        data = newdata;
        top = newcapacity < top+1 ? newcapacity-1 : top;
    }
    public boolean empty() {
        return top == -1;
    }
    public int size() {
        return top + 1;
    }
    public void push(E item) {
        if (top == capacity-1) //自动扩容
            updatacapacity(capacity << 1);
        data[++top] = item;
    }
    public E pop() { //支援使用updatacapacity()方法 手动 减容
        if (empty())
            throw new IllegalArgumentException("操作错误:空栈");
        return (E)data[top--];
    }
    public E peek() {
        if (empty())
            throw new IllegalArgumentException("操作错误:空栈");
        return (E)data[top];
    }
    int search(E item) {
        int temp = 1;
        for (int i=top; -1<i; i--, temp++)
            if (item == (E)data[i])
                return temp;
        return -1;
    }
    boolean contains(E item) {
        for (int i=top; -1<top; top--)
            if (item == (E)data[i])
                return true;
        return false;
    }
}

class LinkNode<E> {
    E data;
    LinkNode<E> next;
    public LinkNode(){
        next = null;
    }
    public LinkNode(E item){
        data = item;
    }
}

class LinkStackClass<E> {
    private LinkNode<E> head;
    private int size;
    public LinkStackClass() {
        head = new LinkNode<E>();
        size = 0;
    }
    public boolean empty() {
        return head.next == null;
    }
    public int size() {
        return size;
    }
    public void push(E item) {
        LinkNode<E> temp = new LinkNode<>(item);
        temp.next = head.next;
        head.next = temp;
        size++;
    }
    public E pop() {
        if (empty())
            throw new IllegalArgumentException("操作错误:空栈");
        E temp = head.next.data;
        head.next = head.next.next;
        size--;
        return temp;
    }
    public E peek() {
        if (empty())
            throw new IllegalArgumentException("操作错误:空栈");
        return head.next.data;
    }
    int search(E item) {
        int i = 1;
        LinkNode<E> temp = head.next;
        while(temp != null && temp.data != item) {
            temp = temp.next;
            i++;
        }
        return temp == null ? -1 : i;
    }
    boolean contains(E item) {
        LinkNode<E> temp = head.next;
        while(temp != null && temp.data != item)
            temp = temp.next;
        return temp != null;
    }
}

public class StackClass<E> extends LinkStackClass<E> { //通过继承使StackClass默认指向LinkStackClass
}
