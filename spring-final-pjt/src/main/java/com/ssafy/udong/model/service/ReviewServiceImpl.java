package com.ssafy.udong.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.udong.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Override
	public List<Review> getReviews(int placeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review getReview(int reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeReview(Review review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeReview(int reviewId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyReview(Review review) {
		// TODO Auto-generated method stub
		return false;
	}

}
