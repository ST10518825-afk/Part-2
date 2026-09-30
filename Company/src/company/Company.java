/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package company;

public class Company {
    public String companyId;
    public String companyName;
    public String location;

    public Company(String companyId, String companyName, String location) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.location = location;
    }

    public String getCompanyId() { return companyId; }
    public String getCompanyName() { return companyName; }
    public String getLocation() { return location; }
}
    

