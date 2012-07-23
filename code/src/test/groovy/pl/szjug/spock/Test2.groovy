package pl.szjug.spock

import org.junit.Test
import spock.lang.Specification
import pl.szjug.spock.entities.Person

/**
 * @author Pawel Stawicki 
   @since 7/15/12 1:03 PM
 */
class Test2 extends Specification {

  //Different for every test
  def Dao dao = Mock()
  def dbService = new DbService(dao)

  @Test
  def 'Should return surname Stawicki if firstname is Paweł'() {
    setup:
    dao.findByFirstname("Paweł") >> new Person(firstname: "Paweł", surname: "Stawicki")

    when:
    def result = dbService.getSurname("Paweł")

    then:
    result == "Stawicki"
  }

  @Test
  def 'Should return surname Gruchała if firstname is Leszek'() {
    setup:
    dao.findByFirstname("Leszek") >> new Person(firstname: "Leszek", surname: "Gruchała")

    when:
    def result = dbService.getSurname("Leszek")

    then:
    result == "Gruchała"
  }

  @Test
  def 'Should return surname Gruchała if firstname length is greater than 5'() {
    setup:
    dao.findByFirstname({it.length() > 5}) >>> [new Person(firstname: "Leszek", surname: "Gruchała"), new Person(firstname: "Paweł", surname: "Stawicki")]

    when:
    def result1 = dbService.getSurname("Leszek")
    def result2 = dbService.getSurname("Leszek")

    then:
    result1 == "Gruchała"
    result2 == "Gruchała"
  }

}
