package com.thinkconstructive.restdemo.repository;

import com.thinkconstructive.restdemo.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CloudVendorRepositoryTest {
    //given - when - then

    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor("1", "Amazon",
                "Cincinnati-Hamilton", "2354622542");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
        cloudVendor = null;
        cloudVendorRepository.deleteAll();
    }

    //we write test cases for only those scenarios which are not tested
    //Meaning, methods that are in built into JPA like save(), findById() are all tested
    //No point in testing them again
    //We test only those that are custom defined or not tested at all


}
