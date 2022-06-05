package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Collection;

@WebMvcTest(ReviewController.class)
public class ReviewControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewRepository reviewRepo;

    @Mock
    private Review review1 = new Review(1L, "title1", "imageURL1", "reviewCategory1", "content1");
    private Long review1Id = 1L;

    @Mock
    private Review review2 = new Review(2L, "title2", "imageURL2", "reviewCategory2", "content2");

    @Test
    public void shouldBeOkForAllReviewsInTheReviewsTemplate() throws Exception{
        mockMvc.perform(get("/reviews")).andExpect(status().isOk())
                .andExpect(view().name("reviewsTemplate"));
    }

    @Test
    public void shouldFindAllReviewsInModel() throws Exception{
        Collection<Review> allReviewsInModel = Arrays.asList(review1, review2);
        when(reviewRepo.findAll()).thenReturn(allReviewsInModel);
        mockMvc.perform(get("/reviews")).andExpect(model().attribute("reviewsModel", allReviewsInModel));
    }

    @Test
    public void shouldBeOkForOneReviewInTheReviewTemplate() throws Exception{
        when(reviewRepo.findOne(review1Id)).thenReturn(review1);
        mockMvc.perform(get("/review?id=1")).andExpect(status().isOk())
                .andExpect(view().name("reviewTemplate"));
    }

    @Test
    public void shouldFindReview1InModel() throws Exception{
        when(reviewRepo.findOne(review1Id)).thenReturn(review1);
        mockMvc.perform(get("/review?id=1")).andExpect(model().attribute("reviewModel", review1));
    }

    @Test
    public void shouldBeNotFoundForRequestNotInModel() throws Exception{
        mockMvc.perform(get("/review?id=3")).andExpect(status().isNotFound());
    }
}
