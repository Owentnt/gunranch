package be.thomasmore.gunranch.repositories;

import be.thomasmore.gunranch.model.Guns;
import be.thomasmore.gunranch.model.Reservation;
import be.thomasmore.gunranch.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation,Long> {


    Iterable<Reservation> findByUsers(Users user);
}
