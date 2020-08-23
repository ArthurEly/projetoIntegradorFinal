package br.com.senac.pif_mobile.util;

import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import br.com.senac.pif_mobile.User;

public class SQLUtils {
    /**
     * Pega um usuário do banco de dados.
     * Tente executar essa função dentro de outro processo ou <code>Thread</code> assim
     * o app não vai travar durante a conexão via SQL.
     *
     * @param sqlconn
     * @param user_name
     * @param user_password
     * @return o primeiro usuario da lista SQL
     */
    @Nullable public static User getUser(@NotNull Connection sqlconn, String user_name, String user_password) {
        try {
            System.out.println(String.valueOf(sqlconn));
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
            return new User(-1,null,null,null,null,null,null);
        }
    }

    /**
     * Pega uma lista de 1000 usuários do banco de dados (1000 é o numero máximo no MySQL).
     * Tente executar essa função dentro de outro processo ou <code>Thread</code> assim
     * o app não vai travar durante a conexão via SQL.
     *
     * @param sqlconn
     * @return ArrayList<User>
     */
    @NotNull public static ArrayList<User> getUserList(@NotNull Connection sqlconn) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ul;
    }

    /**
     * Cria um usuário dentro do banco de dados.
     * Tente executar essa função dentro de outro processo ou <code>Thread</code> assim
     * o app não vai travar durante a conexão via SQL.
     *
     * @param sqlconn
     * @param user
     * @return
     */
    public static boolean insertUser(@NotNull Connection sqlconn, @NotNull User user) {
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
