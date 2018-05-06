package database.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by SF on 2018/4/18.
 */
public class RedisDistLock {
    private Jedis jedis;
    private String lockKey;
    private long timeoutMses;
    private long expireMses;

    public RedisDistLock(Jedis jedis, String lockKey, long timeoutMses, long expireMses) {
        this.jedis = jedis;
        this.lockKey = lockKey;
        this.timeoutMses = timeoutMses;
        this.expireMses = expireMses;
    }

    public synchronized boolean acquire() throws InterruptedException {
        //锁到期时间
        String expire = System.currentTimeMillis() + expireMses + 1 + "";
        long timeout = timeoutMses;
        while (timeout > 0) {
            if (jedis.setnx(lockKey, expire) == 1) {
                return true;
            }
            //redis里的时间
            String value = jedis.get(lockKey);
            //判断是否为空，不为空的情况下，如果被其他线程设置了值，则第二个条件判断是过不去的
            // lock is expired
            if (value != null && Long.valueOf(value) < System.currentTimeMillis()) {
                //获取上一个锁到期时间，并设置现在的锁到期时间，
                //只有一个线程才能获取上一个线上的设置时间，因为jedis.getSet是同步的
                String oldExpire = jedis.getSet(lockKey, String.valueOf(System.currentTimeMillis() + expireMses + 1));
                if (oldExpire != null && oldExpire.equals(value)) {
                    //如过这个时候，多个线程恰好都到了这里，但是只有一个线程的设置值和当前值相同，他才有权利获取锁
                    // lock acquired
                    return true;
                }
            }
            timeout = timeout - 100;
            Thread.sleep(100);
        }
        return false;
    }

    public synchronized void release() {
        jedis.del(lockKey);
    }
}
