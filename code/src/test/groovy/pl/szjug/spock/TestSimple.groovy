package pl.szjug.spock

import org.junit.Test
import spock.lang.Specification

/**
 * @author Pawel Stawicki 
   @since 7/15/12 1:03 PM
 */
class TestSimple extends Specification {

  //Different for every test
  def service = new NumbersService()

  @Test
  def 'Should return true if number is even'() {
    when:
    def result = service.isEven(2)

    then:
    result == true
  }

  @Test
  def 'Should return false if number is odd'() {
    when:
    def result = service.isEven(3)

    then:
    result == false
  }

}
