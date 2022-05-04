package net.RestaurantManager.GUI;
import java.sql.*;

public class Main {
    public void getSysdate(){
        String databaseFile = "demo.sqlite";
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + databaseFile;
            conn = DriverManager.getConnection(url);
            String sql = "select date('now') as sysdate";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                System.out.println("Today: " + rs.getString("sysdate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new Main().getSysdate();
    }
}