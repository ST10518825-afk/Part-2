/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Salary extends Remuneration {
    public String month;
    public double hoursWorked;
    public double normalSalary;
    public double overtimeHours;
    public double overtimeSalary;
    public double totalSalary;

    public Salary(String month, Employee employee, Remuneration rem, double hoursWorked) {
        super(employee.getEmployeeId(), employee.getCompany(), rem.getHourlyRate(), rem.getNormalMonthlyHours());
        this.month = month;
        this.hoursWorked = hoursWorked;
        calculateSalary();
    }

    public void calculateSalary() {
        if (hoursWorked > getNormalMonthlyHours()) {
            this.overtimeHours = hoursWorked - getNormalMonthlyHours();
            this.normalSalary = getNormalMonthlyHours() * getHourlyRate();
        } else {
            this.overtimeHours = 0;
            this.normalSalary = hoursWorked * getHourlyRate();
        }
        this.overtimeSalary = this.overtimeHours * getOvertimeRate();
        this.totalSalary = this.normalSalary + this.overtimeSalary;
    }

    public String getMonth() { return month; }
    public double getNormalSalary() { return normalSalary; }
    public double getOvertimeHours() { return overtimeHours; }
    public double getOvertimeSalary() { return overtimeSalary; }
    public double getTotalSalary() { return totalSalary; }
    
}
