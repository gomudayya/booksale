package dbteam4.booksale.service;


import dbteam4.booksale.domain.User;
import dbteam4.booksale.dto.RegisterDTO;
import dbteam4.booksale.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    public void save(RegisterDTO registerDTO) {
        userMapper.save(registerDTO);
    }



    /***
     * @return이 null이면 로그인 실패
     */

    public User login(String loginID, String password) {

        User user = userMapper.findByLoginID(loginID);

        if (user == null) {
            return null;
        }
        if (user.getUserPassword().equals(password)) {
            return user; // 로그인 성공
        } else {
            return null;
        }
    }

}
