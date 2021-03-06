package DAO;

import Model.Taikhoan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
    public static Taikhoan getData(String user, String pass) {
        try {
            Taikhoan taikhoan = null;
            Connection connection = Datahepler.openConnection();
            String sql = "select * from account where taikhoan = ? And matkhau = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user);
            statement.setString(2, pass);
            ResultSet rs = statement.executeQuery();
            while ((rs.next())) {
                taikhoan = new Taikhoan();
                taikhoan.setId(rs.getInt("id"));
                taikhoan.setTaikhoan(rs.getString("taikhoan"));
                taikhoan.setMatkhau(rs.getString("matkhau"));
            }

            connection.close();
            statement.close();
            return taikhoan;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
