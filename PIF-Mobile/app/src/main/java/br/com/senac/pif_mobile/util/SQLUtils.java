package br.com.senac.pif_mobile.util;

import org.intellij.lang.annotations.Language;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import br.com.senac.pif_mobile.User;

public class SQLUtils {
    public static User getUser(Connection sqlconn, String user_name, String user_password) {
        try {
            ResultSet set = sqlconn.prepareStatement("SELECT * FROM users WHERE user_name=\"" + user_name + "\" AND user_password=\"" + user_password + "\"").executeQuery();
            set.first();
            User.PersonaType persona;
            User.Location location = new User.Location(set.getString("user_city"),set.getString("user_state"),set.getString("user_country"),set.getString("user_street"),set.getInt("user_number"),set.getString("user_cep"));

            if (set.getBoolean("user_operator")) {
                persona = new User.PersonaType(set.getBoolean("user_operator"), set.getString("user_cnpj"));
            } else {
                persona = new User.PersonaType(set.getBoolean("user_operator"), set.getString("user_cpf"));
            }

            User u = new User(persona,set.getString("user_name"),set.getString("user_email"),location,new Date(set.getDate("user_birth").getYear(),set.getDate("user_birth").getMonth(),set.getDate("user_birth").getDay()),set.getString("user_password"));

            return u;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<User> getUserList(Connection sqlconn) {
        ArrayList<User> ul = new ArrayList<User>();
        try {
            ResultSet set = sqlconn.prepareStatement("SELECT * FROM users").executeQuery();
            set.first();
            while (!set.isAfterLast()) {
                User.PersonaType persona;
                User.Location location = new User.Location(set.getString("user_city"),set.getString("user_state"),set.getString("user_country"),set.getString("user_street"),set.getInt("user_number"),set.getString("user_cep"));

                if (set.getBoolean("user_operator")) {
                    persona = new User.PersonaType(set.getBoolean("user_operator"), set.getString("user_cnpj"));
                } else {
                    persona = new User.PersonaType(set.getBoolean("user_operator"), set.getString("user_cpf"));
                }

                User u = new User(persona,set.getString("user_name"),set.getString("user_email"),location,new Date(set.getDate("user_birth").getYear(),set.getDate("user_birth").getMonth(),set.getDate("user_birth").getDay()),set.getString("user_password"));
                ul.add(u);
            }
            return ul;
        } catch (SQLException e) {
            e.printStackTrace();
            return ul;
        }
    }

    public static boolean insertUser(Connection sqlconn, User user) {
        try {
            ResultSet set = sqlconn.prepareStatement("INSERT INTO `users`(" +
                    "   `user_id`, `user_cpf`, `user_cnpj`, `user_name`," +
                    "   `user_email`, `user_city`, `user_state`, `user_country`," +
                    "   `user_street`, `user_number`, `user_cep`, `user_operator`," +
                    "   `user_birth`, `user_password`" +
                    ") VALUES (" +
                    "   DEFAULT,\"" + user.getCpf() + "\",\"" + user.getCnpj() + "\",\"" + user.getName() + "\"," +
                    "   \"" + user.getEmail() + "\",\"" + user.getCity() + "\",\"" + user.getState() + "\",\"" + user.getCountry() + "\"," +
                    "   \"" + user.getStreet() + "\"," + user.getNumber() + ",\"" + user.getCep() + "\"," + String.valueOf(user.isOperator()) + "," +
                    "   \"" + user.getBirthSQL() + "\",\"" + user.getPassword() + "\"" +
                    ")").executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
