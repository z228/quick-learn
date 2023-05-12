package com.sjz.services;

import com.sjz.mapper.NoteMapper;
import com.sjz.pojo.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    private NoteMapper noteMapper;

    @Override
    public int addNote(Note note) {
        return noteMapper.addNote(note);
    }


    @Override
    public int modNote(Note note) {
        return noteMapper.modNote(note);
    }

    @Override
    public List<Note> getAllNote() {
        return noteMapper.getAllNote();
    }

    @Override
    public Note getNoteById(int id) {
        return noteMapper.getNoteById(id);
    }

    @Override
    public int delNote(int nid) {
        return noteMapper.delNote(nid);
    }
}
