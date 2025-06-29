CREATE OR REPLACE PROCEDURE TransferFunds (
  fromAccountId IN NUMBER,
  toAccountId IN NUMBER,
  amount IN NUMBER
) IS
  fromBalance NUMBER;
BEGIN
  SELECT Balance INTO fromBalance FROM Accounts WHERE AccountID = fromAccountId FOR UPDATE;

  IF fromBalance < amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
  END IF;

  -- Deduct from source
  UPDATE Accounts
  SET Balance = Balance - amount
  WHERE AccountID = fromAccountId;

  -- Add to destination
  UPDATE Accounts
  SET Balance = Balance + amount
  WHERE AccountID = toAccountId;

  DBMS_OUTPUT.PUT_LINE(amount || ' transferred from AccountID ' || fromAccountId || ' to AccountID ' || toAccountId);
END;
/
