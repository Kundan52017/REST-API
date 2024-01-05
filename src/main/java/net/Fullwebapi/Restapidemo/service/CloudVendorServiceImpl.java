package net.Fullwebapi.Restapidemo.service;

import java.util.List;


import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import net.Fullwebapi.Restapidemo.Exception.CloudVendorNotFoundException;
import net.Fullwebapi.Restapidemo.model.CloudVendor;
import net.Fullwebapi.Restapidemo.repository.CloudVendorRepository;

@Service
public class CloudVendorServiceImpl implements CloudVendorService{

	
	CloudVendorRepository cloudVendorRepostory;
	private ListCrudRepository<CloudVendor, String> cloudVendorRepository;
	
	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepostory) {
		
		this.cloudVendorRepostory = cloudVendorRepostory;
	}

	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {
		// TODO Auto-generated method stub
		cloudVendorRepostory.save(cloudVendor);
		return "Success" ;
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		// // More Business logic
	
		cloudVendorRepostory.save(cloudVendor);
		return "Success" ;
	}

	@Override
	public String deleteCloudVendor(String cloudVendorId) {
		// More Business logic
		cloudVendorRepostory.deleteById(cloudVendorId);
		return "SuccessFull Deletion";
	}

	@Override
	public CloudVendor getCloudVendor(String cloudVendorId) {
		
		// // More Business logic
		if( cloudVendorRepostory.findById(cloudVendorId).isEmpty())
			throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
		return cloudVendorRepostory.findById(cloudVendorId).get();
	 
	}
	@Override
    public List<CloudVendor> getByVendorName(String vendorName) {
        List<CloudVendor> cloudVendors = ((CloudVendorRepository) cloudVendorRepository).findByVendorName(vendorName);

        if (cloudVendors.isEmpty()) {
            throw new CloudVendorNotFoundException("No Cloud Vendors found with the given vendorName: " + vendorName);
        }

        return cloudVendors;
    }
	
    @Override
	public List<CloudVendor> getAllCloudVendors() {
	    // More Business logic (uncomment and implement if needed)

	    return cloudVendorRepository.findAll();
	}

   


}
