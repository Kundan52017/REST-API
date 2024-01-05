package net.Fullwebapi.Restapidemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import net.Fullwebapi.Restapidemo.model.CloudVendor;
import net.Fullwebapi.Restapidemo.response.ResponseHandler;
import net.Fullwebapi.Restapidemo.service.CloudVendorService;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
	
	CloudVendorService cloudVendorService;
	
	
	public CloudVendorController(CloudVendorService cloudVendorService) {
		
		this.cloudVendorService = cloudVendorService;
	}
	//Read Specific cloud vendor details
	@GetMapping("{vendorId}")
	public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
	    return ResponseHandler.responseBuilder(
	       "Request Vendor Details are given here",
	        HttpStatus.OK,
	        cloudVendorService.getCloudVendor(vendorId)
	    );
				 //new CloudVendor(vendorId ,"Vendor 1", "Address one", "xxxx");
	}
	//Reading All cloud Vendor Details from DB
	@GetMapping()
	public List <CloudVendor> getAllCloudVendorDetails() {
		
		 return cloudVendorService.getAllCloudVendors();
		
	}
	/*@GetMapping("/byVendorName")
	public List<CloudVendor> getByVendorName(@RequestParam("vendorName") String vendorName) {
	    return cloudVendorService.getByVendorName(vendorName);
	}*/

	@PostMapping
	public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) 
	{
		cloudVendorService.createCloudVendor(cloudVendor);
     return "Cloud Vendor Created  Sucessfully";
}
	@PutMapping
	public String UpdateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) 
	{
		cloudVendorService.updateCloudVendor(cloudVendor);
     return "Cloud Vendor Updated  Sucessfully";
    }
	
	@DeleteMapping("{vendorId}")
	public String DeleteCloudVendorDetails(@PathVariable("vendorId")String vendorId) 
	{
		cloudVendorService.deleteCloudVendor(vendorId);
     return "Cloud Vendor Deleted  Sucessfully";
}
	}
