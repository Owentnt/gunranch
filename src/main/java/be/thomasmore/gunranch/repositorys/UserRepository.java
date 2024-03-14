package be.thomasmore.gunranch.repositorys;

import be.thomasmore.gunranch.model.Login;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Login,Integer> {

}
