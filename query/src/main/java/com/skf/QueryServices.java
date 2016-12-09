package com.skf;

import com.skf.com.skf.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by mihairoman on 06/12/2016.
 */
@RestController
public class QueryServices {

    @RequestMapping(value = "readAll", method = RequestMethod.GET)
    public Response getAllEntities() {

        List<User> users = new ArrayList<>();

        Connection connection = InitServices.getDataBaseConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USER");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setId(id);
                users.add(user);
                System.out.println(id + "  " + firstName+"   "+lastName);
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return Response.ok(users).build();
    }

    @RequestMapping(value = "readById/{id}", method = RequestMethod.GET)
    public Response getEntityById(@PathVariable Long id) {

        User user = null;

        Connection connection = InitServices.getDataBaseConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USER WHERE id = ?");

            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");

                user = new User();

                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setId(id);
                System.out.println(id + "  " + firstName+"   "+lastName);
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (user != null) {
            return Response.ok(user).build();
        } else {
            return Response.serverError().entity("invalid user").build();
        }
    }

    @RequestMapping(value = "readByFirstName/{firstName}", method = RequestMethod.GET)
    public Response getEntityByFirstName(@PathVariable String firstName) {

        User user = null;

        Connection connection = InitServices.getDataBaseConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USER WHERE FIRST_NAME = ?");

            statement.setString(1, firstName);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Long id = rs.getLong("id");
                String lastName = rs.getString("LAST_NAME");

                user = new User();

                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setId(id);
                System.out.println(id + "  " + firstName+"   "+lastName);
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (user != null) {
            return Response.ok(user).build();
        } else {
            return Response.serverError().entity("invalid user").build();
        }
    }

    @RequestMapping(value = "readByLastName/{lastName}", method = RequestMethod.GET)
    public Response getEntityByLastName(@PathVariable String lastName) {

        User user = null;

        Connection connection = InitServices.getDataBaseConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USER WHERE LAST_NAME = ?");

            statement.setString(1, lastName);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Long id = rs.getLong("id");
                String firstName = rs.getString("FIRST_NAME");

                user = new User();

                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setId(id);
                System.out.println(id + "  " + firstName+"   "+lastName);
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (user != null) {
            return Response.ok(user).build();
        } else {
            return Response.serverError().entity("invalid user").build();
        }
    }

}
