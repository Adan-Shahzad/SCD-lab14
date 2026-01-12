public class ContractEmployeeSalary implements SalaryCalculator{
    @Override
    public double calculateSalary(Employee employee){
        return employee.getBaseSalary()*1.10;
    }

}  //COMMITINGGG

