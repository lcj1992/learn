package structural.adapter;

/**
 * Created by lcj on 15-10-31.
 */

/**
 * Employees of the Company A.
 */
class CompanyAEmployees {
    /**
     * Retrieve the employee information from the database.
     *
     * @param sqlQuery The SQL query.
     * @return The employee object.
     */
    public Employee getEmployee(String sqlQuery) {
        Employee employee = null;


        // Execute the request.
        return employee;
    }
}

/**
 * Employees of the Company B.
 */
class CompanyBEmployees {
    /**
     * Retrieve the employee information from the LDAP.
     *
     * @param sqlQuery The SQL query.
     * @return The employee object.
     */
    public Employee getEmployee(String distinguishedName) {
        Employee employee = null;

        // Call the LDAP.

        return employee;
    }
}

/**
 * Retrieve information about the employees.
 */

interface EmployeeBrowser {
    /**
     * Retrieve the employee information.
     *
     * @param direction  The employee direction.
     * @param division   The employee division.
     * @param department The employee departement.
     * @param service    The employee service.
     * @param firstName  The employee firstName.
     * @param lastName   The employee lastName.
     * @return The employee object.
     */

    Employee getEmployee(String direction, String division, String department, String service, String firstName, String lastName);
}


/**
 * Adapter for the company A legacy code.
 */

class CompanyAAdapter implements EmployeeBrowser {
    /**
     * Retrieve the employee information.
     *
     * @param direction  The employee direction.
     * @param division   The employee division.
     * @param department The employee department.
     * @param service    The employee service.
     * @param firstName  The employee firstName.
     * @param lastName   The employee lastName.
     * @return The employee object.
     */

    public Employee getEmployee(String direction, String division, String department, String service, String firstName, String lastName) {
        String distinguishedName = "SELECT *"
                + " FROM t_employee as employee"
                + " WHERE employee.company= 'COMPANY A'"
                + " AND employee.direction = " + direction
                + " AND employee.division = " + division
                + " AND employee.department = " + department
                + " AND employee.service = " + service
                + " AND employee.firstName = " + firstName
                + " AND employee.lastName = " + lastName;

        CompanyAEmployees companyAEmployees = new CompanyAEmployees();

        return companyAEmployees.getEmployee(distinguishedName);
    }
}

/**
 * * Adapter for the company B legacy code.
 */

class CompanyBAdapter implements EmployeeBrowser {
    /**
     * Retrieve the employee information.
     *
     * @param direction  The employee direction.
     * @param division   The employee division.
     * @param department The employee department.
     * @param service    The employee service.
     * @param firstName  The employee firstName.
     * @param lastName   The employee lastName.
     * @return The employee object.
     */

    public Employee getEmployee(String direction, String division, String department, String service, String firstName, String lastName) {
        String distinguishedName = "ov1 = " + direction
                + ", ov2 = " + division
                + ", ov3 = " + department
                + ", ov4 = " + service
                + ", cn = " + firstName + lastName;

        CompanyBEmployees companyBEmployees = new CompanyBEmployees();

        return companyBEmployees.getEmployee(distinguishedName);
    }
}

class Employee {

}

