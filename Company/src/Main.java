/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import company.Company;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Company> companies = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();

        Company company1 = new Company("C101", "TechCorp", "Johannesburg");
        companies.add(company1);

        Employee emp1 = new Employee("E001", "John", "Doe", "123 Main St", company1, "2024-01-01", "Active");
        employees.add(emp1);

        Remuneration rem1 = new Remuneration(emp1.getEmployeeId(), company1.getCompanyName(), 150.0, 160.0);

        String[] months = {"April", "May", "June", "July", "August", "September"};
        double[] monthlyHours = {160.0, 170.0, 165.0, 160.0, 180.0, 155.0};

        List<Salary> salaryRecords = new ArrayList<>();
        for (int i = 0; i < months.length; i++) {
            Salary salary = new Salary(months[i], emp1, rem1, monthlyHours[i]);
            salaryRecords.add(salary);
        }

        System.out.println("=================================================");
        System.out.println("     SIX-MONTH SARS REMUNERATION REPORT         ");
        System.out.println("=================================================");
        System.out.println("Employee ID: " + emp1.getEmployeeId());
        System.out.println("Name: " + emp1.getName() + " " + emp1.getSurname());
        System.out.println("Company: " + emp1.getCompany());
        System.out.println("-------------------------------------------------");
        System.out.printf("%-10s | %-12s | %-12s | %-12s\n", "Month", "Normal Pay", "Overtime Hrs", "Total Pay");
        System.out.println("-------------------------------------------------");

        double totalNormalSalary = 0;
        double totalOvertimeHours = 0;
        double totalOvertimeEarnings = 0;
        double totalGrossSalary = 0;

        for (Salary s : salaryRecords) {
            System.out.printf("%-10s | R%-11.2f | %-12.1f | R%-11.2f\n", 
                s.getMonth(), s.getNormalSalary(), s.getOvertimeHours(), s.getTotalSalary());

            totalNormalSalary += s.getNormalSalary();
            totalOvertimeHours += s.getOvertimeHours();
            totalOvertimeEarnings += s.getOvertimeSalary();
            totalGrossSalary += s.getTotalSalary();
        }

        boolean workedOvertime = totalOvertimeHours > 0;

        System.out.println("-------------------------------------------------");
        System.out.println("SIX-MONTH SUMMARY:");
        System.out.printf("Total Normal Salary:     R%.2f\n", totalNormalSalary);
        System.out.printf("Total Overtime Hours:    %.1f hrs\n", totalOvertimeHours);
        System.out.printf("Total Overtime Earnings: R%.2f\n", totalOvertimeEarnings);
        System.out.printf("Total Gross Salary:      R%.2f\n", totalGrossSalary);
        System.out.println("Worked Overtime Period?  " + (workedOvertime ? "Yes" : "No"));
        System.out.println("=================================================");
    }
    
}
