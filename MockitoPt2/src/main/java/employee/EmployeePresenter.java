package employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeePresenter {
    List<Employee> employeeList = new ArrayList<>();

    public EmployeePresenter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void presentEmployees() {
        for (Employee employee : employeeList ) {
            System.out.println(employee.getFullName() + ", " + employee.getPosition());
        }
    }
}
