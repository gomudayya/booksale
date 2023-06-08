package dbteam4.booksale.repository;

import dbteam4.booksale.domain.Post;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {

    Post findByPostId(Long postId);


}
