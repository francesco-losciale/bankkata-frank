# Outside-in Bank Kata exercise from Sandro Mancuso - attempt #1

[Outside In TDD part I](https://www.youtube.com/watch?v=XHnuMjah6ps)
[Outside In TDD part II](https://www.youtube.com/watch?v=gs0rqDdz3ko)
[Outside In TDD part III](https://www.youtube.com/watch?v=R9OAt9AOrzI)

# Mistakes

Remember THAT before adding production code you MUST create a unit test for each class you are creating. 

1. Writing the class Account through AccountTest, you needed to create the class StatementPrinter. But you kept using AccountTest instead of adding StatementPrinterTest, so in AccountTest you mocked some interals specific of StatementPrinters.
2. You made exactly the same mistake described by Sandro in the video: you created the tests in AccountTest that are copies of the Acceptance tests (using the console). 
3. AccountTest should have just checked that calling deposit and witdraw store a transaction using transactionRepository (as a mock).
4. You haven't created unit tests for Clock and Console, you just mocked them using AccounTest and StatementPrinterTest... You should have created ClockTest and ConsoleTest but since you are mocking them everywhere, you simply forgot it... The acceptance test didn't raise any error (since they are mocked). 
