package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Collection;

public class ReviewRepositoryTest {

    private ReviewRepository underTest;
    private Review review1 = new Review(1L, "title1", "imageURL1", "reviewCategory1", "content1");
    private Review review2 = new Review(2L, "title2", "imageURL2", "reviewCategory2", "content2");

    @Test
    public void shouldFindReview1() {
        underTest = new ReviewRepository(review1);
        Review foundReview = underTest.findOne(1L);
        assertEquals(review1, foundReview);
    }

    @Test
    public void shouldFindReview1AndReview2() {
        underTest = new ReviewRepository(review1, review2);
        Collection<Review> foundReviews = underTest.findAll();
        assertThat(foundReviews).contains(review1, review2);
    }

}
