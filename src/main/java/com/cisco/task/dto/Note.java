package com.cisco.task.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
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
}