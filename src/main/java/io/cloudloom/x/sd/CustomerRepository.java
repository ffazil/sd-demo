package io.cloudloom.x.sd;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Query("select id, name, dob from customer where upper(name) like '%' || upper(:name) || '%' ")
    List<Customer> findByName(@Param("name") String name);
}
