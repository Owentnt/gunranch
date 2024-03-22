package be.thomasmore.gunranch.repositorys;

import be.thomasmore.gunranch.model.Members;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Members,Integer> {

}
