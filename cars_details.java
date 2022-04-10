/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabboking1;

/**
 *
 * @author acs
 */
public class cars_details {
   int carid;
    String carname ;
            String type2;            
            String description;
            String brand ;
            String petroltype ;
            int pricewithdriver ;
            int pricewithoutdriver;
            int security ;
            String photo ;

    public cars_details(int carid,String carname, String type2, String description, String brand, String petroltype, int pricewithdriver, int pricewithoutdriver, int security, String photo) {
        this.carid=carid;
        this.carname = carname;
        this.type2 = type2;
        this.description = description;
        this.brand = brand;
        this.petroltype = petroltype;
        this.pricewithdriver = pricewithdriver;
        this.pricewithoutdriver = pricewithoutdriver;
        this.security = security;
        this.photo = photo;
    }
            
            
    
}
