package dbteam4.booksale.repository;

import dbteam4.booksale.domain.Post;
import dbteam4.booksale.dto.PostDTO;
import dbteam4.booksale.dto.BookSearchCond;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    void save(PostDTO postDTO);
    Post findByPostId(Long postId);

    List<Post> findAll(BookSearchCond bookSearchCond);
}
