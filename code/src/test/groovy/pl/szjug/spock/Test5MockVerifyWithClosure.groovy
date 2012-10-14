package pl.szjug.spock

import org.junit.Test
import pl.szjug.spock.entities.Employee
import spock.lang.Specification

/**
 * @author Pawel Stawicki 
   @since 7/15/12 1:03 PM
 */
class Test5MockVerifyWithClosure extends Specification {

  def Dao dao = Mock()
  def employee = new Employee(firstname: "Jan", surname: "Kowalski", salary: 100)

  def dbService = new DbService(dao)

  def setup() {
    dao.persist(_) >> { it[0] }
  }

  @Test
  def 'Should pass Employee to dao'() {
    when:
    def result = dbService.giveRaise(employee)

    then:
    1 * dao.persist( {
      println it.dump()
      it instanceof Employee
      it.firstname == "Jan"
      it.surname == "Kowalski"
      it.salary == 110
    } )
  }

  @Test
  def 'Should pass Employee to dao. Not nice error'() {
    when:
    def result = dbService.giveRaise(employee)

    then:
    1 * dao.persist( {
      println it.dump()
      it instanceof Employee
      it.firstname == "Jan"
      it.surname == "Nowak"
    } )
  }

  @Test
  def 'Should pass Employee to dao. Nice error with assert'() {
    when:
    def result = dbService.giveRaise(employee)

    then:
    1 * dao.persist( {
      println it.dump()
      assert it instanceof Employee
      assert it.firstname == "Jan"
      assert it.surname == "Nowak"
    } )
  }

}
