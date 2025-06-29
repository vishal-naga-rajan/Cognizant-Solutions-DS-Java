DROP TABLE Accounts CASCADE CONSTRAINTS;
DROP TABLE Employees CASCADE CONSTRAINTS;

CREATE TABLE Accounts (
    AccountID     NUMBER PRIMARY KEY,
    CustomerID    NUMBER,
    AccountType   VARCHAR2(20),
    Balance       NUMBER
);

CREATE TABLE Employees (
    EmployeeID     NUMBER PRIMARY KEY,
    Name           VARCHAR2(100),
    Salary         NUMBER,
    DepartmentID   NUMBER
);