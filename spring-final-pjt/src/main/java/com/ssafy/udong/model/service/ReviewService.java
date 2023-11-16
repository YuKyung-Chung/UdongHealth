package com.ssafy.udong.model.service;

import java.util.List;
import com.ssafy.udong.model.dto.Review;

public interface ReviewService {

	List<Review> getReviews(int placeId);

	Review getReview(int reviewId);

	void writeReview(Review review);

	boolean removeReview(int reviewId);

	boolean modifyReview(Review review);
	
}
