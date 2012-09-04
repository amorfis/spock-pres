package pl.szjug.spock

import org.junit.Test
import pl.szjug.spock.entities.Person
import spock.lang.Specification

/**
 * @author Pawel Stawicki 
   @since 7/15/12 1:03 PM
 */
class Test2WithMock extends Specification {

  @Test
  def 'Should return surname Stawicki if firstname is Paweł'() {
    setup:
    def Dao dao = Mock()
    def dbService = new DbService(dao)
    dao.findByFirstname("Paweł") >> new Person(
            firstname: "Paweł", surname: "Stawicki")

    when:
    def result = dbService.getSurname("Paweł")

    then:
    result == "Stawicki"
  }

  @Test
  def 'Should return surname Stawicki if firstname is Paweł. Simplier method'() {
    setup:
    def Dao dao = Mock()
    def dbService = new DbService(dao)

    when:
    def result = dbService.getSurname("Paweł")

    then:
    result == "Stawicki"
    1 * dao.findByFirstname("Paweł") >> new Person(
            firstname: "Paweł", surname: "Stawicki")
  }

}
