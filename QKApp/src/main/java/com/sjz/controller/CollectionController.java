package com.sjz.controller;

import com.alibaba.fastjson.JSONObject;
import com.sjz.pojo.MyCollection;
import com.sjz.services.CollectionServices;
import javafx.print.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollectionController {
    @Autowired
    private CollectionServices collectionServices;

    @GetMapping(value = "/colletion" ,produces="application/json;charset=utf-8")
    public String index(){
        List<MyCollection> collationList = collectionServices.getAll();
        return JSONObject.toJSONString(collationList);
    }

    /**
     * 判断是否收藏
     * @param id
     * @return
     */
    @GetMapping("/collection/collId")
    public String isCollection(String id){
        List<MyCollection> collectionList = collectionServices.isCollection(Integer.parseInt(id));
        if (collectionList!=null && collectionList.size()!=0){
            return "ok";
        }else {
            return "false";
        }
    }

    /**
     * 修改或田间收藏
     */
    @GetMapping("/collection/changeColl")
    public String changeCollection(String id,String deleteFlag){
        List<MyCollection> collectionList = collectionServices.isExistCollection(Integer.parseInt(id));
        if (collectionList!=null && collectionList.size()!=0){
            int result = collectionServices.changeCollection(Integer.parseInt(id),Integer.parseInt(deleteFlag));
            if (result!=0){
                return "ok";
            }
        }else {

            int reslut = collectionServices.addCollection(Integer.parseInt(id));
            if (reslut!=0){
                return "ok";
            }
        }
        return "false";
    }
}
