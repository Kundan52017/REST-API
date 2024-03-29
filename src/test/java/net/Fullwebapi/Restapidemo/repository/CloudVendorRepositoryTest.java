package net.Fullwebapi.Restapidemo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import net.Fullwebapi.Restapidemo.model.CloudVendor;

@DataJpaTest
public class CloudVendorRepositoryTest {
	
	//given -when -then
	@Autowired
	private CloudVendorRepository cloudVendorRepository;
	CloudVendor   cloudVendor;
	
	@BeforeEach
	void setUp()
	{
		cloudVendor= new CloudVendor("1","Amazon",
				"USA", "xxx");  //vendorId,vendorAddress,vendorMobileNumber
	
		cloudVendorRepository.save(cloudVendor);
		
	}
	@AfterEach
	 void tearDown()
	 {
		cloudVendor=null;
		cloudVendorRepository.deleteAll();
	 }
	// test case success
	@Test 
	void testFindByVendorName_Found()
	{
		List<CloudVendor> cloudVendorList=cloudVendorRepository.findByVendorName("Amazon");
	   assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
	   assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());	
	   }
	
	
	// test case failure
	@Test
	void testFindByVendorName_NotFound()
	{
		List<CloudVendor> cloudVendorList=cloudVendorRepository.findByVendorName("GCP");
	  assertThat(cloudVendorList.isEmpty()).isTrue();
	}
	
	
	
}
