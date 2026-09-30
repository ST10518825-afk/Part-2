
import company.Company;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Employee {
    public String employeeId;
    public String name;
    public String surname;
    public String address;
    public String company;
    public String startDate;
    public String endDate;

    public Employee(String employeeId, String name, String surname, String address, String company, String startDate, String endDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    Employee(String e001, String john, String doe, String _Main_St, Company company1, String string, String active) {
        
    }

    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getCompany() { return company; }
}

