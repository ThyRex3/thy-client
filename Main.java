package thyclient;

import org.gazelle.thy.models.Employee;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee testEmployee = new Employee();
		testEmployee.setPassword("m30w");
//		testEmployee.setManagerId(managerId);
		testEmployee.setClassification(0);
		testEmployee.setActive(true);
		testEmployee.setEmployeeId("010652741");
		testEmployee.setFirstName("Thy");
		testEmployee.setLastName("Dai");
		
		testEmployee.save();
	}

}
