package telran.java58.post.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import telran.java58.post.model.Post;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public interface PostRepository extends MongoRepository<Post, String> {

    Stream<Post> findByAuthorIgnoreCase(String author);

    Stream<Post> findByTagsInIgnoreCase(List<String> tags);

    Stream<Post> findPostsByDateCreatedBetween(LocalDate from, LocalDate to);
}
