package org.example.DAO;


import org.example.Entities.Sucker;
import org.example.Services.SuckerService;
import org.example.Utils.SQLConnector;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuckerDaoImplementation implements SuckerDao{

    @Override
    public int insertSucker() {
        return 0;
    }

    @Override
    public int insertSucker(Sucker sucker) {
        int status = 0;
        try (Connection con = SQLConnector.dbConnection();){
            String sql = "insert into suckers (money,name,address,banned) values (?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setDouble(1,sucker.getMoney());
            stm.setString(2,sucker.getName());
            stm.setString(3,sucker.getAddress());
            stm.setString(4,sucker.getBanned());

            stm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Sucker> getAllSuckers() {
        List<Sucker> suckers = new ArrayList<>();
        try (Connection con = SQLConnector.dbConnection()){
            String sql = "select * from suckers";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet resultD = stm.executeQuery();

            while (resultD.next()){
                Sucker s = new Sucker();
                s.setId(resultD.getInt(1));
                s.setMoney(resultD.getDouble(2));
                s.setName(resultD.getString(3));
                s.setAddress(resultD.getString(4));
                s.setBanned(resultD.getString(5));
                suckers.add(s);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return suckers;
    }

    @Override
    public int updateSucker(int id, Sucker updateSucker) {
        int status = 0;
        try (Connection con = SQLConnector.dbConnection()) {
            String sql = "update suckers set money=? , name=? , address=? , banned=? where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setDouble(1,updateSucker.getMoney());
            stm.setString(2,updateSucker.getName());
            stm.setString(3,updateSucker.getAddress());
            stm.setString(4,updateSucker.getBanned());
            stm.setInt(5,id);

            status = stm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return status;
    }

    @Override
    public int deleteSucker(int id) {
        int status =0;
        try (Connection con = SQLConnector.dbConnection()){
            String sql = "delete from suckers where id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1,id);
            status = stm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return status;
    }

    public SuckerService retrieveSucker(int id) {
        SuckerService s = new SuckerService();
        try (Connection con = SQLConnector.dbConnection()){
            String sql = "select * from suckers where id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1,id);
            ResultSet resultD = stm.executeQuery();

            while (resultD.next()){
                s.setId(resultD.getInt(1));
                s.setMoney(resultD.getDouble(2));
                s.setName(resultD.getString(3));
                s.setAddress(resultD.getString(4));
                s.setBanned(resultD.getString(5));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return s;
    }
}
