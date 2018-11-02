package salary;

import java.util.HashMap;
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
}
