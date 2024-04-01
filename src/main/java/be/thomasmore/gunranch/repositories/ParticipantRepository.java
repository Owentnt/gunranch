package be.thomasmore.gunranch.repositories;

import be.thomasmore.gunranch.model.Participants;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends CrudRepository<Participants,Integer> {
}
