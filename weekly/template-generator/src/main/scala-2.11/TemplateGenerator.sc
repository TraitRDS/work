import java.time.DayOfWeek

import TemplateGenerator._

val y2016 = Year(2016)
y2016.days
y2016.days.count(_ => true)


val mondays = y2016.days.filter(_.getDayOfWeek.equals(DayOfWeek.MONDAY))
mondays.zipWithIndex.toList


for (a <- "ricky") yield (a+1)
for (a <- "ricky") yield a.toUpper
for (a <- "ricky") yield (a+1).toChar
