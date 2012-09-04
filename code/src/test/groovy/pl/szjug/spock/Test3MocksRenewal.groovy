package pl.szjug.spock

import org.junit.Test
import spock.lang.Specification

/**
 * @author Pawel Stawicki 
   @since 7/15/12 1:03 PM
 */
class Test3MocksRenewal extends Specification {

  //Different for every test
  def counter = 0
  def Counter objectCounter = Mock()

  @Test
  def 'Should have new counter'() {
    when:
    counter++
    objectCounter.increaseCounter()

    then:
    counter == 1
    1 * objectCounter.increaseCounter()
  }

  @Test
  def 'Should have new counter too'() {
    when:
    counter++
    objectCounter.increaseCounter()

    then:
    counter == 1
    1 * objectCounter.increaseCounter()
  }

}
