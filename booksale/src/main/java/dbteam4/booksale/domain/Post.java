package dbteam4.booksale.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Post {
    private Long postId;
    private String bookISBN;
    private String sellerId;
    private LocalDateTime postTime;
    private String postContent;
    private String salesMethod;
    private String shippingMethod;
    private String book_quality;
}
