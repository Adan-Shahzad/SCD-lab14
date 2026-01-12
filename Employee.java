public class Employee {
    private int id;
    private String name;
    private EmployeeType type;
    private double baseSalary;
    public Employee(int id,String name,EmployeeType type, double baseSalary){
        this.id=id;
        this.name=name;
        this.type=type;
        this.baseSalary=baseSalary;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public EmployeeType getType(){
        return type;
    }
    public double getBaseSalary(){
        return baseSalary;
    }
}
public enum EmployeeType{
    PERMANENT,CONTRACT,INTERN
}
public interface SalaryCalculator{
    double calculateSalary(Employee employee);
}
public class PermanentEmployeeSalary implements SalaryCalculator{
    @Override
    public double calculateSalary(Employee employee){
        return employee.getBaseSalary()*1.30;
    }
}
public class ContractEmployeeSalary implements SalaryCalculator{
    @Override
    public double calculateSalary(Employee employee){
        return employee.getBaseSalary()*1.10;
    }
}
public class InternEmployeeSalary implements SalaryCalculator{
    @Override
    public double calculateSalary(Employee employee){
        return employee.getBaseSalary();
    }
}
public class SalaryCalculatorFactory{
    public static SalaryCalculator getCalculator(EmployeeType type){
        switch(type){
            case PERMANENT:
                return new PermanentEmployeeSalary();
            case CONTRACT:
                return new ContractEmployeeSalary();    
            case INTERN:
                    return new InternEmployeeSalary();  
            default:
                throw new IllegalArgumentException("Invalid employee type");      
        }
    }
}
public interface EmployeeRepository{
    void save(Employee employee, double salary);
}