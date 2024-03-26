package be.thomasmore.gunranch.repositorys;

import be.thomasmore.gunranch.model.Competitions;
import be.thomasmore.gunranch.model.Guns;
import be.thomasmore.gunranch.model.Participants;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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

    @Query("select comp from Competitions comp Where :endHour IS NULL OR comp.participationPrice <= :endHour")
    List<Competitions> findByCompetitionsByStartingHourLessThan(@Param("endHour") Date endingHour);

    @Query("select comp from Competitions comp where :startHour IS NULL AND :endHour IS NULL")
    List<Competitions> findAll(@Param("endHour") Date endingHour, @Param("startHour") Date startingHour);

    @Query("SELECT comp, COUNT(Participants ) FROM Competitions comp JOIN comp.participants p GROUP BY comp")
    List<Competitions> countParticipantsPerCompetition();


//    @Query("SELECT comp from Competitions comp WHERE " +
//            "(:minMagaz IS NULL OR :minMagazine <= g.magazine) AND " +
//            "(:maxMagazine IS NULL OR g.magazine <= :maxMagazine) AND " +
//            "(:minPrice IS NULL OR :minPrice <= g.price) AND " +
//            "(:maxPrice IS NULL OR g.price <= :maxPrice) AND " +
//            "(:caliber IS NULL OR g.caliber = :caliber) AND " +
//            "(:gunType IS NULL OR g.gunType = :gunType) AND " +
//            "(:firearmsType IS NULL OR g.firearmsType = :firearmsType)")

//    Iterable<Guns> findByFilter(
//            @Param("minMagazine") Integer minMagazine,
//            @Param("maxMagazine") Integer maxMagazine,
//            @Param("minPrice") Integer minPrice,
//            @Param("maxPrice") Integer maxPrice,
//            @Param("caliber")String caliber,
//            @Param("gunType") String gunType,
//            @Param("firearmsType") String firearmsType);




}

