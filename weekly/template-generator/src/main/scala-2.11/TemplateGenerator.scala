/**
	* Created by yli on 9/14/2016.
	*/

import java.io.{File, PrintWriter}
import java.time.{DayOfWeek, LocalDate}
import java.util.{Calendar, Date, GregorianCalendar}

object TemplateGenerator extends App {
	class Year(year: Int) {
		val days: Stream[LocalDate] = {
			def loop(day: LocalDate): Stream[LocalDate] = {
				day.getYear match {
					case y if y == year => day #:: loop(day.plusDays(1))
					case _ => Stream.empty
				}
			}
			loop(LocalDate.of(year, 1, 1))
		}

		val weeks: Stream[Week] = {
			val mondays = days.filter(_.getDayOfWeek.equals(DayOfWeek.MONDAY))
			for { (monday, index) <- mondays.zipWithIndex } yield new Week(index+1, monday)
		}
	}
	object Year {
		def apply(year: Int) = new Year(year)
	}

	case class Week(val number: Int, val monday: LocalDate) {
		val days = List(monday, monday.plusDays(1), monday.plusDays(2), monday.plusDays(3), monday.plusDays(4))

		override def toString: String = f"week-$number%02d (${days.mkString(",")})"
	}

	val year = 2016
	val weekBegin = 38
	new File(year.toString).mkdir()
	Year(year).weeks.filter(_.number >= weekBegin)foreach { (week: Week) =>
		val pathString = f"${year}/week-${week.number}%02d.md"
		val writer = new PrintWriter(new File(pathString))
		week.days.foreach { day: LocalDate =>
			writer.write(
				s"""#### ${day.toString}
					 |1.  \n2.  \n
					 |""".stripMargin)
		}
		writer.close()
	}
}
