package com.cisco.task.service;

import com.cisco.task.dto.Case;
import com.cisco.task.dto.User;
import com.cisco.task.repository.CaseRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class CaseService {

    private CaseRepository caseRepository;
    private UserService userService;

    public Case getById(Integer caseId) {
        Optional<Case> optionalCase = caseRepository.findById(caseId);
        log.info("For caseId={} found case={}", caseId, optionalCase.orElse(null));
        return optionalCase.orElse(null);
    }

    public List<Case> getByStatus(Case.Status status) {
        List<Case> cases = caseRepository.findByStatus(status);
        log.info("For status={} found {} cases", status, cases.size());
        return cases;
    }

    public List<Case> getByUser(User user) {
        List<Case> cases = caseRepository.findByUser(user);
        log.info("For userId={} found {} cases", user.getUserId(), cases.size());
        return cases;
    }

    public List<Case> getByUserAndStatus(User user, Case.Status status) {
        List<Case> cases = caseRepository.findByUserAndStatus(user, status);
        log.info("For userId={} and status={} found {} cases", user.getUserId(), status, cases.size());
        return cases;
    }

    public Case save(Case toCreate) {
        toCreate.setUser(userService.save(toCreate.getUser()));
        Case savedCase = caseRepository.save(toCreate);
        log.info("Case with caseId={} saved", savedCase.getCaseId());
        return savedCase;
    }

}
