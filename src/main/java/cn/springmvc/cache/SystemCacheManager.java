package cn.springmvc.cache;

import org.springframework.beans.factory.InitializingBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by free on 17-2-12.
 */
public class SystemCacheManager implements InitializingBean{
    private static CacheProvider cacheProvider = null;
    private static SystemCacheManager instance=null;

    private static final Object LOCK=new Object();

    private List<String> datas=new ArrayList<String>();

    @Override
    public void afterPropertiesSet() throws Exception {
        if (instance==null){
            synchronized (LOCK){
                if (instance==null){
                    SystemCacheManager.instance=this;
                }
            }
        }
    }

    public void initCaches(){
        if (cacheProvider==null){
            return;
        }

        // init data
        List<String> datas=new ArrayList<String>();
        datas.add("C++");
        datas.add("java");
        datas.add("C");
        datas.add("pythen");
        datas.add("linux");
        datas.add("shell");
        datas.add("ruby");
        cacheProvider.put("languge.keys", (Serializable) datas);
        System.out.println(datas);
    }

    public List<String> getDatas(){
        return (List<String>) cacheProvider.get("languge.keys");
    }

    public static SystemCacheManager getInstance(){
        return instance;
    }

    public  CacheProvider getCacheProvider() {
        return cacheProvider;
    }

    public  void setCacheProvider(CacheProvider cacheProvider) {
        SystemCacheManager.cacheProvider = cacheProvider;
    }
}
