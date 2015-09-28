CREATE TABLE Transaction ( 
	Record_ID uuid PRIMARY KEY,
	Cashier_ID uuid  NOT NULL,
	Foreign Key (Cashier_ID) References Employee(Record_ID),
	Amount decimal(5,2) NOT NULL,
	TransactionType varchar(25) check (TransactionType in ('sale', 'return', 'void')),
	Parent_ID uuid,
	Foreign Key (Parent_ID) References Transaction (Record_ID),
	Time_Stamp timestamp without time zone NOT NULL DEFAULT now()
);
