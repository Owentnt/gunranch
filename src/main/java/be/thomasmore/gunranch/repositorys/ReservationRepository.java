package be.thomasmore.gunranch.repositorys;

import be.thomasmore.gunranch.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation,Integer> {

}
