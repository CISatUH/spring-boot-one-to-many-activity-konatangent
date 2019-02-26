package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    public static void main(String[] args){

        SpringApplication.run(Main.class);
    }

    @Override
    public void run(String... args) throws Exception {
        customerRepository.deleteAll();
        addData();

        for(Customer customer: customerRepository.findAll()){
            System.out.println(customer);
        }

    }

    private void addData() {
        Address address = new Address();
        address.setStreetName("1st Street");
        address.setStreetNumber("123");
        address.setState("Texas");
        address.setZipcode(77501);

        Address address2 = new Address();
        address2.setStreetName("2st Street");
        address2.setStreetNumber("125");
        address2.setState("New York");
        address2.setZipcode(15525);

        Set<Address> addresses = new HashSet<>();
        addresses.add(address);
        addresses.add(address2);

        Customer customer = new Customer("Bryan", "Fury");
        customer.setAddresses(addresses);
        customerRepository.save(customer);
    }
}
