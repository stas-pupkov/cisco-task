package com.cisco.task.service;

import com.cisco.task.dto.Note;
import com.cisco.task.repository.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class NoteService {

    private NoteRepository noteRepository;

    public Note saveNote(Note toCreate) {
        Note savedNote = noteRepository.save(toCreate);
        log.info("Note with noteId={} saved", savedNote.getNoteId());
        return savedNote;
    }

}
