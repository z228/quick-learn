package com.sjz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjz.pojo.Composition;
import com.sjz.services.CompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class CompositionController {
    @Autowired
    private CompositionService compositionService;

    @RequestMapping(value = "/comp/getComp",produces = {"application/json;charset=UTF-8"})
    public String getComp(String type,int pageNum) throws JsonProcessingException {
        int pageStart=(pageNum-1)*5;
        HashMap<String, Object> map = new HashMap<String,Object>();
        map.put("type",type);
        map.put("pageStart",pageStart);
        List<Composition> allComp = compositionService.getQueryWithLimitComp(map);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(allComp);
//        System.out.println(s);
        return s;
    }
}
