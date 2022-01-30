package io.thread;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* 
 * @param <K>
* @param <V>
*/
public class WeakConcurrentExpiryHashMap<K, V> extends ConcurrentHashMap<K, V> {

      private static final long serialVersionUID = 1L;
      Logger logger = LoggerFactory.getLogger(WeakConcurrentExpiryHashMap.class);
      private Map<K, Long> timeMap = new ConcurrentHashMap<K, Long>();
      private long expiryInMillis = 1000*60*60; //Default 1 hours

      public WeakConcurrentExpiryHashMap() {
            initialize();
      }

      public WeakConcurrentExpiryHashMap(long expiryInMillis) {
            this.expiryInMillis = expiryInMillis;
            initialize();
      }

      void initialize() {
            CleanerThread t =new CleanerThread();
            t.start();
            
            Runtime.getRuntime().addShutdownHook(new Thread() {
                  @Override
                  public void run() {
                        t.stopThread();
                  }
            });
      }

      @Override
      public V put(K key, V value) {
            Date date = new Date();
            timeMap.put(key, date.getTime());
            V returnVal = super.put(key, value);
            return returnVal;
      }

      @Override
      public void putAll(Map<? extends K, ? extends V> m) {
            for (K key : m.keySet()) {
                  put(key, m.get(key));
            }
      }

      @Override
      public V putIfAbsent(K key, V value) {
            if (!containsKey(key)){
                  return put(key, value);
            } else {
                  return get(key);
            }
      }

      class CleanerThread extends Thread {
            volatile boolean stop = false;
            
            public void stopThread() {
                  this.stop = true;
            }
            
            @Override
            public void run() {
                  while (true && stop == false) {
                        cleanMap();
                        try {
                              //Thread.sleep(expiryInMillis / 2);
                              Thread.sleep(expiryInMillis);
                        } catch (InterruptedException e) {
                              e.printStackTrace();
                        }
                  }
            }

            private void cleanMap() {
                  long currentTime = new Date().getTime();
                  for (K key : timeMap.keySet()) {
                        if (currentTime > (timeMap.get(key) + expiryInMillis)) {
                              V value = remove(key);
                              timeMap.remove(key);
                              logger.info(" WeakConcurrentExpiryHashMap - Removing : " + key + " : " + value);
                        }
                  }
            }
      }
}
