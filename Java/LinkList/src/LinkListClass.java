class LinkNode<E> {
    E data;
    LinkNode<E> next;
    public LinkNode() {
        next = null;
    }
    public LinkNode(E element) {
        data = element;
    }
}

public class LinkListClass<E> {
    private final LinkNode<E> first;
    public LinkNode<E> head;
    public LinkNode<E> tail;
    public LinkNode<E> point; //方便直接操纵节点
    public int size;
    public LinkListClass() {
        first = new LinkNode<>();
        head = first;
        tail = head;
        size = 0;
    }
    public void CreateListF(E[] array) {
        LinkNode<E> temp;
        temp = new LinkNode<>(array[0]);
        temp.next = first.next;
        first.next = temp;
        tail = temp; //头插法只需定义一次尾指针，单独拎出写可以省下判断降低复杂度
        for(int i=1; i<array.length; i++) {
            temp = new LinkNode<>(array[i]);
            temp.next = first.next;
            first.next = temp;
        }
        head = first.next;
        size = array.length;
    }
    public void CreateListR(E[] array) {
        LinkNode<E> temp1, temp2;
        temp1 = first;
        for(int i=0; i<array.length; i++) {
            temp2 = new LinkNode<>(array[i]);
            temp1.next = temp2;
            temp1 = temp2;
        }
        head = first.next;
        tail = temp1;
        size = array.length;
    }
    private LinkNode<E> geti(int index) {
        LinkNode<E> temp = first;
        for(int j=-1; j<index; j++)
            temp = temp.next;
        return temp;
    }
    public void add(E element) {
        LinkNode<E> temp1 = new LinkNode<>(element);
        tail.next = temp1;
        tail = temp1;
        head = first.next;
        size++;
    }
    public int size(){
        return size;
    }
    public void setSize(int len) {
        if(len < 0 || size < len)
            throw new IllegalArgumentException("长度非法");
        LinkNode<E> temp = geti(len-1);
        temp.next = null;
        head = first.next;
        tail = temp;
        size = len;
    }
    public E getElem(int index) {
        if (index < 0 || size - 1 < index)
            throw new IllegalArgumentException("元素非法");
        LinkNode<E> temp = geti(index);
        return temp.data;
    }
    public void setElem(E element, int index) {
        if (index < 0 || size - 1 < index)
            throw new IllegalArgumentException("元素非法");
        LinkNode<E> temp = geti(index);
        temp.data = element;
    }
    public int getNo(E element) {
        int i=0;
        LinkNode<E> temp = head;
        while(temp != null && temp.data != element) {
            temp = temp.next;
            i++;
        }
        if(temp == null)
            return -1;
        return i;
    }
    public void swap(int i, int j) {
        LinkNode<E> temp1 = geti(i);
        LinkNode<E> temp2 = geti(j);
        E temp = temp1.data;
        temp1.data = temp2.data;
        temp2.data = temp;
    }
    public void insert(E element, int index) {
        if (index < 0 || size < index)
            throw new IllegalArgumentException("位置非法");
        LinkNode<E> temp1 = new LinkNode<>(element);
        LinkNode<E> temp2 = geti(index-1);
        temp1.next = temp2.next;
        temp2.next = temp1;
        head = first.next;
        if (temp1.next == null)
            tail = temp1;
        size++;
    }
    public void delete(int index) {
        if (index < 0 || size - 1 < index)
            throw new IllegalArgumentException("位置非法");
        LinkNode<E> temp = geti(index-1);
        temp.next = temp.next.next;
        head = first.next;
        if(temp.next == null)
            tail = temp;
        size--;
    }
    public String toString() {
        String ans ="";
        LinkNode<E> temp = head;
        while(temp != null) {
            ans += temp.data + " ";
            temp = temp.next;
        }
        return ans;
    }
}
