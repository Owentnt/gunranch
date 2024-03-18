package be.thomasmore.gunranch.repositorys;

import be.thomasmore.gunranch.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Integer> {

}
