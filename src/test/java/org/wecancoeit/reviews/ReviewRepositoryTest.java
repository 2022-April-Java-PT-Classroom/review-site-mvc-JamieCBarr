package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewRepositoryTest {

    @Test
    public void shouldFindReview1(){
        Review review1 = new Review(1L, "title", "imageURL", "reviewCategory", "content");
        ReviewRepository underTest = new ReviewRepository(review1);
        Review foundReview = underTest.findOne(1L);
        assertEquals(review1, foundReview);
    }
}
