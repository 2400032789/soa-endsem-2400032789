package com.klef.soa.exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.klef.soa.exam.entity.VolunteerActivity;
import com.klef.soa.exam.repository.VolunteerActivityRepository;

@Service
@Transactional
public class VolunteerActivityService {

    private final VolunteerActivityRepository repository;

    public VolunteerActivityService(
            VolunteerActivityRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<VolunteerActivity> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<VolunteerActivity> findById(Long id) {
        return repository.findById(id);
    }

    public VolunteerActivity create(VolunteerActivity activity) {
        activity.setId(null);
        return repository.save(activity);
    }

    public Optional<VolunteerActivity> update(
            Long id, VolunteerActivity changes) {

        return repository.findById(id).map(activity -> {

            activity.setActivityName(changes.getActivityName());

            activity.setOrganizerName(changes.getOrganizerName());

            activity.setVolunteerCount(changes.getVolunteerCount());

            activity.setActive(changes.getActive());

            return repository.save(activity);
        });
    }

    public boolean delete(Long id) {

        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);

        return true;
    }
}