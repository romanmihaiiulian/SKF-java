package com.skf;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mihairoman on 04/12/2016.
 */
@RestController
public class InitServices {

    @RequestMapping(value ="/firstCall")
    public Response insert() {

        List<String> firstNameList = new ArrayList<>();
        firstNameList.add("1firstName");
        firstNameList.add("2firstName");
        firstNameList.add("3firstName");
        firstNameList.add("4firstName");
        firstNameList.add("5firstName");

        List<String> lastNameList = new ArrayList<>();
        lastNameList.add("1lastName");
        lastNameList.add("2lastName");
        lastNameList.add("3lastName");
        lastNameList.add("4lastName");
        lastNameList.add("5lastName");



        for (int i = 0; i < firstNameList.size(); i++) {
            Connection connection = getDataBaseConnection();
            Statement statement = null;
            try {
                statement = connection.createStatement();
                Boolean result = null;
                try {
                    String sql = "INSERT INTO USER VALUES('" + Long.valueOf(i)+ "','" + firstNameList.get(i).toString() + "', '" + lastNameList.get(i).toString() + "' ) ";
                    result = statement.execute(sql);
                } catch (SQLException e) {
                    e.printStackTrace();
                    return Response.serverError().build();
                }

            } catch (SQLException exception) {
                exception.printStackTrace();
            } finally {
                if (null != statement) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        return Response.serverError().build();
                    }
                }
                if (null != connection) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        return Response.serverError().build();
                    }
                }
            }
        }


        return Response.ok("DONE").build();
    }

    @RequestMapping(value = "/query")
    public String getQuery() {

        Connection connection = getDataBaseConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet result = null;
            try {
                result = statement.executeQuery("SELECT * FROM USER");
                System.out.println("=====" + result.next());
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (null != result) {
                    result.close();
                }
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            if (null != statement) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null!= connection) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return "query";
    }

    public static Connection getDataBaseConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:h2:file:~/query", "sa", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

}
