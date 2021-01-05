package com.hyuseinmustafa.spring5recipeproject.repositories;

import com.hyuseinmustafa.spring5recipeproject.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
