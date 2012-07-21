package pl.szjug.spock

import org.junit.Test
import spock.lang.Specification

import static java.lang.Double.parseDouble

/**
 * @author Pawel Stawicki 
   @since 7/21/12 11:11 PM
 */
class TestErrorMessages extends Specification {

  @Test
  def 'Should show nice error message when calling many methods'() {
    when:
    def bigDecimal = new BigDecimal("100")

    then:
    parseDouble(bigDecimal.doubleValue().toString()) == 1
  }

  @Test
  def 'Should show nice error message when comparing strings'() {
    when:
    def pineapple = "pineapple"

    then:
    pineapple == "pipe arrays"
  }

}
