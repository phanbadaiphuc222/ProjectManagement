package application;

import com.mysql.cj.PreparedQuery;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;      

public class Application {
    
    private Connection conn;
    
    public static List<Product> findAll() {

        List<Product> ProductList = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select * from product";
            statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

               Product pdt = new Product ();
                pdt.setProductID(resultSet.getString("productID"));
                pdt.setProductName(resultSet.getString("productName"));
                pdt.setOriginPrice(resultSet.getInt("originPrice"));
                pdt.setPrice(resultSet.getInt("price"));
                pdt.setAmount(resultSet.getInt("amount"));
                
                ProductList.add(pdt);

            }

        } catch (Exception e) {
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
        return ProductList;
    }
    
    public static List<Product> findAll2() {

        List<Product> ProductList = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select * from Product_change";
            statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

               Product pdt = new Product ();
                pdt.setUserName(resultSet.getString("userName"));
                pdt.setTimeInsert(resultSet.getString("timeInsert"));
                pdt.setActionType(resultSet.getString("actionType"));
                pdt.setProductIDChange(resultSet.getString("productID"));
                pdt.setProductNameChange(resultSet.getString("productName"));
                pdt.setOriginPriceChange(resultSet.getInt("originPrice"));
                pdt.setPriceChange(resultSet.getInt("price"));
                pdt.setAmountChange(resultSet.getInt("amount"));
                
                ProductList.add(pdt);

            }

        } catch (Exception e) {
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
        return ProductList;
    }

    public static void insert(Product pdt) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "call ProductInsert(?, ?, ?, ?, ?);";
            statement = conn.prepareCall(sql);

            statement.setString(1, pdt.getProductID());
            statement.setString(2, pdt.getProductName());
            statement.setInt(3, pdt.getOriginPrice());
            statement.setInt(4, pdt.getPrice());
            statement.setInt(5, pdt.getAmount());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
    }

    public static void remove(String id) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "call ProductDelete(?)";
            statement = conn.prepareCall(sql);

            statement.setString(1, id);

            statement.execute();

        } catch (Exception e) {
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }

    }

    public static List<Product> findByFullName(String ID) {

        List<Product> ProductList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select * from product where ProductID like ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, "%" + ID + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                
                Product pdt = new Product ();
                pdt.setProductID(resultSet.getString("productID"));
                pdt.setProductName(resultSet.getString("productName"));
                pdt.setOriginPrice(resultSet.getInt("originPrice"));
                pdt.setPrice(resultSet.getInt("price"));
                pdt.setAmount(resultSet.getInt("amount"));
                
                ProductList.add(pdt);
            }

        } catch (Exception e) {
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
        return ProductList;

    }

    public static List<Product> sort(int choice) {

        List<Product> ProductList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useSSL=false&password=daiphucprohehe");
            String sql = new String();

            if (choice == 1) {
                sql = "call ProductSortName()";
            }
            if (choice == 2) {
                sql = "call ProductSortPrice()";
            }
            if (choice == 3) {
                sql = "call ProductSortAmount()";
            }
            statement = conn.prepareCall(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product pdt = new Product ();
                pdt.setProductID(resultSet.getString("productID"));
                pdt.setProductName(resultSet.getString("productName"));
                pdt.setOriginPrice(resultSet.getInt("originPrice"));
                pdt.setPrice(resultSet.getInt("price"));
                pdt.setAmount(resultSet.getInt("amount"));
                
                ProductList.add(pdt);
            }

        } catch (Exception e) {
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
        return ProductList;
    }

    public static void modify(Product pdt) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "update product set ProductName = ?, OriginPrice = ?, price = ?, amount = ? where ProductID = ?";
            statement = conn.prepareCall(sql);

            statement.setString(5, pdt.getProductID());
            statement.setString(1, pdt.getProductName());
            statement.setInt(2, pdt.getOriginPrice());
            statement.setInt(3, pdt.getPrice());
            statement.setInt(4, pdt.getAmount());

            statement.execute();

        } catch (Exception e) {
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
    }
    
    public static boolean search(String ProductID){
        
        Connection conn = null;
        PreparedStatement statement = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select price from product where ProductID = ?";
            statement = conn.prepareCall(sql);
            
            statement.setString (1, ProductID);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) return true; 
            else return false;
            
        } catch (Exception e) {
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
        return false;
    }
    
    public static boolean login(String staffID, String pass){
        
        Connection conn = null;
        PreparedStatement statement = null;
        boolean res=true;
        
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew =conn.prepareStatement("select *"
                    + " from staff where staffID = '" +staffID +"' and pass ='" + pass + "'",ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);
           
            ResultSet rs = passnew.executeQuery();

            if (!rs.isBeforeFirst()){
                res=false;
            }else if (rs.next()){
                LoginSession.userName=rs.getString("staffName");
                LoginSession.ID = rs.getString("staffID");
                LoginSession.email=rs.getString("email");
                LoginSession.phone=rs.getString("phone");
                LoginSession.password=rs.getString("pass");
                LoginSession.DOB=rs.getString("DOB");
                LoginSession.gender=rs.getString("gender");
                
                res=true;    
            }
        }
        catch (Exception e){
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
        return res;
    }
    
    public static int register(String name, String gender, String DOB, String email, String phone, String ID, String pass){
        
        Connection conn = null;
        PreparedStatement statement = null;
        int res=1;
        
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew =conn.prepareStatement("select * from staff where staffID = ? or pass = ?",ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);
            
            passnew.setString(1, ID);
            passnew.setString(2, pass);
            ResultSet rs = passnew.executeQuery();
            
            if (!rs.isBeforeFirst()){
                
                res=1;
                String sql = "call add_acc_staff(?, ?, ?, ?, ?, ?, ?)";
                statement = conn.prepareCall(sql);
            
                statement.setString (1, name);
                statement.setString (2, gender);
                statement.setString (3, DOB);
                statement.setString (4, email);
                statement.setString (5, phone);
                statement.setString (6, ID);
                statement.setString (7, pass);
                
                LoginSession.userName=name;
                LoginSession.gender=gender;
                LoginSession.DOB=DOB;
                LoginSession.email=email;
                LoginSession.phone=phone;
                LoginSession.ID=ID;
                LoginSession.password=pass;
                
                ResultSet rs2 = statement.executeQuery();
            }else if (rs.next()){
                res=0; 
            }
        }catch (Exception e){
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
        
        return res;
    }
    
    public static void update(int choice, String ProductID, String ProductName, int OriginPrice, int Price, int Amount){
        
        Connection conn = null;
        PreparedStatement statement = null;
        String sql="";
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String strDate = dateFormat.format(date);   

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useSSL=false&password=daiphucprohehe");
            sql = "insert into Product_change (userName, timeInsert, actionType, ProductID, ProductName, originPrice, price, amount) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareCall(sql);
            if (choice == 1){
                statement.setString(3, "insert");
            } else if (choice == 2){
                statement.setString(3, "delete");
            } else if (choice == 3){
                statement.setString(3, "update");
            }
            
            
            statement.setString(1, LoginSession.userName);
            statement.setString(2, strDate);
            statement.setString(4, ProductID);
            statement.setString(5, ProductName);
            statement.setInt(6, OriginPrice);
            statement.setInt(7, Price);
            statement.setInt(8, Amount);
            statement.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
        
    }
    
    public static void clear(){
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "delete from Product_change;";
            statement = conn.prepareCall(sql);

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
        
    }
    
    public static boolean checkAmount(String ID, int number){
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select amount from product where ProductID = ? and amount >= ?;";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, ID);
            statement.setInt(2, number);

            ResultSet rs = statement.executeQuery();
            
            if (!rs.next()){
                return false;
            } 

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
        return true;
    }
    
    public static void getStaffInfor(String ID){
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select * from staff where staffID = ?";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, ID);

            ResultSet rs = statement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
    }
    
    public static void saveChange(String name, String gender, String DOB, String email, String phone, String ID, String pass){
        
        Connection conn = null;
        PreparedStatement statement = null;
        int res=1;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "update staff set staffName = ?, gender = ?, DOB = ?, email = ?, phone = ?, staffID = ?,"
                     + "pass = ? where staffID = ?";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, name);
            statement.setString(2, gender);
            statement.setString(3, DOB);
            statement.setString(4, email);
            statement.setString(5, phone);
            statement.setString(6, ID);
            statement.setString(7, pass);
            statement.setString(8, LoginSession.ID);
            
            LoginSession.userName = name;
            LoginSession.gender = gender;
            LoginSession.DOB = DOB;
            LoginSession.email = email;
            LoginSession.phone = phone;
            LoginSession.ID = ID;
            LoginSession.password = pass;

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
        
    }
    
}
