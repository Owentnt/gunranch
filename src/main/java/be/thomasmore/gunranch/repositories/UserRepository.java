package be.thomasmore.gunranch.repositories;

import be.thomasmore.gunranch.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Users,Integer> {

   Optional<Users> findByUsername(String username);

   @Query("SELECT SUM(gp.price) FROM Reservation b JOIN b.gunsPackage gp WHERE b.id = :bookingId")
   Double calculateTotalPriceByBookingId(@Param("bookingId") Long bookingId);

}
