package com.cisco.task.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer noteId;
    private Integer caseId;
    private String details;

    public Note(Integer caseId, String details) {
        this.caseId = caseId;
        this.details = details;
    }

    public Note() {
    }
}