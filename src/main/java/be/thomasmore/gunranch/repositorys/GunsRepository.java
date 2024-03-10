package be.thomasmore.gunranch.repositorys;

import be.thomasmore.gunranch.model.Guns;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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

    Iterable<Guns> findByFilter(@Param("type") String type,
                                 @Param("minMagazine") Integer minMagazine,
                                 @Param("maxMagazine") Integer maxMagazine,
                                 @Param("caliber") String caliber,
                                 @Param("minPrice") Integer minPrice,
                                 @Param("maxPrice") Integer maxPrice,
                                @Param("firearmsType") String firearmsType);

}
