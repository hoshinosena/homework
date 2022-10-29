等效递归的栈的汉诺塔问题解法
=====================
**<h3><p align="center">栈でハノイの塔の一番解法を狙い!!</p></h3>**

### 递归解法
```
public class hanoiClass {
    private static int i = 0;
    public static void hanoi(int n, char a, char b, char c) {
        if (n == 1)
            System.out.println("(第" + ++i + "次移动)" + n + "号盘:" + a + "-->" + c);
        else {
            hanoi(n - 1, a, c, b); //一重递归
            System.out.println("(第" + ++i + "次移动)" + n + "号盘:" + a + "-->" + c);
            hanoi(n - 1, b, a, c); //二重递归
        }
    }
}
```
经典的递归解法，通俗易懂不必多说

### 非递归解法
仅仅透过递归使用12行代码完成这个作业显然是不能满足我的。由于递归实际上利用了栈来保存调用过程的信息，自然我们也能够直接使用栈来实现汉诺塔问题的求解  
为此，我们需要参照递归解法来实现（省略System.out.println()相关的描述）：
- （步骤1）将1~n所有的状态按照逆序进栈（此时为一重递归调用）
- （步骤2）当一重递归调用执行完毕后将其出栈（n=1时直接出栈），并再次入栈（此时为二重递归调用）
- （步骤3）当二重递归调用执行完毕后，需要先检查上一级调用是否为二重递归调用。循环检查直到栈空或上一级递归调用为一重递归调用，然后将在此之后的所有二级递归调用出栈
- （步骤4）携带出栈后步骤3中的状态信息返回步骤1直到栈空
  
实现以上逻辑相当于使用了递归，不同的是我们扒去了递归这层皮并直接触及了递归的本质  

![图片寄辣!!](https://github.com/hoshinosena/homework/blob/main/img/supechan.png)
> 私日本一ウマ娘になります（✕）
> 
> 私日本一美味しく食べるウマ娘になります（大正解）