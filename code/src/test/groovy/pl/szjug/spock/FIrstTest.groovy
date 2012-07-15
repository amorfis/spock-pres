package pl.szjug.spock

import org.junit.Test
import spock.lang.Specification

/**
 * @author Pawel Stawicki 
   @since 7/15/12 1:03 PM
 */
class FirstTest extends Specification {

  @Test
  def 'Should pass'() {
    when:
    def result = true

    then:
    result
  }

}
