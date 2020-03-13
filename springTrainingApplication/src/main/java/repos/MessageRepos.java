package repos;

import domain.Message;
import domain.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan("domain")
public interface MessageRepos extends CrudRepository<Message, Integer> {
    List<Message> findByTag(String tag);
    List<Message> findByAuthor(User user);
}
