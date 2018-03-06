###一、.Retrofit 底层对网络的访问默认也是基于okhttp

###二、.Jsoup是一个java的开源HTML解析器：
https://jsoup.org/download

###三、.RxJava
1、rxava 是ReactiveX的一种Java实现。Reactive Extensions的缩写。

微软给的定义：Rx是一个函数库，让开发者可以利用 可观察序列和LINQ风格查询操作符来
编写异步 和 基于事件的程序。
开发者可以用Observables表示异步数据流，用LINQ操作符查询异步数据流，
用Schedulers参数化异步数据流的并发处理。
RX可以这样定义： Rx = Observables + LINQ + Schedulers.

2、为何要用RxJava

说到异步，Android里有AsyncTask，RxJava的原理就是创建一个Observable对象来干活，
然后使用各种操作符建立起来的链式操作，就如托尼盖流水线一样，
把你想要处理的数据一步一步地加工成你想要的成品，然后发射给Subscriber处理。

3、RxJava与观察者模式 

RxJava的异步操作是通过扩展的观察者模式来实现的。
RxJava有4个角色Observable、Observer、Subscriber和Subject.


