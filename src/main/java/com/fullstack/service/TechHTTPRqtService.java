package com.fullstack.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-technologies")
public interface TechHTTPRqtService {

    @RequestMapping(value = "/deleteTechnology", method= RequestMethod.GET)
    public void deleteTechnology(@RequestParam("technologyId") String technologyId);
}
