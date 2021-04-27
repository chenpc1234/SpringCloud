package com.chen.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/27/04/27  11:12
 */
public class MyRule extends AbstractLoadBalancerRule {

    private AtomicInteger nextServerCyclicCounter ;

    public MyRule(){
        nextServerCyclicCounter = new AtomicInteger(0);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
    @Override
    public Server choose(Object key) {
        ILoadBalancer lb = getLoadBalancer();
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }
            int index = getServerIndex(serverCount);

            server = upList.get(index);
            if (server == null) {
                Thread.yield();
                continue;
            }
            if (server.isAlive()) {
                return (server);
            }
            server = null;
            Thread.yield();
        }

        return server;
    }

    /**
     * 编写自己的逻辑  获取应该使用哪个服务器提供服务
     * @param modulo 服务个数
     * @return 服务下标
     */
    private int getServerIndex(int modulo) {
        for (;;) {
            int current = nextServerCyclicCounter.get();
            int next = current+1;
            if (nextServerCyclicCounter.compareAndSet(current, next)){
                System.out.println(current);
                if (current <=10 ){
                    return 0;
                }else {
                    return 1;
                }
            }
        }
    }
}
