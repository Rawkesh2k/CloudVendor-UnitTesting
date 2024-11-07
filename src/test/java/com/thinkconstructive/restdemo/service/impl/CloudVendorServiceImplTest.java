package com.thinkconstructive.restdemo.service.impl;

import com.thinkconstructive.restdemo.model.CloudVendor;
import com.thinkconstructive.restdemo.repository.CloudVendorRepository;
import com.thinkconstructive.restdemo.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class CloudVendorServiceImplTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;

    private CloudVendorService cloudVendorService;

    AutoCloseable autoCloseable;

    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor = new CloudVendor("1", "Amazon",
                "USA", "43575365253");

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.createCloudVendor(cloudVendor))
                .isEqualTo("Success");
    }

    @Test
    void updateCloudVendor() {
        mock(CloudVendorRepository.class);
        mock(CloudVendor.class);
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.updateCloudVendor(cloudVendor))
                .isEqualTo("Success");
    }

    @Test
    void deleteCloudVendor() {
    }

    @Test
    void getCloudVendor() {
        mock(CloudVendorRepository.class);
        mock(CloudVendor.class);
        when(cloudVendorRepository.findById("1"))
                .thenReturn(Optional.ofNullable(cloudVendor));
        assertThat(cloudVendorService.getCloudVendor("1")
                .getVendorName())
                .isEqualTo(cloudVendor.getVendorName());

    }

    @Test
    void getAllCloudVendors() {
    }

    @Test
    void getByVendorName() {
    }
}