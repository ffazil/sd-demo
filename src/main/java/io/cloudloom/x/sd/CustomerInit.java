package io.cloudloom.x.sd;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerInit implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer("Algernon Moncheff", LocalDate.of(1983, 5, 14));
        customer = customerRepository.save(customer);
        log.info("Added {}.", customer.getName());
    }
}
