package DAO;

import Model.KTX;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuanliDao {
    public void Add(KTX ktx){
        try{
            Connection connection = Datahepler.openConnection();
            String sql = "insert into ktx(masv, tensv, lop, sdt, sophong, tinhtrang) values (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ktx.getMasv());
            statement.setString(2, ktx.getName());
            statement.setString(3, ktx.getLop());
            statement.setInt(4, ktx.getSdt());
            statement.setString(5, ktx.getSophong());
            statement.setString(6, ktx.getTinhtrang());
            statement.executeUpdate();
            connection.close();
            statement.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void Edit(KTX ktx){
        try {
            Connection connection = Datahepler.openConnection();
            String sql = "update ktx set masv = ?, tensv = ? , lop = ?, sdt = ?, sophong = ?, tinhtrang = ? where masv = ?";
            PreparedStatement statement  = connection.prepareStatement(sql);
            statement.setString(1, ktx.getMasv());
            statement.setString(2, ktx.getName());
            statement.setString(3, ktx.getLop());
            statement.setInt(4, ktx.getSdt());
            statement.setString(5, ktx.getSophong());
            statement.setString(6, ktx.getTinhtrang());
            statement.setString(7, ktx.getMasv());
            statement.executeUpdate();
            connection.close();
            statement.close();
        }
        catch (Exception e){

        }
    }

    public  void delete(String masv)
    {
        try {
            Connection connection = Datahepler.openConnection();
            String sql = "delete from ktx where masv = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, masv);
            statement.execute();
            connection.close();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public KTX getBYID(String masv){
        try {
            Connection connection = Datahepler.openConnection();
            String sql = "select * from ktx where masv = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, masv);
            ResultSet rs = statement.executeQuery();
            KTX ktx = new KTX();
            while (rs.next()){
                ktx.setMasv(rs.getString(1));
                ktx.setName(rs.getString(2));
                ktx.setLop(rs.getString(3));
                ktx.setSdt(rs.getInt(4));
                ktx.setSophong(rs.getString(5));
                ktx.setTinhtrang(rs.getString(6));
                return ktx;
            }
            connection.close();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<KTX> getByName(String name){
        try{
            Connection connection = Datahepler.openConnection();
            String sql = "select * from ktx where tensv like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+name+"%");
            ResultSet rs = statement.executeQuery();
            List<KTX> list = new ArrayList<>();
            while (rs.next()){
                KTX ktx = new KTX();
                ktx.setMasv(rs.getString(1));
                ktx.setName(rs.getString(2));
                ktx.setLop(rs.getString(3));
                ktx.setSdt(rs.getInt(4));
                ktx.setSophong(rs.getString(5));
                ktx.setTinhtrang(rs.getString(6));
                list.add(ktx);
            }
            return list;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
