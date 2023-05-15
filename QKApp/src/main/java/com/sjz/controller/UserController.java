package com.sjz.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjz.annotation.UnInterception;
import com.sjz.pojo.ResponseResult;
import com.sjz.pojo.User;
import com.sjz.services.UserService;
import com.sjz.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/modUser")
    public String modUser(String user){
        User user1 = JSONObject.parseObject(user, User.class);
        int i = userService.modUserInfo(user1);
        System.out.println("i: "+i);
        return "ok";
    }

    @RequestMapping(value = "/user/getUserByName",produces = {"application/json;charset=UTF-8"})
    public String getUserByName(String name) throws JsonProcessingException {
        name=name.replace("\"","");
        User user = userService.getUserByName(name);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(user);
//        System.out.println(s);
        return s;
    }

    @RequestMapping("/user/getAllUser")
    public String getAllUser() throws JsonProcessingException {
        List<User> allUser = userService.getAllUser();
        ObjectMapper mapper=new ObjectMapper();
        //序列化对象到json
        String s =mapper.writeValueAsString(allUser);
        return s;
    }

    @GetMapping("/user/getAllUserLimit/{current}/{pageSize}")
    public String getAllUserLimit(@PathVariable Integer current,@PathVariable Integer pageSize){
        List<User> users = userService.getAllUserLimit(current,pageSize);
        return JSONObject.toJSONString(users);
    }


    @RequestMapping("/user/login")
    @UnInterception
    public ResponseResult UserLogin(String username, String password){
        username=username.replace("\"","");
        password=password.replace("\"","");
        User user = userService.getUserByName(username);
        HashMap map = new HashMap();
        if (user==null){
            return new ResponseResult(400,"登录失败");
        }else {
            String password1 = user.getPassword();
            if (password.equals(password1)){
                String token = JwtUtil.createJWT(user.getUid() + "");
                map.put("token",token);
                map.put("userinfo",user);
                return new ResponseResult(200,"登录成功",map);
            }else {
                return new ResponseResult(400,"登录失败");
            }
        }
    }

    @RequestMapping("/user/register")
    @UnInterception
    public String addUser(String user){
        User user1 = JSONObject.parseObject(user,User.class);
//        System.out.println(user1);
        int i=userService.addUser(user1);
        return "true";
    }

    @GetMapping("/user/total")
    public int total(){
        int total = userService.getTotal();
        return total;
    }
}
