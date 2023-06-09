package dbteam4.booksale.service;

import dbteam4.booksale.dto.ReviewDTO;
import dbteam4.booksale.repository.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewMapper reviewMapper;

    public void saveReview(ReviewDTO reviewDTO) {reviewMapper.save(reviewDTO);}

    public ReviewDTO findByPostId(Long postId) {
        return reviewMapper.findByPostId(postId);
    }
}
