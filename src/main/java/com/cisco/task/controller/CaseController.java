package com.cisco.task.controller;

import com.cisco.task.dto.Case;
import com.cisco.task.dto.Note;
import com.cisco.task.dto.User;
import com.cisco.task.service.CaseService;
import com.cisco.task.service.NoteService;
import com.cisco.task.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CaseController {

    private CaseService caseService;
    private UserService userService;
    private NoteService noteService;

    @GetMapping("/cases/status/{status}")
    List<Case> getCasesWithStatus(@PathVariable Case.Status status) {
        return caseService.getCasesByStatus(status);
    }

    @GetMapping("/cases/user/{userId}")
    List<Case> getOpenCases(@PathVariable Integer userId) {
        User user = userService.getById(userId);
        List<Case> cases = caseService.getCasesByUser(user);
        return cases;
    }

    @GetMapping("/cases/user/{userId}/status/{status}")
    List<Case> getOpenCases(@PathVariable Integer userId, @PathVariable Case.Status status) {
        User user = userService.getById(userId);
        List<Case> cases = caseService.getCasesByUserAndStatus(user, status);
        return cases;
    }

    @GetMapping("/case/{caseId}")
    Case getCase(@PathVariable Integer caseId) {
        return caseService.getCaseById(caseId);
    }

    @PostMapping(value = "/case/create", consumes = "application/json")
    Case createCase(@RequestBody Case toCreate) {
        return caseService.saveCase(toCreate);
    }

    @PostMapping(value = "/case/{caseId}/addNote", consumes = "text/plain")
    Note addNote(@PathVariable Integer caseId, @RequestBody String detail) {
        Note newNote = new Note(caseId, detail);
        return noteService.saveNote(newNote);
    }
}
