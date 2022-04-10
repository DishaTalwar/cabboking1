/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabboking1;

import com.vmm.JHTTPServer;
import java.io.IOException;
import java.util.Properties;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Hp
 */
public class cabBookingServer  extends JHTTPServer{

    public cabBookingServer(int port) throws IOException {
        super(port);
    }

    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) {
    
        Response res ;
                res = new Response(HTTP_OK,"text/plain","Hello  from Server");

        System.out.println(""+uri);
        if(uri.contains("login")){
            String ans = "";
            String email = parms.getProperty("email");
            String pass = parms.getProperty("pass");
            System.out.println("Reach  "+email);
            // Database logic
            
           try {
                ResultSet rs = DBLoader.executeStatement("select * from admin where email='"+email+"' and password='"+pass+"'");
            
            if(rs.next()){
                ans = "success";
            }
            else {
                ans = "fails";
            }
             res = new Response(HTTP_OK,"text/plain",ans);  
           }
           catch (Exception e  ){
               e.printStackTrace();
           }
                    

            
        }
        else if(uri.contains("adminchangepaswrd"))
        {
            String email=parms.getProperty("email");
            String oldpassword=parms.getProperty("oldpassword");
            String newpassword=parms.getProperty("newpassword");
            String ans = "";
            System.out.println(""+email);
            
        try {
                ResultSet rs = DBLoader.executeStatement("select * from admin where email='"+email+"' and password='"+oldpassword+"'");
            
            if(rs.next()){
                rs.moveToCurrentRow();
                rs.updateString("password",newpassword);
                rs.updateRow();
                
                
                ans = "success";
            }
            else {
                ans = "fails";
            }
             res = new Response(HTTP_OK,"text/plain",ans);  
           }
           catch (Exception e  ){
               e.printStackTrace();
           }
             
           
        }
        else  if(uri.contains("usercheck")){
            String ans = "";
            String username = parms.getProperty("username");
            String password = parms.getProperty("password");
            System.out.println("Reach User "+password);
            // Database logic
            
           try {
                ResultSet rs = DBLoader.executeStatement("select * from users where username='"+username+"' and password='"+password+"'");
            
            if(rs.next()){
                ans = "success";
            }
            else {
                ans = "fails";
            }
             res = new Response(HTTP_OK,"text/plain",ans);  
           }
           catch (Exception e  ){
               e.printStackTrace();
           }
                   
        }
        
        else if(uri.contains("usersignup"))  {
            String email = parms.getProperty("email");
            String password = parms.getProperty("password");
            String username = parms.getProperty("username");
            String phoneno = parms.getProperty("mobile no");
            String securityqsn = parms.getProperty("security question");
            String securityans = parms.getProperty("security ans");
            
            String ans="";
            
            try {
         ResultSet rsw = DBLoader.executeStatement("select * from users where Username ='"+email+"'");
           
           if(rsw.next()){
             ans = "User Already Exists";
           }
           else {
                rsw.moveToInsertRow();
               rsw.updateString("password",password);
               rsw.updateString("username",username);
               rsw.updateString("mobile no",phoneno);
                rsw.updateString("email",email);
               rsw.updateString("security question",securityqsn);
               rsw.updateString("security ans",securityans);
               
               
               rsw.insertRow();
               ans = "Success";
           }
        res = new Response(HTTP_OK,"text/plain",ans);   
           
   }
   catch(Exception e){
       e.printStackTrace();
   }
        }
         else if(uri.contains("managecars"))  {
            String carname = parms.getProperty("carname");
            String type = parms.getProperty("type");
            String description = parms.getProperty("description");
            String brand = parms.getProperty("brand");
            String petroltype = parms.getProperty("petroltype");
           
            String pricewithdriver = parms.getProperty("price with driver");
            String pricewithoutdriver = parms.getProperty("price without driver");
            String security = parms.getProperty("security");
            
            
            String ans="";
            
            try {
         ResultSet rsw = DBLoader.executeStatement("select * from cars where car_name ='"+carname+"'");
           
           if(rsw.next()){
             ans = "CAR Already Exists";
           }
           else {
               String photo = saveFileOnServerWithRandomName(files, parms, "photo", "src/uploads");
                rsw.moveToInsertRow();
               rsw.updateString("car_name",carname);
               rsw.updateString("type",type);
               rsw.updateString("description",description);
                rsw.updateString("brand",brand);
               rsw.updateString("price with driver",pricewithdriver);
               rsw.updateString("price without driver",pricewithoutdriver);
                rsw.updateString("security",security);
                rsw.updateString("fuel type",petroltype);
                rsw.updateString("photo","src/uploads/"+photo);
               
               rsw.insertRow();
               ans = "Success";
           }
        res = new Response(HTTP_OK,"text/plain",ans);   
           
   }
   catch(Exception e){
       e.printStackTrace();
   }
        }
        
         else if(uri.contains("fetchcars"))
         {   
             String type=parms.getProperty("type");
             String ans="";
         
        
         
            try {
         ResultSet rsw = DBLoader.executeStatement("select * from cars where type ='" +type+"'");
           
           while(rsw.next()){
              int carid=rsw.getInt("car id");
               String carname = rsw.getString("car_name");
            String type2 = rsw.getString("type");            
            String description = rsw.getString("description");
            String brand = rsw.getString("brand");
            String petroltype = rsw.getString("fuel type");
            int pricewithdriver = rsw.getInt("price with driver");
            int pricewithoutdriver =rsw.getInt("price without driver");
            int security =rsw.getInt("security");
            String photo = rsw.getString("photo");

            ans = ans +carid+";;"+ carname+";;"+type2+";;"+description+";;"+brand+";;"+petroltype+";;"+pricewithdriver+";;"+pricewithoutdriver+";;"+security+";;"+photo+"~~";
           }
           
               res = new Response(HTTP_OK,"text/plain",ans);   
    
            }
        catch(Exception e){
       e.printStackTrace();
   }
           
         }    
        
        else if(uri.contains("changepaswrd"))
        {
            String username=parms.getProperty("username");
            String oldpassword=parms.getProperty("oldpassword");
            String newpassword=parms.getProperty("newpassword");
            String ans = "";
            System.out.println(""+username);
            
        try {
                ResultSet rs = DBLoader.executeStatement("select * from users where username='"+username+"' and password='"+oldpassword+"'");
            
            if(rs.next()){
                rs.moveToCurrentRow();
                rs.updateString("password",newpassword);
                rs.updateRow();
                
                
                ans = "success";
            }
            else {
                ans = "fails";
            }
             res = new Response(HTTP_OK,"text/plain",ans);  
           }
           catch (Exception e  ){
               e.printStackTrace();
           }
        
        
        
        }
        
         else if(uri.contains("bookingsuccess"))
        {
            String name=parms.getProperty("name");
            String email=parms.getProperty("email");
            String mobileno=parms.getProperty("mobileno");
            String pickuplocation=parms.getProperty("pickuplocation");
            String price_per_day=parms.getProperty("price_per_day");
            String start=parms.getProperty("start");
            String end=parms.getProperty("end");
            String no_of_days=parms.getProperty("no_of_days");
            String rent=parms.getProperty("rent");
            String security=parms.getProperty("security");
            String carid=parms.getProperty("carid");
            
            System.out.println(""+price_per_day+"...."+no_of_days+"..."+rent+"..."+security);
            String ans = "";

            System.out.println(""+name);

                Date d  = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
                String bookingdate = sdf.format(d);
            
        try {
                ResultSet rs = DBLoader.executeStatement("select * from booking");
               
                rs.moveToInsertRow();
                
                rs.updateString("name", name);
                rs.updateString("email", email);
                rs.updateString("mobile_no", mobileno);
                rs.updateString("address", pickuplocation);
                rs.updateString("price_per_day", price_per_day);
                rs.updateString("start_date", start);
                rs.updateString("end_date", end);
                rs.updateInt("no_of_days", Integer.parseInt(no_of_days));
                rs.updateInt("rent", Integer.parseInt(rent));
                rs.updateInt("security", Integer.parseInt(security));
                rs.updateInt("car_id", Integer.parseInt(carid));
                rs.updateString("book_time", bookingdate);
                rs.updateString("status", "booked");
                
                
                rs.insertRow();
                
                
                ans = "success";
           
             res = new Response(HTTP_OK,"text/plain",ans);  
           }
           catch (Exception e  ){
               e.printStackTrace();
           }
        
        
        
        }
        
            else if(uri.contains("view"))
         {   
            
             String ans="";
         
        
         
            try {
         ResultSet rsw = DBLoader.executeStatement("select * from booking");
           
           while(rsw.next()){
                        int booking_id  = rsw.getInt("booking_id");

           String name  = rsw.getString("name");
           String email  = rsw.getString("email");
           String mobile_no  = rsw.getString("mobile_no");
           String address  = rsw.getString("address");
           int price_per_day  = rsw.getInt("price_per_day");
           String start_date  = rsw.getString("start_date");
           String end_date  = rsw.getString("end_date");
           int no_of_days  = rsw.getInt("no_of_days");
           int rent  = rsw.getInt("rent");
           int security  = rsw.getInt("security");
           int car_id  = rsw.getInt("car_id");
           String book_time  = rsw.getString("book_time");
           String status  = rsw.getString("status");
               

        ans= ans+name+";;"+email+";;"+ mobile_no+";;"+address+";;"+price_per_day+";;"+start_date+";;"+end_date+";;"+no_of_days+";;"+rent+";;"+security+";;"+car_id+";;"+book_time+";;"+status+";;"+booking_id+"~~"; 
                
           
           }
                System.out.println(""+ans);
           
               res = new Response(HTTP_OK,"text/plain",ans);   
    
            }
        catch(Exception e){
       e.printStackTrace();
   }
           
         }
            else  if(uri.contains("/GetResource"))
       {
           uri = uri.substring(1);
           uri = uri.substring(uri.indexOf("/")+1);
           System.out.println(uri+"***");
           res = sendCompleteFile(uri);
       }
         else if(uri.contains("all"))
         {   
             String ans="";
         
        
         
            try {
         ResultSet rsw = DBLoader.executeStatement("select * from cars");
           
           while(rsw.next()){
              int carid=rsw.getInt("car id");
               String carname = rsw.getString("car_name");
            String type2 = rsw.getString("type");            
            String description = rsw.getString("description");
            String brand = rsw.getString("brand");
            String petroltype = rsw.getString("fuel type");
            int pricewithdriver = rsw.getInt("price with driver");
            int pricewithoutdriver =rsw.getInt("price without driver");
            int security =rsw.getInt("security");
            String photo = rsw.getString("photo");

            ans = ans +carid+";;"+ carname+";;"+type2+";;"+description+";;"+brand+";;"+petroltype+";;"+pricewithdriver+";;"+pricewithoutdriver+";;"+security+";;"+photo+"~~";
           }
           
               res = new Response(HTTP_OK,"text/plain",ans);   
    
            }
        catch(Exception e){
       e.printStackTrace();
   }
           
         }
        
        return res; //To change body of generated methods, choose Tools | Templates.
    
    
    }
    
    
    
    
}


