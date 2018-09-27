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
    private String name;
    private LocalDate dob;

    public Customer(String name, LocalDate dob){
        this.id = null;
        this.name = name;
        this.dob = dob;
    }

    public Customer name(String name){
        this.name = name;

        return this;
    }
}
