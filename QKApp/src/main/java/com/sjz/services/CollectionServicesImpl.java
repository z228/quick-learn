package com.sjz.services;

import com.sjz.mapper.CollectionMapper;
import com.sjz.pojo.MyCollection;
import javafx.print.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServicesImpl implements CollectionServices{
    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public List<MyCollection> getAll() {
        return collectionMapper.getAll();
    }

    @Override
    public List<MyCollection> isCollection(int id) {
        return collectionMapper.isCollection(id);
    }

    @Override
    public int addCollection(int id) {
        return collectionMapper.addCollection(id);
    }

    @Override
    public int changeCollection(int id,int deleteFlag) {
        return collectionMapper.changeCollection(id,deleteFlag);
    }

    @Override
    public List<MyCollection> isExistCollection(int id) {
        return collectionMapper.isExistCollection(id);
    }
}
