package com.example.common.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-provider")
@Component
public interface TestService {
    @RequestMapping("/test/list")
    String test();
}
