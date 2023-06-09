package dbteam4.booksale.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostMapperTest {

    @Autowired
    private PostMapper postMapper;
    @Test
    void findByPostId() {
        postMapper.findByPostId(13L); //상태 좋아요 직거래로 팝니다.
    }
}