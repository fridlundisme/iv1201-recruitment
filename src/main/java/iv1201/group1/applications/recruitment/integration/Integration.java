package iv1201.group1.applications.recruitment.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class Integration {
    public void select() {
        DbConfig db = new DbConfig();
        BasicDataSource bdbc = db.dataSource();

        try {
            Connection con = bdbc.getConnection();
            PreparedStatement pstmt;
            con.setAutoCommit(false);
            pstmt = con.prepareStatement("SELECT * FROM webapplication.role");
            ResultSet rs = pstmt.executeQuery();
            con.commit();
            pstmt.close();
            
            System.out.println(rs.next());  
            System.out.println(rs.next());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}