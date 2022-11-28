Java原生类库中未包含的BinaryTree类的实现
=====================
### 上手方法
1. 请先添加libs下的pers.hoshinosena.jar包为依赖
    - pers.hoshinosena.jar包隶属我的项目[base-java（简称bjava）](https://github.com/hoshinosena/base-java)
    - 随着时间推移，pers.hoshinosena.jar包的功能会变得丰富（自述文件可能会失去意义），性能也会更优，你可以在[此处](https://github.com/hoshinosena/base-java/tree/main/main)获取最新的pers.hoshinosena.jar包
2. 像往常一样编译和运行homework.java

### BinaryTree的说明和特性
#### 说明
- BinaryTree类实现了所有二叉树都需要的基本公共方法，并作为类库封装在pers.hoshinosena.jar中
- 如果需要实现具体的二叉树，如二叉查找树、红黑树等，可以通过继承BinaryTree类快速实现
- BinaryTree类实现的BinaryTree接口如下：
```
public interface BinaryTree<E> {
    // 删除树
    public void removeLeftTree();
    public void removeRightTree();
    public void removeAllTree();

    // 判断二叉树是否为空
    public boolean empty();

    // 查找二叉树元素
    // 存在则返回节点，否则抛出异常
    public BinaryTreeNode<E> search(E element);

    // 判断二叉树是否存在元素
    public boolean contains(E element);

    // 返回二叉树节点个数
    public int size();

    // 返回二叉树的深度
    // 当根节点非空从1计数，否则为0
    public int height();

    // 非递归遍历
    // *不* 保证线程安全
    public void preOrder();
    public void inOrder();

    // 非递归遍历
    public void postOrder();
    public void leverOrder();

    // 返回二叉树的括号表示串
    public String toString();
    }
```
#### 特性
- BinaryTreeNode中已经包含了size()和height()方法，故获取到节点对象后不必使其成为树，可直接使用对象中的方法
- BinaryTree中没有任何一个方法是基于递归的，其遍历使用了多种实现：
    - search()方法使用了非递归的先序遍历，contains()方法实际上是基于search()实现的，其时间复杂度为O(n)，空间复杂度为O(log(n))
	- 基于线索二叉树启发，preOrder()和inOrder()方法采用了另一种实现，其时间复杂度为O(n)，空间复杂度为O(1)
	- postOrder()方法是非递归的后续遍历，本质上同search()没有差别，其时间复杂度为O(n)，空间复杂度为O(log(n))
	- 基于层次遍历的输出逻辑采用递归必然慢于列队，因此leverOrder()方法采用列队实现，其时间复杂度为O(n)，空间复杂度为O(n)
	- toString()方法有2个非递归实现，一个比递归的性能高出10%，另一个空间复杂度为前一个的1/2，它们的时间复杂度和空间复杂度都为O(n)和O(log(n))

![图片寄辣!!](https://github.com/hoshinosena/homework/blob/main/img/kawaiiko.png)
> かわいいいいいいいいいいい!!