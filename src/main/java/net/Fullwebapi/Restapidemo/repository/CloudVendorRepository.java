package net.Fullwebapi.Restapidemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.Fullwebapi.Restapidemo.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor,String> {

	List<CloudVendor> findByVendorName(String string);
	 //List<CloudVendor> findByVendorName(String vendorName);
}
