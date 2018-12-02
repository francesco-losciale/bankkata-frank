# Outside-in Bank Kata exercise from Sandro Mancuso - attempt #1

[Outside In TDD part I](https://www.youtube.com/watch?v=XHnuMjah6ps)
[Outside In TDD part II](https://www.youtube.com/watch?v=gs0rqDdz3ko)
[Outside In TDD part III](https://www.youtube.com/watch?v=R9OAt9AOrzI)

# Mistakes

1. Remember THAT before adding production code you MUST create a unit test for each class you are creating. For example: while developing the class Account using AccountTest, you needed to create the class StatementPrinter. But you kept using AccountTest instead of adding StatementPrinterTest, so in AccountTest you mocked some interals specific of StatementPrinters.
2. You haven't created unit tests for Clock and Console, you just mocked them using AccounTest and StatementPrinterTest... You should have created ClockTest as you started thinking about a LocalDate for testing purposes.
3. And about Console, when you should have created the ConsoleTest since you are always using the mock?
