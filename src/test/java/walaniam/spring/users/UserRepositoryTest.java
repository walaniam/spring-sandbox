package walaniam.spring.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import walaniam.spring.generator.DataGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DataGenerator dataGenerator;

    @Test
    void shouldSaveAndReadUsers() {
        List<User> generatedUsers = dataGenerator.generateUsers(20);
        assertThat(userRepository.count()).isEqualTo(0);
        userRepository.saveAll(generatedUsers);
        assertThat(userRepository.count()).isEqualTo(20);
    }
}
