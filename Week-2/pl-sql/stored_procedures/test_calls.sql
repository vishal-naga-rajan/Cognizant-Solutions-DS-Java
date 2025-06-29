SET SERVEROUTPUT ON;
SET ECHO OFF;
SET FEEDBACK OFF;
-- Test Monthly Interest
EXEC ProcessMonthlyInterest;

-- Test Bonus for Department 10 with 10% bonus
EXEC UpdateEmployeeBonus(10, 10);

-- Test Fund Transfer from 1002 to 1003 (₹3000)
EXEC TransferFunds(1002, 1003, 3000);
