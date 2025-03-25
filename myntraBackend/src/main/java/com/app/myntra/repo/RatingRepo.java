package com.app.myntra.repo;

import com.app.myntra.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepo extends JpaRepository<Rating,Integer> {
}
