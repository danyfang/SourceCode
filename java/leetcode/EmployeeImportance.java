//Leetcode problem  690 Employee Importance
//Solution written by Xuqiang Fang on 10 May, 2018

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Employee{
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
class Solution{
    public int getImportance(List<Employee> employees, int id){
        Employee emp = get(employees, id);
        int res = 0;
        if(emp == null)
            return res;
        else if(emp.subordinates == null || emp.subordinates.size() == 0)
            return emp.importance;
        else{
            res = emp.importance;
            for(int i : emp.subordinates){
                res += getImportance(employees, i);
            }
        }

        return res;
    } 
    private Employee get(List<Employee> list, int id){
        Employee res = null;
        for(Employee l : list){
            if(l.id == id){
                res = l;
                break;
            } 
        } 
        return res;
    }
}

public class EmployeeImportance{
	public static void main(String[] args){
		Solution s = new Solution();
        Employee a = new Employee();
        a.id = 1;
        a.importance = 5;
        a.subordinates = new ArrayList<>(Arrays.asList(2,3));

        Employee b = new Employee();
        b.id = 2;
        b.importance = 3;
        b.subordinates = new ArrayList<>();

        Employee c = new Employee();
        c.id = 3;
        c.importance = 3;
        c.subordinates = new ArrayList<>();

        List<Employee> employees = Arrays.asList(a, b, c); 

        System.out.println(s.getImportance(employees, 1));
	}
}
