1.  hash、hashMap、hashTable、conCurrentHashMap


2.  布隆过滤器


3.  一致性hash  2:08:00
    
    参考：https://blog.csdn.net/cywosp/article/details/23397179
    
    服务器的设计。
    经典服务器设计。
        负载均衡。
            轮询法
            随机法
            源地址hash
            加权轮询法
            加权随机法
            最小链接数法
    划分成环。
    虚拟节点技术。【！！！】
        准备一个路由表。
            物理机器对应虚拟节点。1个物理机器对应1000个虚拟节点。
            
        