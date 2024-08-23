package com.sedef.notes.repository;

import com.sedef.notes.Model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {
    List<Activity> findByUserId(int userId);
}
