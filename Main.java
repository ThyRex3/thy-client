package thyclient;

import org.gazelle.thy.enums.EmployeeClassification;
import org.gazelle.thy.models.Employee;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee testEmployee = new Employee();
		testEmployee.setPassword("m30w");
		testEmployee.setManagerId(null);
		testEmployee.setClassification(EmployeeClassification.GENERAL_MANAGER);
		testEmployee.setActive(true);
		testEmployee.setEmployeeId("010652741");
		testEmployee.setFirstName("Thy");
		testEmployee.setLastName("Dai");
		
		testEmployee.save();
	}

}
