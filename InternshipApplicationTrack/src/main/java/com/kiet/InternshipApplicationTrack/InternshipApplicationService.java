package com.kiet.InternshipApplicationTrack;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternshipApplicationService {

    private final InternshipApplicationRepository repository;

    public InternshipApplicationService(InternshipApplicationRepository repository) {
        this.repository = repository;
    }

    public List<InternshipApplication> getAllApplications() {
        return repository.findAll();
    }

    public InternshipApplication getApplicationById(int id) {
        Optional<InternshipApplication> result = repository.findById(id);
        return result.orElse(null);
    }

    public List<InternshipApplication> getApplicationsByStatus(String status) {
        return repository.findByStatus(status);
    }

    public InternshipApplication saveOrUpdate(InternshipApplication app) {
        return repository.save(app);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
