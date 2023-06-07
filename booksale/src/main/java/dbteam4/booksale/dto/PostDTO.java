package dbteam4.booksale.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostDTO {
    private Long postId;
    private String bookISBN;
    private Long sellerId;
    //private
    private String title;
    private String postContent;
    private String salesMethod;
    private String shippingMethod;
    private String bookQuality;

}
