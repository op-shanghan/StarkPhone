package com.stark.utils.redis;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * Created by pro-伤寒 on 2016/11/7.
 */
public class JedisProvider {
    private JedisPool jedisPool;

    public JedisPool getJedisPool() {
        return jedisPool;
    }
    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public <T> void writeObject(String key,T object){
        if(null != key && key.replaceAll(" ","").length()>0){
            String objStr = JSONObject.toJSONString(object);
            Jedis jedis = jedisPool.getResource();
            jedis.set(key,objStr);
        }
    }

    public <T> T readObject(String key,Class<T> objType){
        if(null != key && key.replaceAll(" ","").length()>0){
            Jedis jedis = jedisPool.getResource();
            String objStr = jedis.get(key);
            if(null != objStr){
                return JSONObject.parseObject(objStr,objType);
            }
        }
        return null;
    }

    public String readString(String key){
        if(null != key && key.replaceAll(" ","").length()>0){
            Jedis jedis = jedisPool.getResource();
            return jedis.get(key);
        }
        return null;
    }

    public void writeString(String key,String value){
        if(null != key && key.replaceAll(" ","").length()>0) {
            Jedis jedis = jedisPool.getResource();
            jedis.set(key, value);
        }
    }

    public void removeKey(String key){
        if(null != key && key.replaceAll(" ","").length()>0) {
            Jedis jedis = jedisPool.getResource();
            jedis.del(key);
        }
    }

    public <T> void writeObjects(String key, List<T> objs){
        if(null != key && key.replaceAll(" ","").length()>0) {
            String objStr = JSONArray.toJSONString(objs);
            Jedis jedis = jedisPool.getResource();
            jedis.set(key, objStr);
        }
    }

    public <T> List<T> readObjects(String key,Class<T> objType){
        if(null != key && key.replaceAll(" ","").length()>0) {
            Jedis jedis = jedisPool.getResource();
            String objStr = jedis.get(key);
            if (null != objStr) {
                return JSONArray.parseArray(objStr, objType);
            }
        }
        return null;
    }
}
