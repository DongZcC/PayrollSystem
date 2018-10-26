package salary;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {

    private static Map<Integer, Employee> employeeMap = new HashMap<>();

    public static void addEmployee(int empId, Employee employee) {
        employeeMap.put(empId, employee);
    }


    public static Employee getEmployee(int empId) {
        return employeeMap.get(empId);
    }
}
