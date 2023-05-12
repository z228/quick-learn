package com.sjz.services;

import com.sjz.pojo.Video;

import java.util.List;

public interface VideoService {
    public List<Video> queryAllDesc(int pageStart);
}
