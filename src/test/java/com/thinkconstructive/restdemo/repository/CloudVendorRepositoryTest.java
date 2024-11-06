package com.thinkconstructive.restdemo.repository;

import com.thinkconstructive.restdemo.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@DataJpaTest //this annotation lets the spring application know to use in memory database
@SpringBootTest
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

    //SUCCESS case

    @Test
    void testFindByVendorName_Found() {
        List<CloudVendor> vendorList = cloudVendorRepository.findByVendorName("Amazon");
        assertThat(vendorList.get(0).getVendorId())
                .isEqualTo(cloudVendor.getVendorId());
        assertThat(vendorList.get(0).getVendorAddress())
                .isEqualTo(cloudVendor.getVendorAddress());
    }

    //FAILURE case

}
