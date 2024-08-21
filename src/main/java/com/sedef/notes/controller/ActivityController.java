package com.sedef.notes.controller;

import com.sedef.notes.Businnes.ActivityService;
import com.sedef.notes.Dto.ActivityRequest;
import com.sedef.notes.Model.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activity")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping("/start")
    public ResponseEntity<Activity> startActivity(@RequestBody ActivityRequest request) {
        Activity activity = activityService.start(request);
        return ResponseEntity.ok(activity);
    }

    @PostMapping("/end/{activityId}")
    public ResponseEntity<String> endActivity(@PathVariable int activityId) {
        String duration = activityService.end(activityId);
        return ResponseEntity.ok(duration);
    }

    @PatchMapping("/update/header/{activityId}")
    public ResponseEntity<Activity> updateHeader(@PathVariable int activityId, @RequestParam String newHeader) {
        Activity activity = activityService.updateHeader(activityId, newHeader);
        return ResponseEntity.ok(activity);
    }

    @PatchMapping("/update/description/{activityId}")
    public ResponseEntity<Activity> updateDescription(@PathVariable int activityId, @RequestParam String newDescription) {
        Activity activity = activityService.updateDescription(activityId, newDescription);
        return ResponseEntity.ok(activity);
    }

    @PatchMapping("/update/category/{activityId}")
    public ResponseEntity<Activity> updateCategory(@PathVariable int activityId, @RequestParam int newCategoryId) {
        Activity activity = activityService.updateCategory(activityId, newCategoryId);
        return ResponseEntity.ok(activity);
    }
}
