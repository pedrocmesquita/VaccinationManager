package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.model.VaccineType;
import app.domain.shared.Constants;

public class SpecifyNewEmployeeController {


    /**
     *
     * Company and Employee to add.
     */
    private Company company;
    private Employee emp;


    /**
     * Constructors.
     */
    public SpecifyNewEmployeeController() {
        this(App.getInstance().getCompany());
    }

    public SpecifyNewEmployeeController(Company company) {
        this.company = company;
        this.emp = null;
    }

    /**
     * Creates and verifies new employees.
     *
     * @param name              employee's name
     * @param email             employee's email
     * @param address           employee's address
     * @param phoneNumber       employee's phone number
     * @param citizenCardNumber employee's citizen card number
     * @param employeeID        employee's ID
     * @param role              employee's role
     * @return the boolean
     */
    public boolean createEmployee(String name, String email, String address, String phoneNumber, String citizenCardNumber, int employeeID, String role) {
        try{
            this.emp = new Employee(name, email, address, phoneNumber, citizenCardNumber, employeeID, role);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }

        return validateEmployee(emp);
    }

    /**
     * Validates vaccine type boolean.
     *
     * @param emp the emp
     * @return the boolean
     */
    public boolean validateEmployee (Employee emp) {
        if (emp == null) return false;
        return company.getEmployeeStore().getEmployeeList().contains(emp);
    }

    /**
     * Adds employee.
     */
    public void addEmployee() {
        this.company.getEmployeeStore().addEmployee(emp);
        String password;
    }

    /**
     * Shows employee object as a String.
     *
     * @return employee as a String
     */
    public String showEmployee() {
        return this.emp.toString();
    }
}
