package be.thomasmore.gunranch.repositories;

import be.thomasmore.gunranch.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation,Long> {

}
