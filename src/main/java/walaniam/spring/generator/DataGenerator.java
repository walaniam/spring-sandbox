package walaniam.spring.generator;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import walaniam.spring.users.User;

import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class DataGenerator {

    private final Faker faker;

    public List<User> generateUsers(int count) {
        return IntStream.range(0, count)
            .mapToObj(i -> {
                Name name = faker.name();
                Date dob = faker.date().birthday();
                return User.builder()
                    .firstName(name.firstName())
                    .lastName(name.lastName())
                    .dateOfBirth(dob)
                    .build();
            })
            .toList();
    }
}
