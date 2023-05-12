package com.sjz.services;

import com.sjz.mapper.CompositionMapper;
import com.sjz.pojo.Composition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CompostionServiceImpl implements CompositionService{
    @Autowired
    private CompositionMapper compositionMapper;
    @Override
    public List<Composition> getQueryWithLimitComp(HashMap<String,Object> map) {
        return compositionMapper.getQueryWithLimitComp(map);
    }
}
