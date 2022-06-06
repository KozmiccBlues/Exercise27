package pl.akoz.exercise27.testdata;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.akoz.exercise27.subscription.Subscriber;
import pl.akoz.exercise27.subscription.SubscriberRepository;
import pl.akoz.exercise27.employee.Employee;
import pl.akoz.exercise27.employee.EmployeeRepository;

import java.util.List;
import java.util.Arrays;

@Profile("dev")
@Component

public class TestdataProvider {

    private final EmployeeRepository employeeRepository;
    private final SubscriberRepository subscriberRepository;

    public TestdataProvider(EmployeeRepository employeeRepository, SubscriberRepository subscriberRepository) {
        this.employeeRepository = employeeRepository;
        this.subscriberRepository = subscriberRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void insertTestData() {

        Employee employee1 = employeeRepository.findById(1L).orElseThrow();
        Employee employee2 = employeeRepository.findById(2L).orElseThrow();
        Employee employee3 = employeeRepository.findById(3L).orElseThrow();
        Employee employee4 = employeeRepository.findById(4L).orElseThrow();

        List<Subscriber> subscriberList = Arrays.asList(
                new Subscriber(employee1, "employee1@onet.eu,"),
                new Subscriber(employee2, "employee2@onet.eu,"),
                new Subscriber(employee3, "employee3@onet.eu,"),
                new Subscriber(employee4, "employee4@onet.eu,")
        );

        subscriberRepository.saveAll(subscriberList);

    }
}