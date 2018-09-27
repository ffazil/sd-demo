package io.cloudloom.x.sd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = DataJdbcConfig.class)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void addsCustomer() {

        Customer customer = new Customer("Nitin", LocalDate.of(1983, 5, 14));

        Customer saved = customerRepository.save(customer);

        assertThat(saved.getId()).isNotNull();

        saved.name("Nithin");

        customerRepository.save(saved);

        Optional<Customer> reloaded = customerRepository.findById(saved.getId());

        assertThat(reloaded).isNotEmpty();

        assertThat(reloaded.get().getName()).isEqualTo("Nithin");
    }

    @Test
    public void findsByName() {

        Customer customer = new Customer("Nithin", LocalDate.of(1983, 5, 14));

        Customer saved = customerRepository.save(customer);

        assertThat(customerRepository.findByName("Nithin")).hasSize(1);
    }


}
