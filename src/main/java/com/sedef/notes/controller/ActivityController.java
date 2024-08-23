package com.sedef.notes.controller;

import com.sedef.notes.Businnes.ActivityService;
import com.sedef.notes.mapper.Dto.ActivityRequest;
import com.sedef.notes.Model.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping("/start")
    public ResponseEntity<Activity> startActivity(@RequestBody ActivityRequest request) {
        Activity activity = activityService.start(request);
        return ResponseEntity.ok(activity);
    }

    @PostMapping("/{activityId}/end")
    public ResponseEntity<String> endActivity(@PathVariable int activityId) {
        String duration = activityService.end(activityId);
        return ResponseEntity.ok(duration);
    }

    @PatchMapping("/{activityId}/header")
    public ResponseEntity<Activity> updateHeader(@PathVariable int activityId, @RequestParam String newHeader) {
        Activity activity = activityService.updateHeader(activityId, newHeader);
        return ResponseEntity.ok(activity);
    }

    @PatchMapping("/{activityId}/description")
    public ResponseEntity<Activity> updateDescription(@PathVariable int activityId, @RequestParam String newDescription) {
        Activity activity = activityService.updateDescription(activityId, newDescription);
        return ResponseEntity.ok(activity);
    }

    @PatchMapping("/{activityId}/category")
    public ResponseEntity<Activity> updateCategory(@PathVariable int activityId, @RequestParam int newCategoryId) {
        Activity activity = activityService.updateCategory(activityId, newCategoryId);
        return ResponseEntity.ok(activity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activity> getById(@PathVariable int id) {
        return ResponseEntity.ok(activityService.getById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Activity>> getListByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(activityService.getActivityListByUserID(userId));
    }
}
