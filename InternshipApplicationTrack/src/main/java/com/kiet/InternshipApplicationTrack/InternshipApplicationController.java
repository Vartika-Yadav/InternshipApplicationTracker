package com.kiet.InternshipApplicationTrack;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@RestController
@RequestMapping("/api")
public class InternshipApplicationController {


    private final InternshipApplicationService service;

    public InternshipApplicationController(InternshipApplicationService service) {
        this.service = service;
    }

    @GetMapping("/applications")
    public List<InternshipApplication> getAllApplications() {
        return service.getAllApplications();
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<InternshipApplication> getApplicationById(@PathVariable int id) {
        InternshipApplication app = service.getApplicationById(id);
        if (app == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(app);
    }

    @GetMapping("/applications/status/{status}")
    public List<InternshipApplication> getApplicationsByStatus(@PathVariable String status) {
        return service.getApplicationsByStatus(status);
    }

    @PostMapping("/application")
    public ResponseEntity<InternshipApplication> addApplication(@RequestBody InternshipApplication app) {
        InternshipApplication savedApp = service.saveOrUpdate(app);
        return new ResponseEntity<>(savedApp, HttpStatus.CREATED);
    }

    @PutMapping("/application/{id}")
    public ResponseEntity<InternshipApplication> updateApplication(@PathVariable int id,
                                                                   @RequestBody InternshipApplication app) {
        InternshipApplication existingApp = service.getApplicationById(id);
        if (existingApp == null) {
            return ResponseEntity.notFound().build();
        }
        app.setId(id);
        InternshipApplication updatedApp = service.saveOrUpdate(app);
        return ResponseEntity.ok(updatedApp);
    }

    @DeleteMapping("/application/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable int id) {
        InternshipApplication existingApp = service.getApplicationById(id);
        if (existingApp == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
