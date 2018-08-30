package vo;

public class EmployeeVO {
    private String name;
    private double salary;
    private String email;

    public EmployeeVO() {
    }

    public EmployeeVO(String name, double salary, String email) {
        this.name = name;
        this.salary = salary;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
