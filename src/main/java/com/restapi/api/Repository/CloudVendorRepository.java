package com.restapi.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.api.Model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor ,  String> {
    
    // overrided repo methods 
    

}
