package com.sedef.notes.Businnes;

import com.sedef.notes.Dto.CategoryRequest;
import com.sedef.notes.Model.Category;
import com.sedef.notes.Model.User;
import com.sedef.notes.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserService userService;

    public Category add(CategoryRequest request) {
        User user = userService.getbyId(request.getUserId());
        Category category = new Category();
        category.setName(request.getName());
        category.setUser(user);
        return categoryRepository.save(category); // Veritabanına kaydediyoruz
    }

    public void delete(int categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new RuntimeException("Category not found");
        }
        categoryRepository.deleteById(categoryId);
    }

    public List<Category> getByUserId(int userId) {
        return categoryRepository.findByUserId(userId);
    }

    public Category getById(int categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found")); // Hata yönetimi burada yapılır
    }
}
