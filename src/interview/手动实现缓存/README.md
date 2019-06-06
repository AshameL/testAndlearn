
 * 参考：https://blog.csdn.net/u013314786/article/details/80658738
 *
 * 1  使用现有的缓存技术框架，比如redis,ehcache。优点：成熟，稳定，功能强大；缺点，项目需要引入对应的框架，不够轻量。
 * 2  如果不考虑分布式，只是在单线程或者多线程间作数据缓存，其实完全可以自己手写一个缓存工具。下面就来简单实现一个这样的工具。

本工具类主要采用    
    HashMap+定时器线程池 实现，   
    map 用于存储键值对数据，   
    map的value是 Cache 的内部类对象 Entity，   
    Entity 包含 value 和该键值对的生命周期定时器 Future。   
    Cache 类对外只提供了    
    put(key, value), put(key, value, expire), get(key), get(key, class), remove(key), size()几个``同步方法``。

当添加键值对数据的时候，首先会调用remove()方法，清除掉原来相同 key 的数据，并取消对应的定时清除任务，然后添加新数据到 map 中，并且，如果设置了有效时间，则添加对应的定时清除任务到定时器线程池。
