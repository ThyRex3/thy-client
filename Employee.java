package org.npc.testmodel.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.npc.dataaccess.model.BaseModel;
import org.npc.testmodel.models.fieldnames.ProductFieldNames;
import org.npc.testmodel.repositories.ProductRepository;

public class Employee extends BaseModel<Employee> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.timeStamp = rs.getTimestamp(EmployeeFieldNames.TIME_STAMP).toLocalDateTime();
		this.password = rs.getString(EmployeeFieldNames.PASSWORD);
		// unsure of manager
		this.classification = rs.getString(EmployeeFieldNames.CLASSIFICATION);
		// this.active = rs.getBoolean(EmployeeFieldNames.ACTIVE);
		this.employeeId = rs.getInt(EmployeeFieldNames.EMPLOYEE_ID);
		this.lastName = rs.getString(EmployeeFieldNames.LAST_NAME);
		this.firstName = rs.getString(EmployeeFieldNames.FIRST_NAME);
		// unsure of recordID
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(EmployeeFieldNames.TIME_STAMP, Timestamp.valueOf(this.timeStamp));
		record.put(EmployeeFieldNames.PASSWORD, this.password));
		// record.put(EmployeeFieldNames.MANAGER, this.lookupCode);
		record.put(EmployeeFieldNames.CLASSIFICATION, this.classification);
		record.put(EmployeeFieldNames.ACTIVE, this.active); // or valueOf(this.active)?
		record.put(EmployeeFieldNames.EMPLOYEE_ID, this.employeeId);
		record.put(EmployeeFieldNames.LAST_NAME, this.lastName);
		record.put(EmployeeFieldNames.FIRST_NAME, this.firstName);
		// record.put(EmployeeFieldNames.record_id, this.recordID);
				
		return record;
	}

	// Employee column: time_stamp (timestamp)
	private LocalDateTime timeStamp;
	public LocalDateTime getTimeStamp() {
		return this.timeStamp
	}

	// Employee column: password (varchar(50))
	private String password;
	public String getPassword() {
		return this.password;
	}
	public Employee setPassword(String password) {
		if(!StringUtils.equals(this.passowrd, password)) {
			this.password;
			this.propertyChanged(EmployeeFieldNames.PASSWORD);
		}

		return this;
	}

	// Not sure how to do Foreign Key

	// Employee column: classification (varchar(25))
	private String classification;
	public String getClassification() {
		return this.classification;
	}
	public Employee setClassification(String classification) {
		if(!StringUtils.equals(this.classification, classification)) {
			this.classification;
			this.propertyChanged(EmployeeFieldNames.CLASSIFICATION);
		}

		return this;
	}

	// Employee column: active (boolean)
	private boolean active;
	public boolean getActive() {
		return this.active;
	}
	public Employee setActive(boolean active) {
		if(this.active != active){
			this.active = active;
			this.propertyChanged(EmployeeFieldNames.ACTIVE);
		}

		return this;
	}

	// Employee column: employee_id (int)
	private int employeeId;
	public int getEmployeeId() {
		return this.employeeId;
	}
	public Employee setEmployeeId(int employeeId){
		if (this.employeeId != employeeId){
			this.employeeId = employeeId;
			this.propertyChanged(EmployeeFieldNames.EMPLOYEE_ID);
		}

		return this;
	}

	// Employee column: last_name (varchar(50))
	private String lastName;
	public String getLastName() {
		return this.lastName;
	}
	public Employee setLastName(String lastName) {
		if(!StringUtils.equals(this.lastName, lastName)) {
			this.lastName;
			this.propertyChanged(EmployeeFieldNames.LAST_NAME);
		}

		return this;
	}

	// Employee column: first_name (varchar(50))
	private String firstName;
	public String getFirstName() {
		return this.firstName;
	}
	public Employee setFirstName(String firstName) {
		if(!StringUtils.equals(this.firstName, firstName)) {
			this.firstName;
			this.propertyChanged(EmployeeFieldNames.FIRST_NAME);
		}

		return this;
	}
	
	// Not sure how to implement record_id (PK) data type: UUID

	public org.npc.testmodel.api.Employee synchronize(org.npc.testmodel.api.Employee apiEmployee) {
		this.setCount(apiEmployee.getCount());
		this.setLookupCode(apiEmployee.getLookupCode());
		
		apiEmployee.setCreatedOn(this.createdOn);
		
		return apiEmployee;
	}
	
	public Employee() {
		super(new EmployeeRepository());
		
		this.count = -1;
		this.lookupCode = StringUtils.EMPTY;
		this.createdOn = LocalDateTime.now();
	}
	
	public Employee(UUID id) {
		super(id, new EmployeeRepository());
		
		this.count = -1;
		this.lookupCode = StringUtils.EMPTY;
		this.createdOn = LocalDateTime.now();
	}

	public Employee(org.npc.testmodel.api.Employee apiProduct) {
		super(apiProduct.getId(), new ProductRepository());
		
		this.count = apiProduct.getCount();
		this.lookupCode = apiProduct.getLookupCode();

		this.createdOn = LocalDateTime.now();
	}
}
