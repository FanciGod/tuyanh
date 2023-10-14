package JDBCConnect.model;

import JDBCConnect.Connect.ConnectDTB;
import JDBCConnect.Connect.JDBCConnect;
import entity.Customer;
import entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DashboardModel {
    public List<? extends Product> getDataProduct() {
        Product product;
        InputStream inputStream;
        OutputStream outputStream;
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT *, category.Name as cateName, supplier.Name as supName\n" +
                "FROM product \n" +
                "join category on product.Category_ID = category.Category_ID\n" +
                "join supplier on product.Supplier_ID = supplier.Supplier_ID\n" +
                "Where Is_deleted = 0 order by product.Product_ID asc";
        try (Connection connection = ConnectDTB.getJDBCConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                product = new Product();
                product.setProductID(resultSet.getInt("Product_ID"));
                product.setProductName(resultSet.getString("Name"));
                product.setSellPrice((long) resultSet.getDouble("Sell_price"));
                product.setImportPrice((long) resultSet.getDouble("Import_price"));
                product.setQuantity(resultSet.getInt("Quantity"));
                product.setCategory(resultSet.getString("cateName"));
                product.setSupplierName(resultSet.getString("supName"));
                inputStream = resultSet.getBinaryStream("Image");
                outputStream = new FileOutputStream(new File(product.getProductName() + ".jpg"));
                byte[] content = new byte[1024];
                int size = 0;
                while ((size = inputStream.read(content)) != -1) {
                    outputStream.write(content, 0, size);
                }
                productList.add(product);
                outputStream.close();
                inputStream.close();
            }
            if (productList.isEmpty()) {
                return null;
            } else
                return productList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProduct(int productId) {
        String sql = "UPDATE `product` SET `Is_deleted` = '1' WHERE (`Product_ID` = ?)";
        try (Connection connection = ConnectDTB.getJDBCConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, productId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int CustomerID) throws SQLException {
        String sql = "update projectv4.Client set Is_deleted = '1' where(`Client_ID` = ?)";
        Connection con = JDBCConnect.Connect();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, CustomerID);
        ps.executeUpdate();
    }

    public Product getProduct(String name) {
        Product product;
        String sql = "SELECT *, project.category.Name as cateName, project.supplier.Name as supName\n" +
                "FROM project.product \n" +
                "join project.category on product.Category_ID = category.Category_ID\n" +
                "join project.supplier on product.Supplier_ID = supplier.Supplier_ID\n" +
                "Where product.Name = ? and Is_deleted = '0'";
        try (Connection connection = ConnectDTB.getJDBCConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = new Product();
                product.setProductID(resultSet.getInt("Product_ID"));
                product.setProductName(resultSet.getString("Name"));
                product.setSellPrice((long) resultSet.getDouble("Sell_price"));
                product.setImportPrice((long) resultSet.getDouble("Import_price"));
                product.setCategory(resultSet.getString("cateName"));
                product.setQuantity(resultSet.getInt("Quantity"));
                product.setSupplierName(resultSet.getString("supName"));
                return product;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public boolean createPro(Product product) {
//
//
//        String sql = "INSERT INTO `project`.`product` (`Name`, `Sell_price`, `Import_price`, `Quantity`, `Category_ID`) VALUES (?, ?, ?, 0, ?)";
//        try (Connection connection = ConnectDTB.getJDBCConnect();
//             PreparedStatement pre = connection.prepareStatement(sql)) {
//            pre.setString(1, product.getProductName());
//            pre.setDouble(2, product.getSellPrice());
//            pre.setDouble(3,product.getImportPrice());
//            pre.setInt(4,product.getQuantity());
//            pre.setInt(5,product.getCategory()
//            pre.execute();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    public ObservableList<Customer> getDataCustomerList() throws SQLException {
        ObservableList<Customer> CustomerList = FXCollections.observableArrayList();
        String sql = "select * from projectv4.client ";
        Connection con = JDBCConnect.Connect();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int customerID = rs.getInt("Client_ID");
            String customerName = rs.getString("Name");
            String customerAddress = rs.getString("Address");
            String customerPhoneNum = rs.getString("Phone");
            String customerEmail = rs.getString("Email");
            Customer tempCustomer = new Customer(customerID, customerName, customerAddress, customerPhoneNum, customerEmail);
            CustomerList.add(tempCustomer);
        }
        return CustomerList;
    }

    public Customer getDataCustomer(int customerID) throws SQLException {

        String sql = "select * from projectv4.client where `Client_ID` = ? ";
        Connection con = JDBCConnect.Connect();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, customerID);
        ResultSet rs = ps.executeQuery();
        Customer tempCustomer = null;
        while (rs.next()) {
            String customerName = rs.getString("Name");
            String customerAddress = rs.getString("Address");
            String customerPhoneNum = rs.getString("Phone");
            String customerEmail = rs.getString("Email");
            tempCustomer = new Customer(customerID, customerName, customerAddress, customerPhoneNum, customerEmail);

        }
        return tempCustomer;
    }

    public void updateCustomer(String customerName, String customerAddress, String customerPhoneNum, String customerEmail, int customerID) throws SQLException {
        String sql = "UPDATE `projectv4`.`client` SET `Name` = ?, `Address` = ?, `Phone` = ?, `Email` = ? WHERE (`Client_ID` = ? )";
        Connection con = JDBCConnect.Connect();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, customerName);
        ps.setString(2, customerAddress);
        ps.setString(3, customerPhoneNum);
        ps.setString(4, customerEmail);
        ps.setInt(5, customerID);
        ps.executeUpdate();


    }

}
