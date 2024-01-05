package net.Fullwebapi.Restapidemo.service;

import java.util.List;

import net.Fullwebapi.Restapidemo.model.CloudVendor;

public interface CloudVendorService {
	
	String createCloudVendor(CloudVendor cloudVendor);
    String updateCloudVendor(CloudVendor cloudVendor);
    String deleteCloudVendor(String cloudVendorId);
    CloudVendor getCloudVendor(String cloudVendorId);
    List<CloudVendor> getAllCloudVendors();
  //
	List<CloudVendor> getByVendorName(String VendorName);
    
	
	
	
	
	
	
	
}

