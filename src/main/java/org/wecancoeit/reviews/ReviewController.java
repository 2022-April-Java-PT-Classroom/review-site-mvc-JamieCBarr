package org.wecancoeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {

    @RequestMapping("/reviews")
    public String findAllReviews(){
        return "reviewsTemplate";
    }
}
