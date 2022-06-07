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
        Review review1 = new Review(1L, "Gloom", "gloomImg.jpg", "Card Game", 
        "Gloom is an entertaining, casual card game for up to 5 players. It is strongly themed in dark humor " + 
        "with the objective being to take your small family of misfit characters and make them as miserable " + 
        "as possible before they ultimately die. The see-through card design is both beautiful and brilliant," + 
        "enabling the core mechanic of card stacking to change the effects of cards underneath. There is a drawback " + 
        "to this element, however, as it is easy to see what types of cards the other players are holding. " + 
        "This doesn't stop it from being a fun game, but it does limit how competitively it can be approached.\n\n" + 
        "Image: \"Gloom. #gloom #game #cards\" by Moses Noghbaudie is licensed under CC BY-NC-SA 2.0.");

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
