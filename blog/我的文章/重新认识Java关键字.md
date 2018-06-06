- ##### 类型

  变量类型

  | 类型    | 位数 | 默认值    |
  | ------- | ---- | --------- |
  | boolean | 1    | false     |
  | byte    | 8    | 0         |
  | char    | 16   | ''\u0000' |
  | short   | 16   | 0         |
  | int     | 32   | 0         |
  | float   | 32   | 0.0       |
  | long    | 64   | 0         |
  | double  | 64   | 0.0       |
  | Object  | --   | null      |

  变量是Java中最重要的组成部分，对于一个变量来说，它的类型表示了它的含义，它的值只有依据它的类型才有了意义，即使是相同的值，如果类型不同，代表的也是不同的值，不同的含义。

  

  特殊的值

  |       |      |                                                              |
  | ----- | ---- | ------------------------------------------------------------ |
  | true  |      |                                                              |
  | false |      |                                                              |
  | null  |      | null是任何引用类型的默认值；自动装箱不会将null转换为基本类型的默认值； instanceof 对于null会报false；即使是null也可以执行类的静态方法，因为静态方法使用静态绑定； |
  | super |      | 子类中指向父类的引用                                         |
  | this  |      | 类中指向自己的引用                                           |

  Java变量中的值究竟是什么，它在计算机中的表示是怎样的，不同的实现方式可能有不同的表示，但是这没有问题，计算机将存储中的表示和程序员看到的表示做了转换，转换的实现方式有不同，但是你可以想象成有一个映射表，将存储的二进制信息转换成各种类型的值，比如true，false，0，0.0，还有Object的引用，就是类似super，this这样的值，将它们归属一类，是因为它们真的可以在内存中找到具体的存储位置。

  

  ------

  

- ##### 控制

  | 控制    |      |
  | ------- | ---- |
  | switch  |      |
  | case    |      |
  | default |      |
  | do      |      |
  | while   |      |
  | for     |      |
  | if      |      |
  | else    |      |

  | 跳跃     |      |
  | -------- | ---- |
  | break    |      |
  | continue |      |
  | return   |      |
  | goto     |      |

- ##### Object对象

  | 类与继承   |      |
  | ---------- | ---- |
  | class      |      |
  | instanceof |      |
  | new        |      |
  | extends    |      |
  | enum       |      |

  | 类与接口   |      |
  | ---------- | ---- |
  | interface  |      |
  | implements |      |

  包相关

  | import  |      |
  | ------- | ---- |
  | package |      |

- ##### 修饰符

  访问修饰符

  | private   |      |
  | --------- | ---- |
  | protected |      |
  | public    |      |

  基础修饰符

  | abstract     |      |
  | ------------ | ---- |
  | final        |      |
  | native       |      |
  | static       |      |
  | strictfp     |      |
  | synchronized |      |
  | transient    |      |
  | volatile     |      |
  | void         |      |
  | default      |      |
  | const        |      |

- 异常处理

  | assert  |      |
  | ------- | ---- |
  | catch   |      |
  | finally |      |
  | throw   |      |
  | throws  |      |
  | try     |      |

  ##### 
