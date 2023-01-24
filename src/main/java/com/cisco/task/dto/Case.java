package com.cisco.task.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer caseId;
    private String title;
    private String description;
    private Integer severity;
    private Status status;
    @OneToOne
    private User user;
    @OneToMany
    private List<Note> notes;

    public enum Status {
        OPEN,
        CLOSED
    }

    public Case(String title, String description, Integer severity, Status status, User user, List<Note> notes) {
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.status = status;
        this.user = user;
        this.notes = notes;
    }
}
