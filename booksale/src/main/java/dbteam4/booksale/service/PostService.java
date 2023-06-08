package dbteam4.booksale.service;

import dbteam4.booksale.domain.Post;
import dbteam4.booksale.dto.PostDTO;
import dbteam4.booksale.dto.BookSearchCond;
import dbteam4.booksale.repository.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostMapper postMapper;

    public void savePost(PostDTO postDTO) {
        postMapper.save(postDTO);
    }

    public List<Post> findPostList(BookSearchCond bookSearchCond) {
        List<Post> postList = postMapper.findAll(bookSearchCond);
        return postList;
    }
}
