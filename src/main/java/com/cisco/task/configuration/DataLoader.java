package com.cisco.task.configuration;

import com.cisco.task.dto.Case;
import com.cisco.task.dto.Note;
import com.cisco.task.dto.User;
import com.cisco.task.repository.CaseRepository;
import com.cisco.task.repository.NoteRepository;
import com.cisco.task.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private CaseRepository caseRepository;
    private UserRepository userRepository;
    private NoteRepository noteRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User("test", "test", "test@mail.ru");
        userRepository.save(user);
        Note note = new Note(3, "D4");
        noteRepository.save(note);
        caseRepository.save(new Case("title", "description", 3, Case.Status.OPEN, user, List.of(note)));
    }
}
