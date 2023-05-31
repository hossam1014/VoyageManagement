
package main_page.Handlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import main_page.Models.User;
import main_page.SqlLiteDB;

/**
 *
 * @author hossam
 */
public class LoginHandler implements EventHandler<ActionEvent> {
    
    
    private Connection connection;
    private PreparedStatement prepare;
    private ResultSet result;
    
    private String UserName;
    private String Password;
    
//    private int userId;
    
    private User loggedUser;
    
    private boolean isLoggedIn = false;

    public LoginHandler(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    @Override
    public void handle(ActionEvent event) {

        try {
            connection = SqlLiteDB.connectDB();
            String sql = "SELECT * FROM Users WHERE UserName = ? AND Password = ?";

            prepare = connection.prepareStatement(sql);

            prepare.setString(1, UserName);
            prepare.setString(2, Password);

            result = prepare.executeQuery();

            if (UserName.isEmpty() || Password.isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("please fill all blank fields");
                alert.showAndWait();

            } else {

                if (result.next()) {
                    System.out.println(result.getString("FullName"));
                    this.loggedUser = new User(result.getInt("Id"),
                            result.getString("UserName"), result.getString("FullName"),
                            result.getString("Email"), result.getString("PhoneNumber"),
                            result.getString("Password"), result.getBoolean("IsAdmin"));
                    
                    isLoggedIn = true;

                    SqlLiteDB.closeConnection(connection);
                } else {
                    // User does not exist in database, show error message
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid username or password");
                    alert.showAndWait();
                    SqlLiteDB.closeConnection(connection);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public User getUser() {
        return loggedUser;
    }
    
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}
