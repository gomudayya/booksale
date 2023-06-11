package dbteam4.booksale.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class User {
    private Long id;
    private String userName;
    private String phoneNumber;
    private String userID;
    private String userPassword;
    private String university;
    private String department; // 학과
}
