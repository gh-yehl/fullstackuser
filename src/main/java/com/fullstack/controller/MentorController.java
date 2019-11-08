package com.fullstack.controller;

import com.fullstack.model.MentorMenuDTO;
import com.fullstack.model.TrainingsDTO;
import com.fullstack.service.TrainingsService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
public class MentorController {

    public String baseURL = "http://trainings:9001";
    List<TrainingsDTO> list = new ArrayList<TrainingsDTO>();

    @Autowired
    private TrainingsService trainingsService;

    @RequestMapping("/mentorCurrentTraining")
    public List<MentorMenuDTO> currentTrainings(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        userId = "1";
        List<MentorMenuDTO> list = new ArrayList<MentorMenuDTO>();

        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            URI uri = new URIBuilder(baseURL+"/currentMentorTrainings").setParameter("userId",userId).build();
            HttpGet httpGet = new HttpGet(uri);
            response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                // 解析响应数据
                HttpEntity httpEntity = response.getEntity();
                String content = EntityUtils.toString(httpEntity, "UTF-8");
                System.out.println(content);
                JSONArray jsonArray = JSONArray.fromObject(content);
                list = jsonArray.toList(jsonArray, new MentorMenuDTO(), new JsonConfig());

                System.out.println(jsonArray);
                //list = trainingsService.getUserCurrentTraining(Long.valueOf(userId));
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return list;
    }


    @RequestMapping("/mentorCompletedTraining")
    public List<MentorMenuDTO> completedTrainings(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        userId = "1";
        List<MentorMenuDTO> list = new ArrayList<MentorMenuDTO>();

        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            URI uri = new URIBuilder(baseURL+"/completedMentorTrainings").setParameter("userId",userId).build();
            HttpGet httpGet = new HttpGet(uri);
            response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                // 解析响应数据
                HttpEntity httpEntity = response.getEntity();
                String content = EntityUtils.toString(httpEntity, "UTF-8");
                System.out.println(content);
                JSONArray jsonArray = JSONArray.fromObject(content);
                list = jsonArray.toList(jsonArray, new MentorMenuDTO(), new JsonConfig());

                System.out.println(list.size());
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return list;

    }


}
