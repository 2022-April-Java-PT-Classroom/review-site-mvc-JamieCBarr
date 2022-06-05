package org.wecancoeit.reviews;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ReviewRepository {

    Map<Long, Review> reviewsList = new HashMap<>();

    //constructor for database
    public ReviewRepository(){
        Review review1 = new Review(1L, "title", "test1.jpg", "category", "content");

        reviewsList.put(review1.getId(), review1);
    }

    //testing constructor
    public ReviewRepository(Review...reviewsToAdd) {
        for (Review reviewToAdd : reviewsToAdd) {
            reviewsList.put(reviewToAdd.getId(), reviewToAdd);
        }
    }

    public Review findOne(long id) {
        return reviewsList.get(id);
    }

    public Collection<Review> findAll() {
        return reviewsList.values();
    }
}
