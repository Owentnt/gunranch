package be.thomasmore.gunranch.repositorys;

import be.thomasmore.gunranch.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

}
