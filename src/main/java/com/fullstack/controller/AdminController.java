package com.fullstack.controller;

import com.fullstack.model.TechnologiesDTO;
import com.fullstack.model.UsersDTO;
import com.fullstack.service.TechHTTPRqtService;
import com.fullstack.service.TechnologiesService;
import com.fullstack.service.UsersService;
import com.netflix.discovery.converters.Auto;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.hibernate.annotations.Synchronize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
public class AdminController {

    private String baseURL = "http://localhost:9002";

    @Autowired
    private TechnologiesService technologiesService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private TechHTTPRqtService techHTTPRqtService;

    @RequestMapping("/findUsers")
    public List listUsers(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        List<UsersDTO> list = usersService.findUsersByName(userName);
        return list;
    }


    @RequestMapping(value = "/changeUserStatus", method = RequestMethod.POST)
    public void changeStatus(@RequestBody UsersDTO userFormDTO) {
        if("0".equals(userFormDTO.getActive())) {
            userFormDTO.setActive("1");
        }else {
            userFormDTO.setActive("0");
        }
        usersService.editUser(userFormDTO);
    }

    @RequestMapping("/listTechnologies")
    public List<TechnologiesDTO> findAllTechnologies() {
        List<TechnologiesDTO> list = technologiesService.getAllTechnologies();
        return list;
    }

    @RequestMapping(value = "/addTechnology", method = RequestMethod.POST)
    public TechnologiesDTO addTechnology(@RequestBody TechnologiesDTO technologiesDTO) {
        technologiesService.addTechnologies(technologiesDTO);
        return technologiesDTO;
    }


    @RequestMapping(value = "/editTechnology", method = RequestMethod.POST)
    public TechnologiesDTO editTechnology(@RequestBody TechnologiesDTO technologiesDTO) {
        technologiesService.editTechnologies(technologiesDTO);
        return technologiesDTO;
    }


//    @RequestMapping(value = "/deleteTechnology", method = RequestMethod.GET)
//    public void deleteTechnology(HttpServletRequest request) {
//        String technologyId = request.getParameter("technologyId");
//        technologiesService.deleteTechnology(Long.valueOf(technologyId));
//
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        CloseableHttpResponse response = null;
//        try {
//            URI uri = new URIBuilder(baseURL+"/deleteTechnology").setParameter("technologyId",technologyId).build();
//            HttpGet httpGet = new HttpGet(uri);
//            response = httpclient.execute(httpGet);
//            if (response.getStatusLine().getStatusCode() == 200) {
//                return;
//            }
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (response != null) {
//                try {
//                    response.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            try {
//                httpclient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

//    @RequestMapping("/deleteTechnology")
//    public void deleteTechnology(HttpServletRequest request) {
//        String technologyId = request.getParameter("technologyId");
//        technologiesService.deleteTechnology(Long.valueOf(technologyId));
//    }


//    @RequestMapping(value = "/deleteTechnology", method = RequestMethod.GET)
//    public String deleteTechnology(@RequestParam("technologyId") String technologyId) {
//        //techHTTPRqtService.deleteTechnology(technologyId);
//        technologiesService.deleteTechnology(Long.valueOf(technologyId));
//        return "Success";
//    }


    @RequestMapping(value = "/deleteTechnology", method = RequestMethod.GET)
    public void deleteTechnology(HttpServletRequest request) {
        String technologyId = request.getParameter("technologyId");
        techHTTPRqtService.deleteTechnology(technologyId);
        //technologiesService.deleteTechnology(Long.valueOf(technologyId));
    }




}
