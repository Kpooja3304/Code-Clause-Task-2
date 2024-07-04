import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Employee 
{
private int id;
private String name;
private double salary;
public Employee(int id, String name, double salary) 
{
this.id = id;
this.name = name;
this.salary = salary;
}
public int getId() 
{
return id;
}
public void setId(int id) 
{
this.id = id;
}
public String getName() 
{
return name;
}
public void setName(String name) 
{
this.name = name;
}
public double getSalary() 
{
return salary;
}
public void setSalary(double salary) 
{
this.salary = salary;
}
@Override
public String toString() 
{
return "Employee{" +"id=" + id +", name='" + name + '\'' +", salary=" + salary +'}';
}
}
class EmployeeDAO 
{
private List<Employee> employees;
private int nextId;
public EmployeeDAO() 
{
employees = new ArrayList<>();
nextId = 1;
}
public void addEmployee(Employee employee) 
{
employee.setId(nextId++);
employees.add(employee);
}
public List<Employee> getAllEmployees() 
{
return employees;
}
public Employee getEmployeeById(int id) 
{
for (Employee employee : employees) 
{
if (employee.getId() == id) 
{
return employee;
}
}
return null;
}
public void updateEmployee(Employee updatedEmployee) 
{
for (Employee employee : employees) 
{
if (employee.getId() == updatedEmployee.getId()) 
{
employee.setName(updatedEmployee.getName());
employee.setSalary(updatedEmployee.getSalary());
return;
}
}
}
public void deleteEmployee(int id) 
{
employees.removeIf(employee -> employee.getId() == id);
}
}
public class SimpleEmployeeApp 
{
private static final EmployeeDAO employeeDAO = new EmployeeDAO();
private static final Scanner scanner = new Scanner(System.in);
public static void main(String[] args) 
{
boolean exit = false;
while (!exit) 
{
System.out.println("\nEmployee Management System");
System.out.println("1. Add Employee");
System.out.println("2. View All Employees");
System.out.println("3. Update Employee");
System.out.println("4. Delete Employee");
System.out.println("5. Exit");
System.out.print("Enter your choice: ");
int choice = scanner.nextInt();
scanner.nextLine(); 
switch (choice) 
{
case 1:
addEmployee();
break;
case 2:
viewAllEmployees();
break;
case 3:
updateEmployee();
break;
case 4:
deleteEmployee();
break;
case 5:
exit = true;
break;
default:
System.out.println("Invalid choice. Please enter a number between 1 and 5.");
}
}
scanner.close();
}
private static void addEmployee() {
System.out.print("Enter employee name: ");
String name = scanner.nextLine();
System.out.print("Enter employee salary: ");
double salary = scanner.nextDouble();
Employee newEmployee = new Employee(0, name, salary);
employeeDAO.addEmployee(newEmployee);
System.out.println("Employee added successfully.");
}
private static void viewAllEmployees() 
{
List<Employee> employees = employeeDAO.getAllEmployees();
System.out.println("\nEmployee List:");
for (Employee employee : employees) 
{
System.out.println(employee);
}
}
private static void updateEmployee() 
{
System.out.print("Enter employee ID to update: ");
int id = scanner.nextInt();
scanner.nextLine(); 
Employee existingEmployee = employeeDAO.getEmployeeById(id);
if (existingEmployee == null) 
{
System.out.println("Employee not found with ID: " + id);
return;
}
System.out.print("Enter updated name (current: " + existingEmployee.getName() + "): ");
String newName = scanner.nextLine();
System.out.print("Enter updated salary (current: " + existingEmployee.getSalary() + "): ");
double newSalary = scanner.nextDouble();
existingEmployee.setName(newName);
existingEmployee.setSalary(newSalary);
employeeDAO.updateEmployee(existingEmployee);
System.out.println("Employee updated successfully.");
}
private static void deleteEmployee() 
{
System.out.print("Enter employee ID to delete: ");
int id = scanner.nextInt();
scanner.nextLine(); 
employeeDAO.deleteEmployee(id);
System.out.println("Employee deleted successfully.");
}
}
