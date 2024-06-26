package be.thomasmore.gunranch.repositories;

import be.thomasmore.gunranch.model.Guns;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GunsRepository extends CrudRepository<Guns, Integer> {

    //Iterable<Guns> findByType(String type);

    Iterable<Guns> findByPriceLessThan(double max);

    Iterable<Guns> findByPriceBetween(double min, double max);

    Iterable<Guns> findByPriceGreaterThan(double min);

    Iterable<Guns> findByCaliber(String caliber);

    Optional<Guns> findFirstByOrderByIdDesc();

    Optional<Guns> findFirstByOrderByIdAsc();

    Optional<Guns> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Guns> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    @Query("SELECT g FROM Guns g WHERE" +
            "(:minMagazine IS NULL OR :minMagazine <= g.magazine) AND " + " (:maxMagazine IS NULL OR g.magazine <= :maxMagazine)")
    List<Guns> findByMagazineBetween(@Param("minMagazine") Integer minMagazine,
                                      @Param("maxMagazine") Integer maxMagazine);

    @Query("select g from Guns g Where :minMagazine IS NULL OR :minMagazine <= g.magazine")
    List<Guns> findByMagazineGreaterThan(@Param("minMagazine") Integer minMagazine);

    @Query("select g from Guns g Where :maxMagazine IS NULL OR g.magazine <= :maxMagazine")
    List<Guns> findByMagazineLessThan(@Param("maxMagazine") Integer maxMagazine);

    @Query("select g from Guns g where :minMagazine IS NULL AND :maxMagazine IS NULL")
    List<Guns> findAllBy(@Param("maxMagazine") Integer maxMagazine, @Param("minMagazine") Integer minMagazine);

    @Query("SELECT g FROM Guns g WHERE" +
            "(:minPrice IS NULL OR :minPrice <= g.price) AND " + " (:maxPrice IS NULL OR g.price <= :maxPrice)")
    List<Guns> findByPriceBetween(@Param("minPrice") Integer minPrice,
                                     @Param("maxPrice") Integer maxPrice);

    @Query("select g from Guns g Where :minPrice IS NULL OR :minPrice <= g.magazine")
    List<Guns> findByPriceGreaterThan(@Param("minPrice") Integer minPrice);

    @Query("select g from Guns g Where :maxPrice IS NULL OR g.magazine <= :maxPrice")
    List<Guns> findByPriceLessThan(@Param("maxPrice") Integer maxPrice);

    @Query("select g from Guns g where :minPrice IS NULL AND :maxPrice IS NULL")
    List<Guns> findAll(@Param("maxPrice") Integer maxPrice, @Param("minPrice") Integer minPrice);


    @Query("SELECT SUM(g.price) FROM Guns g WHERE g IN :selectedGuns")
    Double calculateTotalPrice(@Param("selectedGuns") List<Guns> selectedGuns);

    @Query("SELECT g from Guns g WHERE " +
            "(:minMagazine IS NULL OR :minMagazine <= g.magazine) AND " +
            "(:maxMagazine IS NULL OR g.magazine <= :maxMagazine) AND " +
            "(:minPrice IS NULL OR :minPrice <= g.price) AND " +
            "(:maxPrice IS NULL OR g.price <= :maxPrice) AND " +
             "(:caliber IS NULL OR g.caliber = :caliber) AND " +
              "(:gunType IS NULL OR g.gunType = :gunType) AND " +
             "(:firearmsType IS NULL OR g.firearmsType = :firearmsType)")

    Iterable<Guns> findByFilter(
                                @Param("minMagazine") Integer minMagazine,
                                @Param("maxMagazine") Integer maxMagazine,
                                @Param("minPrice") Integer minPrice,
                                @Param("maxPrice") Integer maxPrice,
                                @Param("caliber")String caliber,
                                @Param("gunType") String gunType,
                                @Param("firearmsType") String firearmsType);



}
