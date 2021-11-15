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

public class Application {

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

                Product pdt = new Product(resultSet.getString("ProductID"), resultSet.getString("ProductName"),
                         resultSet.getInt("originPrice"), resultSet.getInt("price"), resultSet.getInt("amount"));
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "insert into product(productID, productName, originPrice, price, amount) values(?, ?, ?, ?, ?)";
            statement = conn.prepareCall(sql);

            statement.setString(1, pdt.getProductID());
            statement.setString(2, pdt.getProductName());
            statement.setInt(3, pdt.getOriginPrice());
            statement.setInt(4, pdt.getPrice());
            statement.setInt(5, pdt.getAmount());

            statement.execute();

        } catch (Exception e) {
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
    }

    public static void remove(String id) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "delete from product where ProductID like ?";
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
                Product pdt = new Product(resultSet.getString("ProductID"), resultSet.getString("ProductName"),
                         resultSet.getInt("originPrice"), resultSet.getInt("price"), resultSet.getInt("amount"));
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
                sql = "select * from product order by ProductName";
            }
            if (choice == 2) {
                sql = "select * from product order by price";
            }
            if (choice == 3) {
                sql = "select * from product order by amount";
            }
            statement = conn.prepareCall(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product pdt = new Product(resultSet.getString("ProductID"), resultSet.getString("ProductName"),
                         resultSet.getInt("originPrice"), resultSet.getInt("price"), resultSet.getInt("amount"));
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
    
}
