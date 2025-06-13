package com.kiet.InternshipApplicationTrack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternshipApplicationRepository extends JpaRepository<InternshipApplication, Integer> {
    List<InternshipApplication> findByStatus(String status);
}
