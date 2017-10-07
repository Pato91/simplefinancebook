/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dios.finance;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author meraki
 */
public class merakiBusinessDBClass {

    Connection connection;
    Statement statement;
    String driver;
    String url;
    String username;
    String password;
    JSONObject selectQRTemp;
    JSONObject selectQResults;
    ArrayList<ArrayList<String>> outPutArrayList;
    ArrayList<String> selectQRTempArr;

    public void createDataBase() throws SQLException {
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost/?autoReconnect=true&useSSL=false";
        username = "root";
        password = "Ark2016!?veron";

        connection = DriverManager.getConnection(url, username, password);

        statement = connection.createStatement();

        statement.addBatch(
                "SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;");
        statement.addBatch(
                "SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;");
        statement.addBatch(
                "SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';");
        statement.addBatch(
                "CREATE SCHEMA IF NOT EXISTS `diosfinance` DEFAULT CHARACTER SET utf8;");
        statement.addBatch(" USE `diosfinance`;");
        statement.addBatch("CREATE TABLE IF NOT EXISTS `diosfinance`.`users` (`userid` INT UNSIGNED NOT NULL"
                + " AUTO_INCREMENT, `username` VARCHAR(45) NOT NULL, `first_name` VARCHAR(45) NULL,"
                + " `last_name` VARCHAR(45) NULL, `password` VARCHAR(200) NOT NULL, `status` INT NULL, "
                + "`created_on` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP, PRIMARY KEY (`userid`)) ENGINE = InnoDB;");

        statement.addBatch("CREATE TABLE IF NOT EXISTS `diosfinance`.`revenue` ( `revenue_id` BIGINT UNSIGNED NOT NULL "
                + "AUTO_INCREMENT, `patient_name` VARCHAR(45) NOT NULL, `phone_number` VARCHAR(45) NULL, "
                + "`address` VARCHAR(45) NULL, `medical_condition` VARCHAR(45) NULL, `charge` DECIMAL(20,2) NULL DEFAULT 0.00, "
                + "`date_of_visit` DATE NULL, `created_on` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP, "
                + "`users_userid` INT UNSIGNED NOT NULL, PRIMARY KEY (`revenue_id`, `users_userid`), "
                + "INDEX `fk_revenue_users_idx` (`users_userid` ASC), CONSTRAINT `fk_revenue_users` "
                + "FOREIGN KEY (`users_userid`) REFERENCES `diosfinance`.`users` (`userid`) "
                + "ON DELETE NO ACTION ON UPDATE NO ACTION) ENGINE = InnoDB;");
        statement.addBatch("CREATE TABLE IF NOT EXISTS `diosfinance`.`expenses` ( `expense_id` BIGINT UNSIGNED NOT NULL "
                + "AUTO_INCREMENT, `item` VARCHAR(100) NOT NULL, `category` VARCHAR(45) NULL, `quantity` INT NULL, "
                + "`rate` DECIMAL(20,2) NULL DEFAULT 0.00, `paid_to` VARCHAR(100) NULL, `paid_on` DATE NULL, "
                + "`created_on` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP, `users_userid` INT UNSIGNED NOT NULL, "
                + "PRIMARY KEY (`expense_id`, `users_userid`), INDEX `fk_expenses_users1_idx` (`users_userid` ASC), "
                + "CONSTRAINT `fk_expenses_users1` FOREIGN KEY (`users_userid`) REFERENCES `diosfinance`.`users` (`userid`) "
                + "ON DELETE NO ACTION ON UPDATE NO ACTION) ENGINE = InnoDB;");
        
        statement.addBatch("SET SQL_MODE=@OLD_SQL_MODE;");
        statement.addBatch("SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;");
        statement.addBatch("SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;");

        statement.executeBatch();
        connection.close();
    }

