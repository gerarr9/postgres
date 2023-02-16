import dao.CityDao;
import dao.EmployeeDao;
import dao.iml.CityDaoImpl;
import dao.iml.EmployeeDaoImpl;
import model.City;
import model.Employee;

import java.sql.*;

public class Application {

    public static void main(String[] args) throws ClassNotFoundException {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        CityDao city = new CityDaoImpl();
       // employeeDao.add(new Employee("Oba","Boba","W",14));
        employeeDao.findAll().forEach(s -> System.out.println(s));
         System.out.println(employeeDao.getById(1));
        System.out.println("///////////////////////////////////////////////////////////////////");
       // city.findAll().forEach(c-> System.out.println(c));
        System.out.println(city.getById(1));
       // city.add(new City("Volgograd"));
       // employeeDao.deleted(8);
       // System.out.println(employeeDao.getById(1));

    }
}
