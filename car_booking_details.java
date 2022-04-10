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
public class car_booking_details {
    
           String name;
           String email;
           String mobile_no;
           String address;
           int price_per_day;
           String start_date;
           String end_date;
           int no_of_days;
           int rent;
           int security;
           int car_id;
           String book_time;
           String status;
                                   int booking_id ;

    public car_booking_details(String name, String email, String mobile_no, String address, int price_per_day, String start_date, String end_date, int no_of_days, int rent, int security, int car_id, String book_time, String status, int booking_id) {
        this.name = name;
        this.email = email;
        this.mobile_no = mobile_no;
        this.address = address;
        this.price_per_day = price_per_day;
        this.start_date = start_date;
        this.end_date = end_date;
        this.no_of_days = no_of_days;
        this.rent = rent;
        this.security = security;
        this.car_id = car_id;
        this.book_time = book_time;
        this.status = status;
        this.booking_id = booking_id;
    }

  
           
         
               
    
}
