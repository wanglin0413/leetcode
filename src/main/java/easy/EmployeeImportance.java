package easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for(Employee employee : employees){
            employeeMap.put(employee.id, employee);
        }
        return importance(employeeMap, id);
    }

    private int importance(Map<Integer, Employee> employeeMap, int id) {
        int importance = employeeMap.get(id).importance;
        for(Integer sub : employeeMap.get(id).subordinates){
            importance += importance(employeeMap, sub);
        }
        return importance;
    }
}
