package dbteam4.booksale.repository;

import dbteam4.booksale.dto.ReviewDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewMapperTest {

    @Autowired
    private ReviewMapper reviewMapper;
    @Test
    void findByPostId() {
        ReviewDTO reviewDTO = reviewMapper.findByPostId(18l);
        System.out.println("reviewDTO = " + reviewDTO);
    }
}