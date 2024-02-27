package walaniam.spring.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findUsers(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastNameOrderByDateOfBirthDesc(firstName, lastName);
    }
}
