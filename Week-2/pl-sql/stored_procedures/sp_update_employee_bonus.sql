CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  deptId IN NUMBER,
  bonusPercent IN NUMBER
) IS
BEGIN
  FOR emp IN (SELECT EmployeeID, Salary FROM Employees WHERE DepartmentID = deptId) LOOP
    UPDATE Employees
    SET Salary = Salary + (Salary * bonusPercent / 100)
    WHERE EmployeeID = emp.EmployeeID;

    DBMS_OUTPUT.PUT_LINE('Bonus applied to EmployeeID: ' || emp.EmployeeID);
  END LOOP;
END;
/
