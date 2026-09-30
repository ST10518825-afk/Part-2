/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Remuneration {
    public String employeeId;
    public String companyName;
    public double hourlyRate;
    public double normalMonthlyHours;
    public double overtimeRate;

    public Remuneration(String employeeId, String companyName, double hourlyRate, double normalMonthlyHours) {
        this.employeeId = employeeId;
        this.companyName = companyName;
        this.hourlyRate = hourlyRate;
        this.normalMonthlyHours = normalMonthlyHours;
        this.overtimeRate = hourlyRate * 1.5; 
    }

    public double getHourlyRate() { return hourlyRate; }
    public double getNormalMonthlyHours() { return normalMonthlyHours; }
    public double getOvertimeRate() { return overtimeRate; }

}
