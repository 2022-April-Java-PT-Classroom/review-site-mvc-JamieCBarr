package org.wecancoeit.reviews;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ReviewRepository {

    Map<Long, Review> reviewsList = new HashMap<>();

    public ReviewRepository(Review reviewToAdd) {
        reviewsList.put(reviewToAdd.getId(), reviewToAdd);
    }

    public Review findOne(long id) {
        return reviewsList.get(id);
    }
}
