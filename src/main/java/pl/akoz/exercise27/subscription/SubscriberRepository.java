package pl.akoz.exercise27.subscription;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.akoz.exercise27.employee.Employee;

import java.util.List;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

    List<Subscriber> findByEmployeeAndEmail(Employee employee, String email);

}
