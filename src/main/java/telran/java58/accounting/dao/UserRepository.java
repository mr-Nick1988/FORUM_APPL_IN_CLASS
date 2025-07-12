package telran.java58.accounting.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import telran.java58.accounting.model.User;

public interface UserRepository extends MongoRepository<User, String> {
}
