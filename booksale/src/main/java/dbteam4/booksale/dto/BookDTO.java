package dbteam4.booksale.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@Getter @Setter
@ToString
public class BookDTO {
    private String title;
    private String link;
    private String image;
    private String author;
    private int discount;
    private String publisher;
    private String pubdate;
    private String isbn;
    private String description;
}
