package dao;

import model.City;
import model.Employee;

import java.util.List;

public interface CityDao {
    List<City> findAll();

    City add(City city);
    void deleted(int id);
    City getById(int id);
}
