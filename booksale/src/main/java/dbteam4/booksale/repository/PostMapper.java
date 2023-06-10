package dbteam4.booksale.repository;

import dbteam4.booksale.domain.Post;
import dbteam4.booksale.dto.PostBookDTO;
import dbteam4.booksale.dto.PostDTO;
import dbteam4.booksale.dto.BookSearchCond;
import dbteam4.booksale.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    void save(PostDTO postDTO);
    PostBookDTO findByPostId(Long postId);

    List<PostBookDTO> findRecentPost(int recentNum);
    List<PostBookDTO> findAll(BookSearchCond bookSearchCond);
}
