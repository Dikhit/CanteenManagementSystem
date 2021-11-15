package Services;

import DAO.DAO;
import Models.Product;
import Models.User;

import java.sql.*;
import java.util.ArrayList;

public class ProductsServices {
    public static boolean createProduct(Product product) {
        try{
            Connection connection = DAO.DBConnection();
            String sql = "insert into products (id, name, price, description, vendorID) values(?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, product.getId());
            ps.setString(2, product.getName());
            ps.setString(3, String.valueOf(product.getPrice()));
            ps.setString(4, product.getDescription());
            ps.setString(5, product.getVendorID());
            ps.execute();
            return true;
        }
        catch (SQLException error){
            System.out.println(error.getMessage());
        }

        return false;
    }

    public static ArrayList<Product> getProductByUser(User currentUser) {
        String sqlQuery = "select * from products where vendorID = '" + currentUser.getId() + "';";
        ArrayList<Product> products = new ArrayList<>();
        try{
            Connection conn = DAO.DBConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                int price = resultSet.getInt(3);
                String description = resultSet.getString(4);
                String vendorID = resultSet.getString(5);
                String date = resultSet.getString("createdAt").toString();
                products.add(new Product(id, name, price, description, vendorID, date));
            }
            return products;
        }
        catch (SQLException error){
            error.printStackTrace();
        }
        return products;
    }

    public static Product updateProduct(Product product, User currentUser) {
        if (!product.getVendorID().equals(currentUser.getId())){
            return null;
        }

        String sqlQuery = "update products set name = ?, price = ?, description = ? where id = ?";
        try{
            Connection connection = DAO.DBConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getId());

            preparedStatement.execute();
            return product;
        }
        catch (SQLException error){
            System.out.println(error.getMessage());
        }
        return null;
    }

    public static ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        String sqlQuery = "select * from products;";
        try{
            Connection connection = DAO.DBConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                int price = resultSet.getInt(3);
                String description = resultSet.getString(4);
                String vendorID = resultSet.getString(5);
                String date = resultSet.getString("createdAt").toString();
                products.add(new Product(id, name, price, description, vendorID, date));
            }
        }
        catch (SQLException error){
            error.printStackTrace();
        }

        return products;
    }

    public static Product getProductById(String productID) {
        String sqlQuery = "select * from products where id = '" + productID + "';";
        try{
            Connection connection = DAO.DBConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if(resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String description = resultSet.getString("description");
                String vendorID = resultSet.getString("vendorID");
                String date = resultSet.getString("createdAt");
                return new Product(id, name, price, description, vendorID, date);
            }
        }
        catch (SQLException error){
            System.out.println(error.getMessage());
        }
        return null;
    }
}
