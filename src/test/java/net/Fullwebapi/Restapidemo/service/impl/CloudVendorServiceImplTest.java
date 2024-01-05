package net.Fullwebapi.Restapidemo.service.impl;


import static org.assertj.core.api.Assertions.assertThat;

//import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.Answers;
import org.mockito.Mock;
//import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import net.Fullwebapi.Restapidemo.model.CloudVendor;
import net.Fullwebapi.Restapidemo.repository.CloudVendorRepository;
import net.Fullwebapi.Restapidemo.service.CloudVendorService;
import net.Fullwebapi.Restapidemo.service.CloudVendorServiceImpl;

public class CloudVendorServiceImplTest {

	
	@Mock
	private CloudVendorRepository cloudVendorRepository;
	private CloudVendorService cloudVendorService;
	AutoCloseable autoCloseable;
	CloudVendor  cloudVendor;
	
	
	@BeforeEach
	void setUp()
	{
		autoCloseable=MockitoAnnotations.openMocks( this);
	    cloudVendorService= new CloudVendorServiceImpl(cloudVendorRepository);
	    cloudVendor= new CloudVendor("1","Amazon","USA","XXX");
	}
	@AfterEach
	void tearDown() throws Exception{
		autoCloseable.close();
	}
	
	@Test
	void testcreateCloudVendor()
	{
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
	    assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("Success");
	}
	@Test
	void testupdateCloudVendor()
	{
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
	    assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("Success");
		
	}
	
	@Test
	void testGetCloudVendor()
	{
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));
		assertThat(cloudVendorService.getCloudVendor("1").getVendorName()).isEqualTo(cloudVendor.getVendorName());
	}
	 @Test
	    void testGetByVendorName() {
	        // Mock the behavior of the repository
	 mock(CloudVendor.class);
			mock(CloudVendorRepository.class);
	    when(cloudVendorRepository.findByVendorName("Amazon"))
	                .thenReturn(new ArrayList<>(Collections.singleton(cloudVendor)));

	      
	        assertThat(cloudVendorService.getByVendorName("Amazon").get(0).getVendorId())
	               .isEqualTo(cloudVendor.getVendorId());
	    }
	
	@Test
	void testGetAllCloudVendors()
	{
		/*mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		when(cloudVendorRepository.findAll())
        .thenReturn(new ArrayList<>(Collections.singleton(cloudVendor)));
		assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorMobileNumber())
		.isEqualTo(cloudVendor.getVendorMobileNumber());*/
	}
	
	
	
	@Test
	void DeleteCloudVendor()
	{
		/*mock(CloudVendor.class);
		mock(CloudVendorRepository.class,Mockito.CALLS_REAL_METHODS);
		doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository).deleteById(null);
		assertThat(cloudVendorService.deleteCloudVendor("1")).isEqualTo("Success");
		*/
	}
}


    






