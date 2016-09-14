import java.time.LocalDate

import TemplateGenerator.Year
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
	* Created by yli on 9/14/2016.
	*/
@RunWith(classOf[JUnitRunner])
class TemplateGeneratorSuite extends FunSuite{

	test("days of year 2016") {
		val y2016 = Year(2016)
		println(y2016.days)
		assert(y2016.days.head.equals(LocalDate.of(2016, 1, 1)))
		assert(y2016.days.count(_ => true) equals  366)
	}

	test("weeks of year 2016") {
		val y2016 = Year(2016)
		y2016.weeks.foreach{ week =>
			println(week)
		}
		assert(y2016.weeks.count(_=>true) == 52)
	}
}
