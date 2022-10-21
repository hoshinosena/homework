使用Java重写的栈类StackClass和经过优化的表达式类ExpressClass
=====================
### StackClass的改进
- StackClass包含类__顺序表栈__SqStackClass，其中updatacapacity()方法由private类型更改为public类型，使得栈不仅仅支援自动扩容也允许手动指定栈的大小，同时移除了自动减容的功能（机器并不能预测实际需要的容量，频繁扩容减容是在浪费CPU时间，__建议手动使用updatacapacity()方法减容__）
- StackClass包含__链表栈__LinkStackClass
- SqStackClass和LinkStackClass在原有的empty()、push()、pop()和peek()的基础上，添加了size()、search()和contains()方法，与Java原生Stack栈相容
- StackClass继承自LinkStackClass，可以直接利用StackClass声明对象（对于栈这种数据结构显然采用链表会比顺序表性能要好）

### ExpressClass的改进与特性
 - ####改进
- 重写了整个ExpressClass的代码
- 减少了成员变量以降低内存占用
- 优化了运行逻辑以提高性能
 - ####特性
- 科学计算支援
-^和!算符
-三角函数（采用弧度制），sin(x)，cos(x)，tan(x)
-对数函数，ln(x)，log(x)
-例：__(sin(3!)-ln(5*(2^3-7)))__
- 支援负数和小数（包括裸露的'+'和'-'）
-例：__(-7+sin(-3)-ln(5.2*(2^3-7))+(+3.1))__
- 支援不影响表达式的省略（包括()的省略，小数点前0的省略）
-例：__-.7+sin(-3)-ln(.2*(2^3-7))+(+3.1)__
- 支援添加空格提高表达式可读性（允许部分添加空格）
-例：__-.7+tan(1 \* 2 / 3 ^ 4 ) + sin(-3)-ln(.2*( 2^3-7) ) +3.1__
- 支援嵌套函数
-例：__ln(-.7 + 2 * sin(cos(tan(3+sin(sin(1+2)*2)*6)) - 5))__
- 支援数学错误报告
-例：__ln(0)__ 将抛出“数学错误:函数域错误”
-例：__5 / 0__ 将抛出“数学错误:未定义“
-例：__0^0__ 将抛出“数学错误:未定义或1”

![图片寄辣!!](https://github.com/hoshinosena/homework/blob/main/img/himenosena.png)
> 姫野星奏は我が嫁!!