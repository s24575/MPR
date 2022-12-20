package employeeTest;

import employee.Employee;
import employee.EmployeePresenter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class EmployeePresenterTest {
    @Test
    public void presentEmployeesTest(){
        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee("Jan", "Kowalski", "manager");
        Employee employee2 = new Employee("Beata", "Wysocka", "pracownik");
        Employee employee3 = new Employee("Marian", "Nowak", "pracownik");


    }
}
