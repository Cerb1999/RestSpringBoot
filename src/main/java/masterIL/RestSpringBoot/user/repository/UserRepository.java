package masterIL.RestSpringBoot.user.repository;

import masterIL.RestSpringBoot.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAll();

    List<User> findAllByLastname(String lastname);

    User findUserById(String id);
    void deleteById(String id);
}