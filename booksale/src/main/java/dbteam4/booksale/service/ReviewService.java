package dbteam4.booksale.service;

import dbteam4.booksale.dto.ReviewDTO;
import dbteam4.booksale.repository.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewMapper reviewMapper;

    public void saveReview(ReviewDTO reviewDTO) {
        ReviewDTO findReview = findByPostId(reviewDTO.getPostId());
        if (findReview == null) { // review - post 는 1:1 관계.
            reviewMapper.save(reviewDTO);
        }
    }

    public ReviewDTO findByPostId(Long postId) {
        return reviewMapper.findByPostId(postId);
    }

    public List<ReviewDTO> findBySellerId(Long sellerId) {
        return reviewMapper.findBySellerId(sellerId);
    }
}
