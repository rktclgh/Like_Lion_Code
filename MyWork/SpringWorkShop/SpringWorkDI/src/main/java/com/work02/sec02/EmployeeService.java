package com.work02.sec02;

import java.util.List;
import java.util.Map;

public class EmployeeService {

    private Map<String, List<Employee>> departmentMap;

    public void setDepartmentMap(Map<String, List<Employee>> departmentMap) {
        this.departmentMap = departmentMap;
    }

    public void printAllEmployees() {
        if (departmentMap == null || departmentMap.isEmpty()) {
            System.out.println("등록된 부서가 없습니다.");
            return;
        }

        for (String dept : departmentMap.keySet()) {
            System.out.println("[" + dept + "]");
            for (Employee emp : departmentMap.get(dept)) {
                System.out.println(" - " + emp);
            }
            System.out.println();
        }
    }
}
