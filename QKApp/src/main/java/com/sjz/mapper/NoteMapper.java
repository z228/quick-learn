package com.sjz.mapper;

import com.sjz.pojo.Note;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoteMapper {

    int addNote(Note note);

    int modNote(Note note);

    List<Note> getAllNote();

    Note getNoteById(int id);

    int delNote(int nid);
}
