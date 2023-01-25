package com.cisco.task.dto;

import lombok.Data;

import javax.persistence.*;

import java.util.*;

@Entity
@Data
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
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "caseId")
    private List<Note> notes;

    public enum Status {
        OPEN,
        CLOSED
    }
}
