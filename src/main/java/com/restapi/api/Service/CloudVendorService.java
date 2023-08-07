package com.restapi.api.Service;

import java.util.List;
import com.restapi.api.Model.CloudVendor;

public interface  CloudVendorService {

    public String createCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String vendorId);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public CloudVendor getOneCloudVendor(String vendorId);
    public List<CloudVendor> fetchAllCloudVendor();
    
}
