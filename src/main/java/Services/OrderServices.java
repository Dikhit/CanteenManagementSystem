package Services;

import DAO.DAO;
import Models.Order;
import Models.Product;
import Models.User;

import java.sql.*;
import java.util.ArrayList;

public class OrderServices {
    public static boolean handleNewOrder(Order order) {
        try{
            Connection connection = DAO.DBConnection();
            String sqlQuery = "insert into orders (id, buyer, product, quantity) values(?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, order.getId());
            ps.setString(2, order.getCustomerID());
            ps.setString(3, order.getProductID());
            ps.setString(4, String.valueOf(order.getQuantity()));

            ps.execute();
            return true;
        }
        catch (SQLException error){
            error.printStackTrace();
        }

        return false;
    }

    public static ArrayList<ArrayList<String>> getAllOrdersByUser(User currentUser) {
        String sqlQuery = "select * from orders where buyer = '" + currentUser.getId() + "';";
        ArrayList<ArrayList<String>> orders = new ArrayList<>();
        try{
            Connection connection = DAO.DBConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String productID = resultSet.getString("product");
                int quantity = resultSet.getInt("quantity");

                Product product = ProductsServices.getProductById(productID);
                if (product != null){
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(id);
                    temp.add(product.getName());
                    temp.add(product.getDescription());
                    temp.add(String.valueOf(product.getPrice()));
                    temp.add(String.valueOf(quantity));
                    orders.add(temp);
                }
            }
            return orders;
        }
        catch (SQLException error){
            System.out.println(error.getMessage());
        }
        return  orders;
    }

    public static ArrayList<ArrayList<String>> getAllOrders(User currentUser) {
        ArrayList<ArrayList<String>> orders = new ArrayList<>();
        if (currentUser.getRole().equals("VENDOR") || currentUser.getRole().equals("CUSTOMER")){
            System.out.println("Access denied !!");
            return orders;
        }
//        ArrayList<ArrayList<String>> orders = new ArrayList<>();
        String sqlQuery = "select * from orders;";
        try{
            Connection connection = DAO.DBConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String productID = resultSet.getString("product");
                int quantity = resultSet.getInt("quantity");
                String buyer = resultSet.getString("buyer");

                Product product = ProductsServices.getProductById(productID);
                User customer = UserServices.getUserByID(buyer);
                if (product != null) {
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(id);
                    temp.add(product.getName());
                    temp.add(product.getDescription());
                    temp.add(String.valueOf(product.getPrice()));
                    temp.add(String.valueOf(quantity));
                    temp.add(customer.getName());
                    temp.add(customer.getEmail());
                    orders.add(temp);
                }
            }
            return orders;
        }
        catch (SQLException error){
            System.out.println(error.getMessage());
        }
        return orders;
    }

}
