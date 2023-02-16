package dao.iml;

import dao.CityDao;
import dao.jdbs.ConnectionManager;
import model.City;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements CityDao {
    private static final  String FIND_ALL ="SELECT * FROM city";
    private static final  String INSERT ="INSERT INTO city (city_name) VALUES(?)";
    private  static  final  String DELETED ="DELETE FROM city WHERE id = (?)";
    private  static  final  String getById ="SELECT * FROM city WHERE city_id=(?)";
    @Override
    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try(Connection connection = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()){
                City city = new City(resultSet.getInt("city_id"),
                        resultSet.getString("city_name")
                );
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public City add(City city) {
        try(Connection connection = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT)){
            preparedStatement.setString(1, city.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleted(int id) {
        try(Connection connection = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETED)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public City getById(int id) {
        City city = new City();
        try(Connection connection = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(getById)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                city.setName(resultSet.getString("city_name"));
                city.setId(resultSet.getInt("city_id"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }
}
