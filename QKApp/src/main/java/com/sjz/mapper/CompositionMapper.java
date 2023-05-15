package com.sjz.mapper;

import com.sjz.pojo.Composition;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CompositionMapper {
    public List<Composition> getQueryWithLimitComp(HashMap<String,Object> map);

    public Composition getCompositionById(int id);
}
