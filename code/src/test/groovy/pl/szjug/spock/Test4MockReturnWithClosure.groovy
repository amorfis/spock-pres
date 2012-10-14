package pl.szjug.spock

import org.junit.Test
import pl.szjug.spock.entities.Employee
import spock.lang.Specification

/**
 * @author Pawel Stawicki 
   @since 7/15/12 1:03 PM
 */
class Test4MockReturnWithClosure extends Specification {

  def Dao dao = Mock()
  def employee = new Employee(firstname: "Jan", surname: "Kowalski", salary: 100)

  def dbService = new DbService(dao)

  def setup() {
    dao.persist(_) >> { it[0] }
  }

  @Test
  def 'Should give raise to Employee and store in database'() {
    when:
    def result = dbService.giveRaise(employee)

    then:
    result.salary.compareTo(new BigDecimal(110)) == 0
  }

}
