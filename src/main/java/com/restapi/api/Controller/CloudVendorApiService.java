package com.restapi.api.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.api.Model.CloudVendor;
import com.restapi.api.Service.CloudVendorService;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorApiService {

    CloudVendorService cloudVendorService ;
    public CloudVendorApiService(CloudVendorService cloudVendorService){
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(String vendorId){

        CloudVendor oneCloudVendor = this.cloudVendorService.getOneCloudVendor(vendorId);
        if(oneCloudVendor == null){
            return null;
        }
        return oneCloudVendor;
    }

    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor){
        return this.cloudVendorService.createCloudVendor(cloudVendor);
    }

    @PutMapping
    public String updateCloudVendor(@RequestBody CloudVendor cloudVendor){
        
        return this.cloudVendorService.updateCloudVendor(cloudVendor);
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendor(String vendorId){
        return this.cloudVendorService.deleteCloudVendor(vendorId);
    }
    
    @GetMapping
    public List<CloudVendor> getAllCloudvendors(){
        return this.cloudVendorService.fetchAllCloudVendor();
    }
}
