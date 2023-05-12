package com.sjz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjz.pojo.Video;
import com.sjz.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class VideoController {
    @Autowired
    private VideoService videoService;

    @ResponseBody
    @RequestMapping(value = "/video/queryAllDesc",produces="application/json;charset=utf-8")
    public String queryAllDesc(int pageNum) throws JsonProcessingException {
        int pageStart=(pageNum-1)*5;
        List<Video> videos = videoService.queryAllDesc(pageStart);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(videos);
//        System.out.println(s);
        return s;
    }
}
