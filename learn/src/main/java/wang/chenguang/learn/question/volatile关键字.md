# volatile 关键字

## JMM
JMM 就是 Java 内存模型(java memory model)

主内存、线程本地内存

## 特性

### 可见性：

- 写 volatile 修饰的变量时，JMM会把本地内存中值刷新到主内存

- 读 volatile 修饰的变量时，JMM会设置本地内存无效

### 有序性：

要避免指令重排序，synchronized、lock作用的代码块自然是有序执行的，volatile关键字有效的禁止了指令重排序，实现了程序执行的有序性；




