package com.example.ratingservice.service;

import com.example.ratingservice.model.Rating;
import com.example.ratingservice.repository.RatingRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    public Integer getUserRating(String username) {
        Rating rating = ratingRepository.findByUsername(username);
        if(rating == null) {
            rating = new Rating();
            rating.setStars(75);
            rating.setUsername(username);
            ratingRepository.save(rating);
        }
        return rating.getStars();
    }
}
