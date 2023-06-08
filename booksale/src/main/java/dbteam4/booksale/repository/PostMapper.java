package dbteam4.booksale.repository;

import dbteam4.booksale.domain.Post;
import dbteam4.booksale.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {

    void save(PostDTO postDTO);
    Post findByPostId(Long postId);

}
