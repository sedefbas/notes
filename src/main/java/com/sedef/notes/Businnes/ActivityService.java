package com.sedef.notes.Businnes;
import com.sedef.notes.Model.Activity;
import com.sedef.notes.Model.Category;
import com.sedef.notes.Model.User;
import com.sedef.notes.mapper.Dto.ActivityRequest;
import com.sedef.notes.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final CategoryService categoryService;
    private final UserService userService;

    public Activity start(ActivityRequest request) {
       User user = userService.getbyId(request.getUserId());
        Category category = categoryService.getById(request.getCategoryId());
        Activity activity = new Activity();
        activity.setHeader(request.getHeader());
        activity.setCategory(category);
        activity.setDescription(null);
        activity.setStartTime(LocalDateTime.now());
        activity.setEndTime(null);
        activity.setDuration(null);
        activity.setDate(LocalDate.now());
        activity.setUser(user);
        return activityRepository.save(activity);
    }

    public String end(int activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        activity.setEndTime(LocalDateTime.now()); // Aktivite bitiş zamanını ayarla
        activity.setDuration(calculateDurationInMinutes(activity.getStartTime(), activity.getEndTime())); // Süreyi hesapla

        activityRepository.save(activity); // Güncellenmiş aktiviteyi kaydet

        return "Activity duration: " + activity.getDuration() + " minutes";
    }

    private Long calculateDurationInMinutes(LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime == null || endTime == null) {
            throw new IllegalArgumentException("Start time and end time must not be null");
        }
        Duration duration = Duration.between(startTime, endTime);
        return duration.toMinutes(); // Süreyi dakikaya çevir
    }

    public Activity updateHeader(int activityId, String newHeader) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        activity.setHeader(newHeader);
        return activityRepository.save(activity);
    }

    public Activity updateDescription(int activityId, String newDescription) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        activity.setDescription(newDescription);

        return activityRepository.save(activity);
    }

    public Activity updateCategory(int activityId, int newCategoryId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        Category newCategory = categoryService.getById(newCategoryId);
        activity.setCategory(newCategory);
        return activityRepository.save(activity);
    }


    public Activity getById(int id){
       Optional<Activity> activityOp =  activityRepository.findById(id);
        return activityOp.get();
    }

    public List<Activity> getActivityListByUserID(int userId){
        return  activityRepository.findByUserId(userId);
    }

}
