package dbteam4.booksale.service;

import dbteam4.booksale.dto.PostDTO;
import dbteam4.booksale.repository.PostMapper;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostMapper postMapper;

    public void savePost(PostDTO postDTO) {
        postMapper.save(postDTO);
    }


}
