package pl.szjug.spock

import org.junit.Test
import spock.lang.Specification
import spock.lang.Timeout

/**
 * @author Pawel Stawicki 
   @since 7/21/12 11:11 PM
 */
class Test9Timeout extends Specification {

  @Test
  @Timeout(1)
  def 'Should show nice error message when calling many methods'() {
    when:
    Thread.sleep(2000)

    then:
    true
  }

}
