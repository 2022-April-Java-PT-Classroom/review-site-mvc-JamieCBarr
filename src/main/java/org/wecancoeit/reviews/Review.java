package org.wecancoeit.reviews;

import javax.persistence.Entity;

public class Review {

    private Long id;
    private String title;
    private String imageURL;
    private String reviewCategory;
    private String content;

    public Review(Long id, String title, String imageURL, String reviewCategory, String content) {
        this.id = id;
        this.title = title;
        this.imageURL = imageURL;
        this.reviewCategory = reviewCategory;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getReviewCategory() {
        return reviewCategory;
    }

    public String getContent() {
        return content;
    }
}
