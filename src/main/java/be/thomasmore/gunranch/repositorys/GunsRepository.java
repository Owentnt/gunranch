package be.thomasmore.gunranch.repositorys;

import be.thomasmore.gunranch.model.Guns;
import org.springframework.data.repository.CrudRepository;

public interface GunsRepository extends CrudRepository<Guns,Integer> {

    Iterable<Guns> findByType(String type);
    Iterable<Guns> findByPriceLessThan(double max);

    Iterable<Guns> findByPriceBetween(double min, double max);

    Iterable<Guns> findByPriceGreaterThan(double min);

    Iterable<Guns> findByCaliber(String caliber);

    Iterable<Guns> findFirstByOrderByIdDesc();

    Iterable<Guns> findFirstByOrderByIdAsc();

    Iterable <Guns> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Iterable <Guns> findFirstByIdGreaterThanOrderByIdAsc(Integer id);










}
