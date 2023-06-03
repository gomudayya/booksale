package dbteam4.booksale.service;


import dbteam4.booksale.dto.UserDTO;
import dbteam4.booksale.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    public void save(UserDTO userDTO) {
        userMapper.save(userDTO);
    }
}
