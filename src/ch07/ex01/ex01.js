var LocalDate= java.time.LocalDate;
var date = LocalDate.of(2000, 2, 29);
print(date);
print(date.plusYears(1));
print(date.plusYears(4));
print(date.plusYears(1).plusYears(1).plusYears(1).plusYears(1));