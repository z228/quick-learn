package com.sjz.services;

import com.sjz.pojo.Composition;

import java.util.HashMap;
import java.util.List;

public interface CompositionService {
    //获取指定类型文章并限制10
    public List<Composition> getQueryWithLimitComp(HashMap<String,Object> map);
}
