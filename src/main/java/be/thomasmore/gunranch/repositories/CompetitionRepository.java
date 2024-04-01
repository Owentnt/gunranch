package be.thomasmore.gunranch.repositories;

import be.thomasmore.gunranch.model.Competitions;
import be.thomasmore.gunranch.model.Guns;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CompetitionRepository extends CrudRepository<Competitions,Integer> {

    Optional<Competitions> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Competitions> findFirstByOrderByIdDesc();

    Optional<Competitions> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Competitions> findFirstByOrderByIdAsc();


    @Query("SELECT comp FROM Competitions comp WHERE" +
            "(:minPrice IS NULL OR :minPrice <= comp.participationPrice) AND " + " (:maxPrice IS NULL OR comp.participationPrice <= :maxPrice)")
    List<Competitions> findByPriceBetween(@Param("minPrice") Integer minPrice,
                                  @Param("maxPrice") Integer maxPrice);

    @Query("select comp from Competitions comp Where :minPrice IS NULL OR :minPrice <= comp.participationPrice")
    List<Competitions> findByPriceGreaterThan(@Param("minPrice") Integer minPrice);

    @Query("select comp from Competitions comp Where :maxPrice IS NULL OR comp.participationPrice <= :maxPrice")
    List<Competitions> findByPriceLessThan(@Param("maxPrice") Integer maxPrice);

    @Query("select comp from Competitions comp where :minPrice IS NULL AND :maxPrice IS NULL")
    List<Competitions> findAll(@Param("maxPrice") Integer maxPrice, @Param("minPrice") Integer minPrice);


    @Query("SELECT comp FROM Competitions comp WHERE" +
            "(:startHour IS NULL OR :startHour <= comp.startingHour) AND " + " (:endHour IS NULL OR comp.endingHour <= :endHour)")
    List<Competitions> findCompetitionsByStartingHourBetween(@Param("startHour") Date startingHour,
                                          @Param("endHour") Date endingHour);

    @Query("select comp from Competitions comp Where :startHour IS NULL OR :startHour <= comp.startingHour")
    List<Competitions> findCompetitionsByStartingHourGreaterThan(@Param("startHour") Date startingHour);

    @Query("select comp from Competitions comp Where :endHour IS NULL OR comp.startingHour <= :endHour")
    List<Competitions> findByCompetitionsByStartingHourLessThan(@Param("endHour") Date endingHour);

    @Query("select comp from Competitions comp where :startHour IS NULL AND :endHour IS NULL")
    List<Competitions> findAll(@Param("endHour") Date endingHour,
                               @Param("startHour") Date startingHour);

    @Query("SELECT comp FROM Competitions comp WHERE" +
            "(:startDate IS NULL OR :startDate <= comp.date) AND " + " (:endDate IS NULL OR comp.date <= :endDate)")
    List<Competitions> findCompetitionsByDateBetween(@Param("startDate") Date startDate,
                                                             @Param("endDate") Date endDate);

    @Query("select comp from Competitions comp Where :startDate IS NULL OR :startDate <= comp.date")
    List<Competitions> findCompetitionsByDateAfter(@Param("startDate") Date startDate);

    @Query("select comp from Competitions comp Where :endDate IS NULL OR comp.date <= :endDate")
    List<Competitions> findByCompetitionsByDateBefore(@Param("endDate") Date endDate);

    @Query("select comp from Competitions comp where :startDate IS NULL AND :endDate IS NULL")
    List<Competitions> findAllByDate(@Param("endDate") Date endDate, @Param("startDate") Date startDate);



    @Query("SELECT comp, COUNT(Participants) FROM Competitions comp JOIN comp.participants p GROUP BY comp")
    List<Competitions> countParticipantsPerCompetition();




    @Query("SELECT comp FROM Competitions comp " +
            "WHERE (:minPrice IS NULL OR comp.participationPrice >= :minPrice) AND " +
            "(:maxPrice IS NULL OR comp.participationPrice <= :maxPrice)AND " +
            "(:startHour IS NULL OR comp.startingHour >= :startHour)AND " +
            "(:endHour IS NULL OR comp.endingHour <= :endHour)AND " +
            "(:startDate IS NULL OR comp.date >= :startDate) AND " +
            "(:endDate IS NULL OR comp.date <= :endDate) AND " +
            "(:allowedGuns IS NULL OR EMPTY(:allowedGuns) OR comp.allowedFirearms IN (:allowedGuns))AND " +
            "(:nrOfPlayers IS NULL OR comp.participants = :nrOfPlayers)AND " +
            "(:keyword IS NULL OR comp.title LIKE CONCAT('%', :keyword, '%'))")
    Iterable<Competitions> findByFilter(@Param("minPrice") Double minPrice,
                                        @Param("maxPrice") Double maxPrice,
                                        @Param("startDate") Date startDate,
                                        @Param("endDate") Date endDate,
                                        @Param("startHour") Date startHour,
                                        @Param("endHour") Date endHour,
                                        @Param("allowedGuns") List<String> allowedGuns,
                                        @Param("nrOfPlayers") int nrOfPlayers,
                                        @Param("keyword") String keyword);
}







