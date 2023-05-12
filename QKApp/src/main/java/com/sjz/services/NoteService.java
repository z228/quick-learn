package com.sjz.services;

import com.sjz.pojo.Note;

import java.util.List;

public interface NoteService {
    //添加一个笔记
    int addNote(Note note);
    //修改一个笔记
    int modNote(Note note);
    //查询所有
    List<Note> getAllNote();
    //根据id获取note
    Note getNoteById(int id);

    int delNote(int nid);
}
