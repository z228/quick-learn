package com.sjz.mapper;

import com.sjz.pojo.Video;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideoMapper {
    public List<Video> queryAllDesc(int pageStart);
}
