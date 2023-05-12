package com.sjz.services;

import com.sjz.mapper.VideoMapper;
import com.sjz.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService{
    @Autowired
    private VideoMapper videoMapper;
    @Override
    public List<Video> queryAllDesc(int pageStart) {
        return videoMapper.queryAllDesc(pageStart);
    }
}
