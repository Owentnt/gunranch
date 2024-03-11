package be.thomasmore.gunranch.repositorys;

import be.thomasmore.gunranch.model.Guns;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GunsRepository extends CrudRepository<Guns, Integer> {

    Iterable<Guns> findByType(String type);

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


    @Query("SELECT g from Guns g WHERE " +
            "(:type IS NULL OR :type <= g.type) AND " +
            "(:minMagazine IS NULL OR :minMagazine <= g.magazine) AND " +
            "(:maxMagazine IS NULL OR g.magazine <= :maxMagazine) AND " +
            "(:caliber IS NULL OR g.caliber = :caliber) AND " +
            "(:minPrice IS NULL OR :minPrice <= g.price) AND " +
            "(:maxPrice IS NULL OR g.price <= :maxPrice) AND " +
            "(:firearmsType IS NULL OR :firearmsType <= g.firearmType)")

    Iterable<Guns> findByFilter(@Param("type") String type,
                                 @Param("minMagazine") Integer minMagazine,
                                 @Param("maxMagazine") Integer maxMagazine,
                                 @Param("caliber") String caliber,
                                 @Param("minPrice") Integer minPrice,
                                 @Param("maxPrice") Integer maxPrice,
                                @Param("firearmsType") String firearmsType);

    @Query("SELECT g from Guns g WHERE " +
            "(:minMagazine IS NULL OR :minMagazine <= g.magazine) ")
    Iterable<Guns> findByFilter2(
                                @Param("minMagazine") Integer minMagazine);

}
