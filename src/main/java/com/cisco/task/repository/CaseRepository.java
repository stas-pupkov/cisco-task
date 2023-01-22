package com.cisco.task.repository;

import com.cisco.task.dto.Case;
import com.cisco.task.dto.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseRepository extends CrudRepository<Case, Integer> {

    List<Case> findByStatus(Case.Status status);
    List<Case> findByUser(User user);
    List<Case> findByUserAndStatus(User user, Case.Status status);
}
