/* Description: Build an employee management system with the following requirements:
Use an abstract class Employee with fields like employeeId, name, and baseSalary.
Provide an abstract method calculateSalary() and a concrete method displayDetails().
Create two subclasses: FullTimeEmployee and PartTimeEmployee, implementing calculateSalary() based on work hours or fixed salary.
Use encapsulation to restrict direct access to fields and provide getter and setter methods.
Create an interface Department with methods like assignDepartment() and getDepartmentDetails().
Ensure polymorphism by processing a list of employees and displaying their details using the Employee reference */

abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    public String getDepartment() { return department; }
    public void setDepartment(String dept) { this.department = dept; }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Department: " + department);
        System.out.println("Final Salary: " + calculateSalary());
        System.out.println("--------------------------------");
    }
}

interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private double bonus;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }

    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { this.bonus = bonus; }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }

    @Override
    public void assignDepartment(String deptName) {
        setDepartment(deptName);
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + getDepartment();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Bonus: " + bonus);
        System.out.println("================================");
    }
}

class PartTimeEmployee extends Employee implements Department {
    private int workHours;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name,double salary, double hourlyRate, int workHours) {
        super(employeeId, name, hourlyRate * workHours);
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }

    public int getWorkHours() { return workHours; }
    public void setWorkHours(int workHours) { this.workHours = workHours; }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + hourlyRate * workHours;
    }

    @Override
    public void assignDepartment(String deptName) {
        setDepartment(deptName);
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + getDepartment();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Work Hours: " + workHours);
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("================================");
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee(101, "Diksha", 30000, 5000);
        Employee e2 = new PartTimeEmployee(102, "Kamal",4000, 200, 80);

        ((Department) e1).assignDepartment("HR");
          System.out.println(((Department) e1).getDepartmentDetails());
        ((Department) e2).assignDepartment("IT Support");
        System.out.println(((Department) e2).getDepartmentDetails());

        e1.displayDetails();
        e2.displayDetails();
    }
}
