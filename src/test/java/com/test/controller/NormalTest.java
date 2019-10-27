package com.test.controller;

import com.fullstack.model.TrainingsDTO;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.junit.Test;

import java.sql.Time;
import java.util.List;

public class NormalTest {

    @Test
    public void test() {
        String jsonStr = "[{\"id\":1,\"userId\":6,\"mentorId\":1,\"technologyId\":1,\"trainingName\":\"HTML5\",\"fee\":\"100\",\"status\":\"0\",\"user\":{\"id\":6,\"userName\":\"Dave\",\"password\":\"123\",\"contactNumber\":null,\"role\":\"User\",\"linkedinURL\":null,\"workingYears\":\"\",\"active\":\"1\",\"email\":\"dave@dave.com\",\"trainingsList\":[]},\"mentor\":{\"id\":1,\"userName\":\"Leon\",\"password\":\"123\",\"contactNumber\":null,\"role\":\"Mentor\",\"linkedinURL\":null,\"workingYears\":\"9\",\"active\":\"1\",\"email\":\"leon@leon.com\",\"trainingsList\":[{\"id\":1,\"technologies\":{\"id\":1,\"technologyName\":\"HTML5\",\"fee\":\"100\",\"totalHours\":\"12\"},\"userId\":6,\"mentorId\":1,\"technologyId\":1,\"status\":\"0\"},{\"id\":3,\"technologies\":{\"id\":5,\"technologyName\":\"Springboot\",\"fee\":\"600\",\"totalHours\":\"72\"},\"userId\":6,\"mentorId\":1,\"technologyId\":5,\"status\":\"1\"},{\"id\":4,\"technologies\":{\"id\":6,\"technologyName\":\"Docker\",\"fee\":\"150\",\"totalHours\":\"36\"},\"userId\":6,\"mentorId\":1,\"technologyId\":6,\"status\":\"1\"}]},\"technologies\":{\"id\":1,\"technologyName\":\"HTML5\",\"fee\":\"100\",\"totalHours\":\"12\"}}]";
        //String jsonStr = "[{\"fee\":\"Leon\",\"id\":9},{\"fee\":\"Alex\",\"id\":7},{\"fee\":\"Kathy\",\"id\":39}]";
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);
        List list = jsonArray.toList(jsonArray, new TrainingsDTO(), new JsonConfig());


        System.out.println(list);
    }
}
