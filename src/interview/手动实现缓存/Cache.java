package interview.手动实现缓存;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 参考：https://blog.csdn.net/u013314786/article/details/80658738
 * <p>
 * 1  使用现有的缓存技术框架，比如redis,ehcache。优点：成熟，稳定，功能强大；缺点，项目需要引入对应的框架，不够轻量。
 * 2  如果不考虑分布式，只是在单线程或者多线程间作数据缓存，其实完全可以自己手写一个缓存工具。下面就来简单实现一个这样的工具。
 */
public class Cache {
    //键值对集合
    private final static Map<String, Entity> map = new HashMap<>();
    //定时器线程池 ，用于清理过期的缓存
    private final static ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();//这里为啥是Single

    /**
     * 添加缓存
     *
     * @param key
     * @param data
     */
    public synchronized static void put(String key, Object data) {
        Cache.put(key, data, 0);
    }

    public synchronized static void put(String key, Object data, long expire) {
        //清除原键值对
        Cache.remove(key);
        //设置过期时间
        if (expire > 0) {
            Future future = executor.schedule(new Runnable() {
                @Override
                public void run() {
                    //过期后清楚该键值对
                    synchronized (Cache.class) {
                        map.remove(key);
                    }
                }
            }, expire, TimeUnit.MILLISECONDS);
            map.put(key, new Entity(data, future));

        } else {
            //不设置过期时间咯
            map.put(key, new Entity(data, null));
        }
    }

    public synchronized static Object get(String key) {
        Entity entity = map.get(key);
        return entity == null ? null : entity.value;
    }

    public synchronized static <T> T get(String key, Class<T> clazz) {
        return clazz.cast(Cache.get(key));// cast??
    }

    public synchronized static Object remove(String key) {
        //清楚原缓存数据
        Entity entity = map.remove(key);
        if (entity == null) {
            return null;
        }
        //清除原键值对定时器
        if (entity.future != null) {

            entity.future.cancel(true);
        }
        return entity.value;
    }

    /**
     * 查询当前缓存的键值对数量
     *
     * @return
     */
    public synchronized static int size() {
        return map.size();
    }

    /**
     * 缓存实体类，内部类
     */
    private static class Entity {
        /**
         * 键值对的value
         */
        public Object value;
        /**
         * 定时器future
         */
        public Future future;

        public Entity(Object value, Future future) {
            this.value = value;
            this.future = future;
        }
    }
}
