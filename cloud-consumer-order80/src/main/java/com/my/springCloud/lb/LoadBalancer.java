package com.my.springCloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author ZDL
 * @create 2022-02-22 16:17
 */
public interface LoadBalancer {

    public ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
