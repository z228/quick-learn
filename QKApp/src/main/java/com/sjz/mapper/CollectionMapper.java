package com.sjz.mapper;

import com.sjz.pojo.MyCollection;
import javafx.print.Collation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollectionMapper {
    List<MyCollection> getAll();

    List<MyCollection> isCollection(int id);

    int addCollection(int id);

    int changeCollection(int id,int deleteFlag);
    List<MyCollection> isExistCollection(int id);
}
