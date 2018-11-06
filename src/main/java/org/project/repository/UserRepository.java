package org.project.repository;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class UserRepository {

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        System.out.println("Okay lets try it out");

//        userCreate();
//        userUpdate();
//        userDelete();
        userRead();
    }

    // WITH THIS METHOD YOU CAN CREATE A FULL ROW IN A TABLE


    public static void userCreate() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        final String URL = "jdbc:postgresql://54.93.65.5:5432/sandor";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        PreparedStatement pSt = conn.prepareStatement("INSERT INTO public.\"User\" (id, name, password, gender, address, \"telephoneNumber\") VALUES (?, ?, ?, ?, ?, ?)");
        pSt.setString(1, "2");
        pSt.setString(2, "Peter");
        pSt.setString(3, "welldone");
        pSt.setString(4, "F");
        pSt.setString(5, "Cluj-Napoca, Rebreanu 15, AP 30");
        pSt.setString(6, "074525607");

        int rowsInserted = pSt.executeUpdate();
        System.out.println(rowsInserted + " row(s) were inserted.");


        pSt.close();
        conn.close();
    }


    // WITH THIS METHOD YOU CAN UPDATE / MODIFY DATA IN A TABLE!


    private static void userUpdate() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        final String URL = "jdbc:postgresql://54.93.65.5:5432/sandor";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        PreparedStatement pSt = conn.prepareStatement("UPDATE public.\"User\" SET name=?, address=?, \"telephoneNumber\"=? WHERE id='2';");
        pSt.setString(1, "Alexandra");
        pSt.setString(2, "Sibiu, 21 Decembrie, 27");
        pSt.setString(3, "0740405123");

        int rowsUpdated = pSt.executeUpdate();
        System.out.println(rowsUpdated + " row(s) were updated.");

        pSt.close();
        conn.close();
    }

    // WITH THIS METHOD YOU CAN DELETE A FULL ROW IN A TABLE


    private static void userDelete() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        final String URL = "jdbc:postgresql://54.93.65.5:5432/sandor";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        PreparedStatement pSt = conn.prepareStatement("DELETE FROM public.\"User\" WHERE name=?");
        pSt.setString(1, "Alexandra");

        int rowsDeleted = pSt.executeUpdate();
        System.out.println(rowsDeleted + " rows were deleted.");

        pSt.close();
        conn.close();
    }

    private static List userRead() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");


        final String URL = "jdbc:postgresql://54.93.65.5:5432/sandor";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("SELECT name, password FROM public.\"User\"");

        List<Users> listOfUsers = new ArrayList();
        while (rs.next()) {
            Users u = new Users();
            u.setUsername(rs.getString("name").trim());
            u.setPassword(rs.getString("password").trim());

            listOfUsers.add(u);
        }

        rs.close();
        st.close();
        conn.close();

        return listOfUsers;

    }
}