package pl.szjug.spock

import org.junit.Test
import spock.lang.Specification
import pl.szjug.spock.entities.Person

/**
 * @author Pawel Stawicki 
   @since 7/15/12 1:03 PM
 */
class Test2_1WithMockBehaviourDefInSetupMethod extends Specification {

  def Dao dao = Mock()
  def dbService = new DbService(dao)

  def setup() {
    dao.findByFirstname("Paweł") >> new Person(firstname: "Paweł", surname: "Stawicki")
    dao.findByFirstname("Leszek") >> new Person(firstname: "Leszek", surname: "Gruchała")
  }

  @Test
  def 'Should return surname Stawicki if firstname is Paweł'() {
    when:
    def result = dbService.getSurname("Paweł")

    then:
    result == "Stawicki"
  }

  @Test
  def 'Should return surname Gruchała if firstname is Leszek and Stawicki if firstname is Paweł'() {
    when:
    def result = dbService.getSurname("Leszek")
    def result2 = dbService.getSurname("Paweł")

    then:
    result == "Gruchała"
    result2 == "Stawicki"
  }

}
