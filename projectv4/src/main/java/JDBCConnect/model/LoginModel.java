package JDBCConnect.model;

import JDBCConnect.Connect.ConnectDTB;
import JDBCConnect.Connect.JDBCConnect;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    public User addminLogin(String username, String password) {
        String sql = "SELECT * FROM projectv4.account WHERE `Account_name` = ? and `Password` = ? and Is_deleted = 0";
        try (Connection connection = ConnectDTB.getJDBCConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                User user = new User();
                user.setId(res.getInt("Account_ID"));
                user.setUsername(res.getString("Account_name"));
                user.setPassword(res.getString("Password"));
                user.setName(res.getString("Name"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
