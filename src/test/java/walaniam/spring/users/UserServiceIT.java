package walaniam.spring.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import walaniam.spring.generator.DataGenerator;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceIT {

    @Autowired
    private DataGenerator dataGenerator;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService underTest;

    @Test
    void findUser() {
        List<User> randomUsers = dataGenerator.generateUsers(10);
        userRepository.saveAll(randomUsers);
        userRepository.save(new User(null, "John", "Doe", new Date(10)));
        userRepository.save(new User(null, "John", "Doe", new Date(100000)));
        userRepository.save(new User(null, "John", "Doe", new Date(200000)));

        List<User> users = underTest.findUsers("John", "Doe");
        assertThat(users).hasSize(3);
        assertThat(users.get(0))
            .extracting(User::getDateOfBirth)
            .extracting(Date::getTime)
            .isEqualTo(200000L);
        assertThat(users.get(2))
            .extracting(User::getDateOfBirth)
            .extracting(Date::getTime)
            .isEqualTo(10L);
    }
}