    //SQL select statement processor
    public JSONObject processSQLSelect(String sqlCommand, String setItems) throws
            ClassNotFoundException, JSONException, SQLException {
        try {

            driver = "com.mysql.jdbc.Driver";
            url = "jdbc:mysql://localhost/diosfinance?autoReconnect=true&useSSL=false";
            username = "root";
            password = "Ark2016!?veron";

            selectQResults = new JSONObject();

            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);

            //Get a new statement for the current connection
            statement = connection.createStatement();

            if(setItems != null && setItems != ""){
                String[] arr = setItems.split(";");
                for(String arrVal : arr){
                    statement.execute(arrVal+ ";");
                }
                
            }
            
            //Executing SQL command
            ResultSet resultSet = statement.executeQuery(sqlCommand);

            while (resultSet.next()) {
                selectQRTemp = new JSONObject();
                for (int x = 1; x <= resultSet.getMetaData().getColumnCount();
                        x++) {
                    if (resultSet.getString(x) == null || resultSet.getString(x).isEmpty()) {
                        if(resultSet.getMetaData().getColumnLabel(x).equals(
                                "totalProf") || resultSet.getMetaData().getColumnLabel(x).equals(
                                "totalExp")){
                            selectQRTemp.put(
                                resultSet.getMetaData().getColumnLabel(x), "0.00");
                        } else
                        selectQRTemp.put(
                                resultSet.getMetaData().getColumnLabel(x), "");
                    } else if (!resultSet.getString(x).isEmpty() && resultSet.getString(x) != null) {
                        selectQRTemp.put(
                                resultSet.getMetaData().getColumnLabel(x),
                                resultSet.getString(x));
                    }
                }

                selectQResults.put("Row " + resultSet.getRow(), selectQRTemp);

            }

            connection.close();
        } catch (SQLException ex) {
            connection.close();
            ex.printStackTrace();
            Alert exceptionAlert = new Alert(Alert.AlertType.WARNING, ex + "",
                    ButtonType.OK);
            exceptionAlert.showAndWait();
        }

        return selectQResults;
    }
    
    public ArrayList<ArrayList<String>> processSQLSelectOrdered(String sqlCommand, String setItems) throws
            ClassNotFoundException, JSONException, SQLException {
        try {

            driver = "com.mysql.jdbc.Driver";
            url = "jdbc:mysql://localhost/diosfinance?autoReconnect=true&useSSL=false";
            username = "root";
            password = "Ark2016!?veron";

            outPutArrayList = new ArrayList<>();

            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);

            //Get a new statement for the current connection
            statement = connection.createStatement();

            if(setItems != null && setItems != ""){
                String[] arr = setItems.split(";");
                for(String arrVal : arr){
                    statement.execute(arrVal+ ";");
                }
                
            }
            
            //Executing SQL command
            ResultSet resultSet = statement.executeQuery(sqlCommand);

            while (resultSet.next()) {
                selectQRTempArr = new ArrayList<>();
                for (int x = 1; x <= resultSet.getMetaData().getColumnCount();
                        x++) {
                    if (resultSet.getString(x) == null || resultSet.getString(x).isEmpty()) {
                        if(resultSet.getMetaData().getColumnLabel(x).equals(
                                "totalProf") || resultSet.getMetaData().getColumnLabel(x).equals(
                                "totalExp")){
                            selectQRTempArr.add("0.00");
                        } else
                        selectQRTempArr.add("");
                    } else if (!resultSet.getString(x).isEmpty() && resultSet.getString(x) != null) {
                        selectQRTempArr.add(resultSet.getString(x));
                    }
                }

                outPutArrayList.add(selectQRTempArr);

            }

            connection.close();
        } catch (SQLException ex) {
            connection.close();
            ex.printStackTrace();
            Alert exceptionAlert = new Alert(Alert.AlertType.WARNING, ex + "",
                    ButtonType.OK);
            exceptionAlert.showAndWait();
        }

        return outPutArrayList;
    }

    public int processSQLInsert(String insertStatement) throws
            ClassNotFoundException {
        int status = 0;
        try {
            driver = "com.mysql.jdbc.Driver";
            url = "jdbc:mysql://localhost/diosfinance?autoReconnect=true&useSSL=false";
            username = "root";
            password = "Ark2016!?veron";

            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);

            //Get a new statement for the current connection
            statement = connection.createStatement();

            status = statement.executeUpdate(insertStatement);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Alert exceptionAlert = new Alert(Alert.AlertType.WARNING, ex + "",
                    ButtonType.OK);
            exceptionAlert.showAndWait();
        }
        return status;
    }

    public int processSQLUpdate(String updateStatement) throws
            ClassNotFoundException {
        int status = 0;
        try {
            driver = "com.mysql.jdbc.Driver";
            url = "jdbc:mysql://localhost/diosfinance?autoReconnect=true&useSSL=false";
            username = "root";
            password = "Ark2016!?veron";

            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);

            //Get a new statement 
            statement = connection.createStatement();

            status = statement.executeUpdate(updateStatement);

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Alert exceptionAlert = new Alert(Alert.AlertType.WARNING, ex + "",
                    ButtonType.OK);
            exceptionAlert.showAndWait();
        }
        return status;
    }
}
