package Services;

import DAO.DAO;
import Models.User;

import java.sql.*;
import java.util.ArrayList;

public class UserServices {

    public static User logIn(String email, String password) {
        try{
            Connection conn = DAO.DBConnection();
            String sqlQuery = "select * from users where email = '" + email +"' and password = '" + password +"';";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while(resultSet.next()){
                String id = resultSet.getString(1);
                String userName = resultSet.getString(2);
                String userEmail = resultSet.getString(3);
                int walletPrice = resultSet.getInt(4);
                String userPassword = resultSet.getString(5);
                String role = resultSet.getString(6);
                User curUser = new User(id, userName, userEmail, walletPrice, userPassword, role);
                return curUser;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User customerRegister(User user){
        try{
            Connection conn = DAO.DBConnection();
            String sqlQuery = "insert into users (id, name, email, walletPrice, password, role) values(?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setString(4, String.valueOf(user.getWalletPrice()));
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getRole());

            ps.execute();
            return user;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static boolean vendorRegister(User user){
        try{
            Connection conn = DAO.DBConnection();
            String sqlQuery = "insert into users (name, email, password, role) values(?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, String.valueOf(user.getRole()));

            ps.execute();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public static User updateProfile(User user){
        Connection conn = null;
        try {
            conn = DAO.DBConnection();
            String sqlQuery = "update users set name = ?, email = ?, walletPrice = ?, password = ?, role = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, String.valueOf(user.getWalletPrice()));
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole());
            ps.setString(6, user.getId());

            ps.execute();
            return user;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public static User updateWallet(User user, int newAmount) {
        int newWalletAmount = Integer.valueOf(user.getWalletPrice()) + newAmount;
        user.setWalletPrice(newWalletAmount);
        return user;
    }

    public static User getUserByID(String userID) throws SQLException {
        String sqlQuery = "select * from users where id = '" + userID + "';";
        Connection connection = DAO.DBConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        if(resultSet.next()){
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int walletPrice = resultSet.getInt("walletPrice");
            String role = resultSet.getString("role");
            String password = resultSet.getString("password");

            return new User(id, name, email, walletPrice, password, role);
        }

        return null;
    }

    public static ArrayList<User> getAllUser(User currentUser) {
        ArrayList<User> users = new ArrayList<>();
        String sqlQuery = "select * from users;";

        try{
            Connection connection = DAO.DBConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while(resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int walletPrice = resultSet.getInt("walletPrice");
                String role = resultSet.getString("role");
                String password = resultSet.getString("password");
                users.add(new User(id, name, email, walletPrice, password, role));
            }
        }
        catch (SQLException error){
            System.out.println(error.getMessage());
        }
        return users;
    }
}
