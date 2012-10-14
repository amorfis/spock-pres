package pl.szjug.spock

import org.junit.Test
import spock.lang.Specification
import spock.lang.Shared

/**
 * @author Pawel Stawicki 
   @since 7/15/12 1:03 PM
 */
class Test3MocksRenewal extends Specification {

  //Different for every test
  def counter = 0
  def Counter objectCounter = Mock()

  @Shared
  def sharedCounter = 0

  @Test
  def 'Should have new counter'() {
    when:
    counter++
    sharedCounter++
    objectCounter.increaseCounter()

    then:
    counter == 1
    sharedCounter == 1
    1 * objectCounter.increaseCounter()
  }

  @Test
  def 'Should have new counter too'() {
    when:
    counter++
    sharedCounter++
    objectCounter.increaseCounter()

    then:
    counter == 1
    sharedCounter == 2
    1 * objectCounter.increaseCounter()
  }

}
