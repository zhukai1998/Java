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


- 逗号标志增加了分组的分隔符
``` java
System.out.printf("%,.2f", 10000.0 / 3.0);
打印 3,333.33%
```
- 用于 printf 的标志

| 标志 | 目的 | 举例
| :--: | :--: | :--:
| + | 打印正数和负数的符号 | +3333.33
| 空格 | 在正数之前添加空格 | \| 3333.33 \|
| 0 | 数字前补 0 | 003333.33
| - | 左对齐 | \|3333.33 \|
| ( | 将负数括在括号内 | (-3333.33)
| , | 添加分组分隔符 | 3,333.33
| #(对于 f 格式) | 包括小数点 | 3,333.
| #(对于 x 或 0 格式) | 添加前缀 0x 或 0 | 0xcafe
| $ | 给定被格式化的参数索引。例如，%1$d, %1$x 将以十进制和十六进制格式打印第 1 个参数 | 159 9F
| < | 打印同一数值 | 159 9F

- 可以使用静态的 String.format 方法创建一个格式化的字符串，而不打印输出：

```
String message = String.format("Hello, %s, Next year, you'll be %d", name, age);
```
- 可以使用 s 转换格式任意的对象

- 打印日期和时间

``` java
System.out.printf("%tc", new Date());
打印：周五 1月 17 23:09:17 CST 2020%
```

- 日期和时间的转换符

| 转换符 | 类型 | 举例
| :---: | :--: | :--:
| c | 完整的日期和时间 | 周五 1月 17 23:09:17 CST 2020%
| F | ISO 8601 日期 |
| D | 美国格式的日期（月/日/年）|
| T | 24 小时时间 |

P60



