Mark



ThreadPoolExectuor

参数：

核心线程

最大线程

空余线程存活时间

阻塞队列

拒绝策略

- 抛异常
- 交还给请求者处理
- 抛弃最早提交的
- 抛弃需要提交的这个



核心线程配置

1. cpu密集型：cpu核数+1

2. IO密集型：

   - cpu核数*2

   - cpu核数   /（1-阻塞系数）

     阻塞系数一般在0.8-0.9



JVM GC

GC Roots 的对象

- 虚拟机栈中引用的对象，栈桢中的局部变量区
- 方法区中的类静态属性引用的对象
- 方法区中常量引用的对象
- 本地方法栈中JNI引用的对象



JVM参数 类型

-  标配参数

- x参数 

  -Xint 解释执行，-Xcomp编译执行，-Xmixed混合模式

- xx参数   （重要）

  - 布尔类型 

    ```
    -XX:+或者-某个属性值
    +表示开启
    -表示关闭
    
    case：
    是否打印GC垃圾收集细节
    -XX:-PrintGCDetails
    -XX:+PrintGCDetails
    是否使用串行垃圾回收器
    -XX:-UseSerialGC
    -XX:+UseSerialGC
    
    
    ```

  - KV设值类型

    ```
    -XX:属性key=属性值value
    
    -XX:MetaspaceSize=128m
    
    -XX:MaxTenuringThreshold=15
    
    
    ```

    

    -Xms    ->  -XX:InitialHeapSize

    -Xmx    ->  -XX:MaxHeapSize 

     

jinfo查看当前运行程序的配置

```
jps -l

28356
1786 sun.tools.jps.Jps
88682 org.jetbrains.jps.cmdline.Launcher

第一种 查看参数
jinfo -flag 具体参数 java进程编号
jinfo -flags    java进程编号
```



查看jvm参数盘底

java -XX:+PrintFlagsInitial   （查看出厂 默认安装）

主要查看修改更新

Java -XX:PrintFlagsFinal    (= 初始的，  := 用户或者jvm修改的)



java -XX:+PrintCommandLineFlags      （主要看垃圾回收器）



jvm常用配置

```
-Xms  初始大小内存，默认为物理内存的1/64
-Xmx  最大分配内存，默认为物理内存的1/4
-Xss  设置单个线程栈的大小，一般默认512k-1024k 等价于-XX:ThreadStackSize 
-Xmn  设置年轻代大小
-XX:MetaspaceSize    设置元空间大小（永久代），java8后使用本地内存。

-XX:+PrintGCDetails
1.输出GC的详细收集信息
2.GC
3.Full GC
名称：GC前内存占用->GC后内存占用（该区内存总大小）

-XX:SurvivorRatio   新生代 Eden:S0:S1(默认8:1:1， -XX:SurvivorRatio=8，4:1:1, -XX:SurvivorRatio=4)，
-XX:NewRatio   配置年轻代与老年代在堆结构的占比，默认-XX:NewRatio=2，新生代占1，老年代占2，年轻代占整个堆的1/3。-XX:NewRatio=4，新生代占1，老年代占4
-XX:MaxTenuringThreshold   设置垃圾的最大年龄，新生代存活多久去老年代（必须在0-15之前）
```





引用：强、软、弱、虚  

弱引用     WeakHashMap 

虚引用，java.lang.ref.PhantomReference，get方法总是null，必须和引用队列ReferenceQueue联合使用。

唯一目的，在这个对象被收集器回收的时候收到一个系统通知，或者添加进一步处理。



Java oom的认识

java.lang.StackOverflowError   

Java.lang.OutOfMemoryError:  Java heap space

Java.lang.OutOfMemoryError: GC  overhead limit exceeded

Java.lang.OutOfMemoryError: Direct buffer memory

```
写nio程序，经常使用ByteBuffer来读取或者写入数据。可以使用native函数库直接分配堆外内存，然后通过directByteBuffer对象作为内存的引用进行操作，避免了在Java堆和Native堆中来回复制数据。
但是DirectBuffer这种本地内存，不归GC管辖，容易造成本地内存用光，再次尝试分配，就oom。
```

Java.lang.OutOfMemoryError:unable to create new native thread

```
高并发请求服务器，经常出现
native thread异常与对应的平台有关
1.应用创建太多线程，超过系统承载极限
2.服务器不允许创建这么多线程，linux系统默认允许单个进程可以创建的线程数是1024个

解决办法：
1.降低应用程序创建线程的数量
2.修改linux配置，提高默认限制
```

Java.lang.OutOfMemoryError:Metaspace

```
java8之后使用Metaspace替代永久代
MetaSpace不在虚拟机内存，而是使用本地内存
存放：虚拟机加载类的信息，常量池，静态变量，即时编译后的代码
```



垃圾回收算法：4种

- 引用计数
- 复制
- 标清：易产生内存碎片
- 标整

垃圾回收器：

4种主要垃圾收集器：

