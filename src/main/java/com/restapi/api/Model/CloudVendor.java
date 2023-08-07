package com.restapi.api.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cloud_vendor")
public class CloudVendor {

    @Id
    private String vendorId;

    @Column(name = "vendor_name")
    private String vendorName;
    
    @Column( name = "vendor_adress")
    private String vendorAdress;

    @Column(name  = "vendor_phone_number")
    private String vendorPhoneNumber;


    public CloudVendor(){}
    public CloudVendor(
        String vendorId ,
        String vendorName,
        String vendorAdress , 
        String vendorPhoneNumber
    ){
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.vendorAdress = vendorAdress;
        this.vendorPhoneNumber = vendorPhoneNumber;
    }


    


 
    public String getVendorId() {
        return vendorId;
    }

 
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }


    public String getVendorName() {
        return vendorName;
    }

 
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }


    public String getVendorAdress() {
        return vendorAdress;
    }


    public void setVendorAdress(String vendorAdress) {
        this.vendorAdress = vendorAdress;
    }

 
    public String getVendorPhoneNumber() {
        return vendorPhoneNumber;
    }

 
    public void setVendorPhoneNumber(String vendorPhoneNumber) {
        this.vendorPhoneNumber = vendorPhoneNumber;
    }

}
