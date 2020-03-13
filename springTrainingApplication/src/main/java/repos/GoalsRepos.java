package repos;

import domain.Goals;
import domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoalsRepos extends CrudRepository<Goals, Integer>
{
    List<Goals> findByUser(User user);
}
