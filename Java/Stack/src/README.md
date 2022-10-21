使用Java重写的栈类StackClass和经过优化的表达式类ExpressClass
=====================
### StackClass的改进
- StackClass包含类**顺序表栈**SqStackClass，其中updatacapacity()方法由private类型更改为public类型，使得栈不仅仅支援自动扩容也允许手动指定栈的大小，同时移除了自动减容的功能（机器并不能预测实际需要的容量，频繁扩容减容是在浪费CPU时间，**建议手动使用updatacapacity()方法减容**）
- StackClass包含**链表栈**LinkStackClass
- SqStackClass和LinkStackClass在原有的empty()、push()、pop()和peek()的基础上，添加了size()、search()和contains()方法，与Java原生Stack栈相容
- StackClass继承自LinkStackClass，可以直接利用StackClass声明对象（对于栈这种数据结构显然采用链表会比顺序表性能要好）

### ExpressClass的改进与特性
#### 改进
- 重写了整个ExpressClass的代码
- 减少了成员变量以降低内存占用
- 优化了运行逻辑以提高性能
#### 特性
- 支援科学计算
    - 科学计数法（E+，E-）
    - ^和!算符
    - 三角函数（采用弧度制），sin(x)，cos(x)，tan(x)
    - 对数函数，ln(x)，log(x)
    - >例：**(sin(3!-2E+5)-ln(5E-1\*(2^3-7)))**
- 支援负数和小数（包括裸露的+和-）
    - >例：**(-0.7+3E-2+sin(-3!)-ln(0.2\*(2^3-7))+(+3.1E+2))**
- 支援不影响表达式的省略（包括()的省略，小数点前0的省略，科学计数法E+中+的省略）
    - >例：**-.7+3E-2+sin(-3!)-ln(.2\*(2^3-7))+(+3.1E2)**
- 支援添加空格提高表达式可读性（允许部分添加空格）
    - >例：**-.7+&nbsp;&nbsp;3E-2&nbsp;+&nbsp;sin(&nbsp;-3!&nbsp;)&nbsp;-&nbsp;ln(&nbsp;&nbsp;.2\*(2^3-7))&nbsp;+&nbsp;(&nbsp;&nbsp;+3.1E2)**
- 支援嵌套函数
    - >例：**ln(-.7 + 2 \* sin(cos(tan(3+sin(sin(1+2)\*2)\*6))) + 5^exp(ln(ln(ln(10))+5)-(-3)))**
- 支援数学错误提示
    - >例：**ln(0)** 将抛出异常“数学错误:函数域错误”
    - >例：**5 / 0** 将抛出异常“数学错误:未定义”
    - >例：**0^0**   将抛出异常“数学错误:未定义或1”（**此时可以考虑用1替换0^0**）
    - >例：**100!**  将抛出异常“数学错误:结果溢出”

![图片寄辣!!](https://github.com/hoshinosena/homework/blob/main/img/himenosena.png)
> 姫野星奏は我が嫁!!