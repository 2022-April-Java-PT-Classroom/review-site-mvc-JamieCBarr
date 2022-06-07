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

        Review review2 = new Review(2L, "Eldritch Horror", "eldritchHorrorImg.jpg", "Board Game",
        "Eldritch Horror is a complex, cooperative board game. You select a team of psychics, warriors, and spies " + 
        "to hunt down one of several monstrous creatures including Cthulhu itself. This game is quite the undertaking, " + 
        "so be sure to set aside a whole evening to complete all three phases of the game. Despite the daunting appearance " + 
        "of over a dozen different decks of cards and nearly as many types of counters, the core mechanics are easy to grasp " + 
        "and play will quickly begin to flow along smoothly; most of the games complexity is dedicated to intricate " + 
        "storytelling rather than rules. With that said, while playing the game isn't too difficult, winning it certainly " + 
        "isn't easy. Be very prepared for your characters to die, and to have fun along the way.");

        reviewsList.put(review2.getId(), review2);
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
