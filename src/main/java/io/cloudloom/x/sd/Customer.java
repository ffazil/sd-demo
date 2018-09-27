package io.cloudloom.x.sd;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, onConstructor = @__(@PersistenceConstructor))
public class Customer {
    @Id
    private Long id;
    private String firstName;
    private LocalDate dob;

    public Customer(String firstName, LocalDate dob){
        this.id = null;
        this.firstName = firstName;
        this.dob = dob;
    }

    public Customer firstName(String firstName){
        this.firstName = firstName;

        return this;
    }
}
