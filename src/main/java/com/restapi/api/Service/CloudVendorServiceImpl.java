package com.restapi.api.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.restapi.api.Model.CloudVendor;
import com.restapi.api.Repository.CloudVendorRepository;

@Service
public class CloudVendorServiceImpl implements CloudVendorService{

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepos){
        this.cloudVendorRepository = cloudVendorRepos;
    }

    @Override
    public List<CloudVendor> fetchAllCloudVendor(){
        List<CloudVendor> listOfCloudVendors =  this.cloudVendorRepository.findAll();
        return listOfCloudVendors ;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor){
        if(
            cloudVendor.getVendorId().isEmpty() || 
            cloudVendor.getVendorName().isEmpty() || 
            cloudVendor.getVendorAdress().isEmpty() || 
            cloudVendor.getVendorPhoneNumber().isEmpty()
        ){
            return "fields should not be empty";
        }
        CloudVendor isFounded = this.getOneCloudVendor(cloudVendor.getVendorId());
        if(isFounded == null){
            this.cloudVendorRepository.save(cloudVendor);
        }
        return "cloud vendor is created successfully !";
    }

    @Override
    public String deleteCloudVendor(String vendorId){
        CloudVendor foundedCloudVendor = this.getOneCloudVendor(vendorId);
        if(foundedCloudVendor == null){
            return "not found";
        }
        this.cloudVendorRepository.delete(foundedCloudVendor);
        return "deleted successfully !";
    }
    @Override
    public CloudVendor getOneCloudVendor(String vendorId){
        CloudVendor cloudvendor = this.cloudVendorRepository.findById(vendorId).get();
        return cloudvendor;
    }
    @Override
    public String updateCloudVendor(CloudVendor cloudvendor){
        CloudVendor foundedCloudVendor = this.getOneCloudVendor(cloudvendor.getVendorId());
        if(foundedCloudVendor == null){
            return "No vendor founded to update !";
        }
        foundedCloudVendor.setVendorName(cloudvendor.getVendorName() != null ? cloudvendor.getVendorName(): foundedCloudVendor.getVendorName());
        foundedCloudVendor.setVendorAdress(cloudvendor.getVendorAdress() != null ? cloudvendor.getVendorAdress() : foundedCloudVendor.getVendorAdress());
        foundedCloudVendor.setVendorPhoneNumber(cloudvendor.getVendorPhoneNumber() != null ? cloudvendor.getVendorPhoneNumber() : foundedCloudVendor.getVendorPhoneNumber());
        this.cloudVendorRepository.save(foundedCloudVendor);
        return "cloud vendor is updated !";
    }

}
