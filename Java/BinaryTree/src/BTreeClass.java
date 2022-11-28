import bjava.util.Stack.StackClass;
import bjava.util.Tree.BinaryTreeNode;
import bjava.util.Tree.LinkedBinaryTree;


public class BTreeClass<E> extends LinkedBinaryTree<E> {
    public BTreeClass() {

    }
    public void CreateBTree(String str) {
        StackClass<BinaryTreeNode<Character>> st = new StackClass<>();
        BinaryTreeNode<Character> p = null;
        boolean flag = true;
        char ch;
        int i = 0;
        root = null;
        while (i<str.length()) {
            ch = str.charAt(i);
            switch (ch) {
                case '(': st.push(p); flag = true; break;
                case ')': st.pop(); break;
                case ',': flag =false; break;
                default :
                    p = new BinaryTreeNode<Character>(ch);
                    if (root == null)
                        root = (BinaryTreeNode<E>)p;
                    else {
                        if (flag) {
                            if (!st.empty())
                                st.peek().left = p;
                        }
                        else {
                            if (!st.empty())
                                st.peek().right = p;
                        }
                    } break;
            }
            i++;
        }
    }
    public void CreateBTree(String postOrder, String inOrder) {
        String str = "";
        for (int i=0; i<postOrder.length(); i++)
            if (postOrder.charAt(i) != ' ')
                str += postOrder.charAt(i);
        postOrder = str;
        str = "";
        for (int i=0; i<inOrder.length(); i++)
            if (inOrder.charAt(i) != ' ')
                str += inOrder.charAt(i);
        inOrder = str;
        root = (BinaryTreeNode<E>)CreateBTree(postOrder, 0, inOrder, 0, postOrder.length());
    }
    private BinaryTreeNode<Character> CreateBTree(String postOrder, int i, String inOrder, int j, int n) {
        BinaryTreeNode<Character> root;
        int p = j;
        if (n == 0)
            return null;
        char ch = postOrder.charAt(i + n - 1);
        for (; inOrder.charAt(p) != ch; p++);
        root = new BinaryTreeNode<>(ch);
        root.left = CreateBTree(postOrder, i, inOrder, j, p - j);
        root.right = CreateBTree(postOrder, i + p - j, inOrder, p + 1, n - p + j - 1);
        return root;
    }
}