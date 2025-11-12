import java.util.*;

abstract class Employee implements Comparable<Employee> {
    protected String id;
    protected String name;
    
    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public abstract double calculateMonthlySalary();
    
    public String getId() { return id; }
    public String getName() { return name; }
    
    @Override
    public int compareTo(Employee other) {
        double salaryDiff = other.calculateMonthlySalary() - this.calculateMonthlySalary();
        if (salaryDiff > 0) return 1;
        if (salaryDiff < 0) return -1;
        return this.name.compareTo(other.name);
    }
    
    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Monthly Salary: %.2f", 
                           id, name, calculateMonthlySalary());
    }
}

class FixedPaymentEmployee extends Employee {
    private double monthlySalary;
    
    public FixedPaymentEmployee(String id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }
    
    @Override
    public double calculateMonthlySalary() {
        return monthlySalary;
    }
}

class HourlyPaymentEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;
    
    public HourlyPaymentEmployee(String id, String name, double hourlyRate, int hoursWorked) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    
    @Override
    public double calculateMonthlySalary() {
        return hourlyRate * hoursWorked;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        employees.add(new FixedPaymentEmployee("F001", "Иван Петров", 50000));
        employees.add(new FixedPaymentEmployee("F002", "Анна Сидорова", 45000));
        employees.add(new FixedPaymentEmployee("F003", "Петр Иванов", 50000));
        
        employees.add(new HourlyPaymentEmployee("H001", "Мария Козлова", 500, 160));
        employees.add(new HourlyPaymentEmployee("H002", "Сергей Смирнов", 600, 120));
        employees.add(new HourlyPaymentEmployee("H003", "Ольга Новикова", 450, 180));
        
        Collections.sort(employees);
        
        System.out.println("Список сотрудников, отсортированный по убыванию зарплаты:");
        System.out.println("(при равной зарплате - по алфавиту имени)");
        System.out.println("==================================================");
        
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}