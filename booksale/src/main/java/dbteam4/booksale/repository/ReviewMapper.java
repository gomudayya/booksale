package dbteam4.booksale.repository;

import dbteam4.booksale.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
    void save(ReviewDTO reviewDTO);

    ReviewDTO findByPostId(Long postId);
}
