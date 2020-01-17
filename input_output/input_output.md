- 读取输入
``` java
import java.util.Scanner;

Scanner in = new Scanner(System.in);
System.out.println("What's your name?");
String name = in.nextLine();
```
- 使用 nextLine 方法是因为在输入法中可能包括空格，要想读取一个单词（以空格符作为分隔符）就调用
``` java
String firstName = in.next()
```
- 要想读取一个整数，就调用 nextInt 方法
``` java
System.out.println("How old are you?");
int age = in.nextInt();
```
- 因为输入是可见的，所以 Scanner 类不适用于从控制台读取密码。 Java SE 6 引入了 Console 类实现了这个功能，若想读取一个密码，可以采用下列代码：
``` java
Console cons = System.console();
String username = cons.readLine("User name");
char[] passwd = cons.readPassword("Password:");
```
返回的密码存放在一维字符数组中，而不是字符串中。在对密码进行处理后，应该马上用一个填充值覆盖数组元素。采用 Console 对象处理输入不如采用 Scanner 方便。每次只能读取一行输入，而没有能够读取一个单词或一个数值的方法

- 格式化输出
``` java
System.out.printf("%8.2f", x);
```
- 每一个以 % 字符开始的格式说明符都用相应的参数替代，格式说明符尾部的转换符将指示被格式化的数值类型：f 表示浮点数，s 表示字符串，d 表示十进制整数。
<br>
| 转换符 | 类 型 | 举 例 |
| :---: | :---: | :---: |
| d     | 十进制整数      | 59 |
| x     | 十六进制整数    | 9f |
| o     | 八进制整数      | 237|
| f     | 定点浮点数      | 15.9|
| e     | 指数浮点数      |1.50e+01|
| g     | 通用浮点数      |-|
| a     | 十六进制浮点数   |0x1.fccdp3|
| s     | 字符串          |Hello|
| c     | 字符            |H|
| b     | 不二            |True|
| h     | 散列码          |42628b2
| tx/Tx | 日期时间（T 强制大些）|已过时，应该为java.time|
| %     | 百分号              |%|
| n     | 与平台有关的行分隔符  |-|
<br>
- 逗号标志增加了分组的分隔符
``` java
System.out.printf("%,.2f", 10000.0 / 3.0);
打印 3,333.33%
```