```
serial:为单线程环境设计，只使用一个线程进行垃圾回收，会暂停所有用户线程。不适合服务器
paralel:多个垃圾收集线程并行工作，此时用户线程暂停，适用于科学计算/大数据处理
cms:并发垃圾回收器，用户线程和垃圾收集线程同时执行（不一定并行，可能交替执行），不需要停顿用户线程，适用于强交互、对响应时间有要求的场景，互联网公司多用它。
G1:（java8诞生）。G1垃圾回收器将堆内存分割成不同的区域然后并发的对其进行垃圾回收。
```



怎么查看服务器默认的垃圾收集器？

```
java -XX:+PrintCommandLineFlags -version
```

生产上如何配置垃圾收集器？

```
-XX:+UseXXXXXX
7种垃圾回收
-UseSerialOldGC(废弃)
-UseSerialGC
-UseConcMarkSweepGC
-UseParNewGC
-UseParallelGC
-UseParallelOldGC
-UseG1GC
```

谈一谈你对垃圾收集器的理解？

新生代： Serial Copy，Parallel Scavenge(相当于Parallel GC)， ParNew 

老年代：Serial Old， Parallel Old， CMS

新生代、老年代：G1



参数说明

```
DefNew：Default New Generation
Tenured： Old
ParNew：Parallel New Generation
PSYoungGen：Parallel Scavenge
ParOldGen： Parallel Old Generation
```



JVM Server/Client模式

```
64位 only-server  
```



新生代用ParNew（线程数可设置），老年代默认用SerialOld。

默认的Parallel Scavenge收集器，新生代和老年代都是串行。

```
可控制吞吐量
自适应调节策略
```



并发标记清除CMS（新生代 会采用Parallel new，老年代SerialOld会兜底）

适合内存大、CPU核数多的服务器端应用，是G1出现前大型应用的首选收集器。

```
四步过程：
1.初始标记：停顿
2.并发标记：和用户线程一起
3.重新标记：停顿
4.并发清除：和用户线程一起

优缺点：
1.并发收集低停顿
2.会导致大量碎片
```



如何选择垃圾收集器？

```
组合选择：
单CPU或小内存，单机程序
	-XX:+UseSrialGC
多CPU，需要大吞吐量，如后台计算型应用
	-XX:+UseParallelGC或者-XX:+UseParallelOldGC
多CPU，追求低停顿，需要快速响应如互联网应用
	-XX:+UseConCMarkSweepGC
	-XX+ParNewGC
```

G1垃圾收集器

-XX:+UseG1GC

```

```

G1是什么？

```
面向服务端应用的收集器。 
能与cms一样，与应用程序并发执行。
G1 Stop the world更可控，添加了停顿时间预测机制，可以指定期望停顿时间。
去除了内存碎片的问题。（标整）

思想：Elden，Survivior和Tenured不再是连续的，变成了一个个大小一样的region（1-32M不等）。运行代区，身份可以切换。
```

总结：Region化垃圾收集器，最大好处化整为零，避免全内存扫描，只需要按照区域来进行扫描即可。

流程：初始标记、并发标记、最终标记、筛选回收



常用参数：

```
-XX:+UseG1GC
-XX:G1HeapRegionSize=n  设置G1区域的大小，值是2的幂，1-32M，目标根据最小的堆划分成2048个区域
-XX:MaxGCPauseMillis=n  最大GC停顿时间，软目标，尽可能保证。


-XX  堆占用了多少的时候触发GC，默认45
-XX	 并发GC使用的线程数	
-XX  空闲内存，预留内存百分比，降低目标空间溢出的风险，默认10%
```



和CMS相比的优势：

```
1.G1无内存碎片
2.可以精确控制停顿。
```



JVMGC + SpringBoot + 微服务的生产部署和调参优化

1、 IDEA开发完微服务工程

2、maven clean package 打包

3、微服务启动的时候，同时配置JVM/GC的调优参数

4、公式

​	java -server jvm的各种参数  -jar   jar/war包名字



生产服务器变慢，请谈谈你的分析思路和定位？

```
整机：top   看cpu、mem、load average（1、5、15min 系统的平均负载）  uptime精简版
CPU：vmstat 
	- 查看cpu
	- 查看额外 查看所有cpu核信息  mpstat -P  ALL 2
														pidstat -p 进程号 -r 采样间隔数
内存：free   
			    free -m
硬盘：df      
					df -h
磁盘io： iostat   
					磁盘io性能评估   iostat -xdk 2 3
					pidstat -d 采样间隔数 -p 进程号
网络io： ifstat
				默认本地没有，下载ifstat	
```



加入生产环境CPU占用过高，请谈谈你的分析思路和定位

```
结合Linux和JDK命令一块分析

1.先用top命令查找占用最高
2.ps -ef 或者 jps进一步定位，查看哪个后台程序在搞事情
3.定位到具体线程或者代码
	ps -mp 进程 -o THREAD, tid, time
	
	-m 显示所有的线程
	-p pid进程使用cpu的时间
	-o 该参数后是用户自定义格式

4.将需要的线程id转换为16进制格式（英文小写）
5.jstack 进程id | grep tid（16进制线程id小写英文） -A60
```



一般出故障了，你如何调试+排查+检索

```

```

