-- Scenario 1: Discount for Age > 60
SET ECHO OFF;
SET FEEDBACK OFF;
SET SERVEROUTPUT ON;
BEGIN
    FOR customer_rec IN (
        SELECT c.CustomerID, l.LoanID
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE c.Age > 60
    ) LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = customer_rec.LoanID;

        DBMS_OUTPUT.PUT_LINE('1% discount applied to LoanID: ' || customer_rec.LoanID);
    END LOOP;
END;
/
--Scenario 2: VIP Status for Balance > 10000
BEGIN
    FOR rec IN (
        SELECT CustomerID FROM Customers WHERE Balance > 10000
    ) LOOP
        UPDATE Customers
        SET IsVIP = 'Y'
        WHERE CustomerID = rec.CustomerID;

        DBMS_OUTPUT.PUT_LINE('VIP promoted: CustomerID ' || rec.CustomerID);
    END LOOP;
END;
/
--Scenario 3: Reminders for Loans Due in Next 30 Days
BEGIN
    FOR loan_rec IN (
        SELECT l.LoanID, l.DueDate, c.Name
        FROM Loans l
        JOIN Customers c ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            ' Reminder: Dear ' || loan_rec.Name || 
            ', your loan (ID: ' || loan_rec.LoanID || 
            ') is due on ' || TO_CHAR(loan_rec.DueDate, 'DD-Mon-YYYY')
        );
    END LOOP;
END;
/