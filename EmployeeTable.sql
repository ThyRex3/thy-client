CREATE TABLE Employee (
	Record_ID uuid PRIMARY KEY,
	First_Name varchar(50) NOT NULL,
	Last_Name varchar(50) NOT NULL,
	Employee_ID int NOT NULL,
	Active boolean DEFAULT FALSE,
	Classification varchar(25) check (Classification in ('general manager', 'shift manager', 'cashier')),
	Manager uuid,
	FOREIGN KEY (Manager) REFERENCES Employee(Record_ID),
	Password varchar(50) NOT NULL,
	Time_Stamp timestamp without time zone NOT NULL DEFAULT now()
	);
