
/*
Background: A payroll system calculates salaries for different employee types.
A general Employee class calculates salary based on hours worked, while ContractEmployee (a derived class) might have
a different payment calculation, like a fixed contract rate. The payroll system processes all employee types and expects
consistent results. In the future we might need more salary calculation logic.

Question: How would you design the Employee and ContractEmployee classes to ensure the payroll system handles
 both without needing special conditions?
*/

interface SalariedEmployee {
    calculateSalary();
}

class Employee implements SalariedEmployee {

    calculateSalary() {
    }
}

class ContactEmployee implements SalariedEmployee {
    calculateSalary() {

    }
}

class PayrollService{
    calculatTotalSalary(List<SalariedEmplyee> employees){
        for(SalariedEmplyee employee: employees){
            employee.calculateSalary();
        }
    }
}