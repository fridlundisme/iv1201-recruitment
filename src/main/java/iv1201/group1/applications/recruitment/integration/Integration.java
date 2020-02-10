package iv1201.group1.applications.recruitment.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class Integration {
    public static String select() {
        DbConfig db = new DbConfig();
        BasicDataSource bdbc = db.dataSource();

        try {
            Connection con = bdbc.getConnection();
            // PreparedStatement pstmt;
            // con.setAutoCommit(false);
            // pstmt = con.prepareStatement("SELECT * FROM webapplication.role");
            // ResultSet rs = pstmt.executeQuery();
            // con.commit();
            // pstmt.close();
            // String s = rs.getString(0) + " " + rs.getString(1);
            String h = "JJJ";
            return h;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }
    }
}