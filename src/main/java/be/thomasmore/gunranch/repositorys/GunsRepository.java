package be.thomasmore.gunranch.repositorys;

import be.thomasmore.gunranch.model.Guns;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

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

    @Query("SELECT g from Guns g WHERE " +
            "(:type IS NULL OR :type <= g.type) AND " +
            "(:minMagazine IS NULL OR g.magazine <= :minMagazine) AND " +
            "(:maxMagazine IS NULL OR g.magazine <= :maxMagazine) AND " +
            "(:caliber IS NULL OR g.caliber = :caliber) AND " +
            "(:minPrice IS NULL OR g.price <= :minPrice) AND " +
            "(:maxPrice IS NULL OR g.price <= :maxPrice) AND " +
            "(:firearmsType IS NULL OR :firearmsType <= g.firearmType)")

    Iterable<Guns> findByFilter(@Param("type") String type,
                                 @Param("minMagazine") Integer minMagazine,
                                 @Param("maxMagazine") Integer maxMagazine,
                                 @Param("caliber") String caliber,
                                 @Param("minPrice") Integer minPrice,
                                 @Param("maxPrice") Integer maxPrice,
                                @Param("firearmsType") String firearmsType);

}
