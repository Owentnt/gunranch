package be.thomasmore.gunranch.repositorys;

import be.thomasmore.gunranch.model.Competitions;
import be.thomasmore.gunranch.model.Guns;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompetitionRepository extends CrudRepository<Competitions,Integer> {

    Optional<Competitions> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Competitions> findFirstByOrderByIdDesc();

    Optional<Competitions> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Competitions> findFirstByOrderByIdAsc();
}
