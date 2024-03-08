package be.thomasmore.gunranch.repositorys;

import be.thomasmore.gunranch.model.Participants;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends CrudRepository<Participants,Integer> {
}
