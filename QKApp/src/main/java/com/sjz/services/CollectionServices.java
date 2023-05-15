package com.sjz.services;

import com.sjz.pojo.MyCollection;
import javafx.print.Collation;

import java.util.List;

public interface CollectionServices {
    List<MyCollection> getAll();

    List<MyCollection> isCollection(int id);

    int addCollection(int id);

    int changeCollection(int id,int deleteFlag);
    List<MyCollection> isExistCollection(int id);
}
