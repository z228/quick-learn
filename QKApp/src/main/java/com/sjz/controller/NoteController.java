package com.sjz.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjz.pojo.Note;
import com.sjz.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController {
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/note/getAllNote",produces="application/json;charset=utf-8")
    @ResponseBody
    public String getAllNote() throws JsonProcessingException {
        List<Note> allNote = noteService.getAllNote();
        System.out.println(allNote);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(allNote);
        return s;
    }

    @RequestMapping(value="/note/getNoteById",produces="application/json;charset=utf-8")
    public String getNoteById(int nid) throws JsonProcessingException {
        Note note = noteService.getNoteById(nid);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(note);
        return s;
    }

    @RequestMapping("/note/addnote")
    public String addNote(String note){
        Note note1=JSONObject.parseObject(note,Note.class);
        noteService.addNote(note1);
        return "ok";
    }

    @RequestMapping("/note/modnote")
    public String modNote(String note){
        Note note1=JSONObject.parseObject(note,Note.class);
        noteService.modNote(note1);
        return "ok";
    }

    @RequestMapping("/node/delnote")
    public String delNote(int nid){
        noteService.delNote(nid);
        return "ok";
    }
}
