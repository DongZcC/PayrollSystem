package salary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayrollDatabase {

    private static Map<Integer, Employee> employeeMap = new HashMap<>();

    private static Map<Integer, Employee> memberMap = new HashMap<>();

    public static void addEmployee(int empId, Employee employee) {
        employeeMap.put(empId, employee);
    }

    public static Employee getEmployee(int empId) {
        return employeeMap.get(empId);
    }

    public static void deleteEmployee(int empId) {
        employeeMap.remove(empId);
    }

    public static Employee getUnionMember(int memberId) {
        return memberMap.get(memberId);
    }

    public static void addUnionMember(int memberId, Employee e) {
        memberMap.put(memberId, e);
    }

    public static void removeUnionMember(int memberId) {
        memberMap.remove(memberId);
    }

    public static List<Employee> getEmployees() {
        List<Employee> result = new ArrayList<>();
        employeeMap.forEach((k, v) -> result.add(v));
        return result;
    }
}
