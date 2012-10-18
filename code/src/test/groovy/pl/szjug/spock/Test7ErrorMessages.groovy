package pl.szjug.spock

import org.junit.Test
import spock.lang.Specification

import static java.lang.Double.parseDouble

/**
 * @author Pawel Stawicki 
   @since 7/21/12 11:11 PM
 */
class Test7ErrorMessages extends Specification {

  @Test
  def 'Should show nice error message when calling many methods'() {
    when:
    "dummy"

    then:
    parseDouble("2" + appendToDot(5)) == 1
  }

  def appendToDot(number) {
    "." + number
  }

  @Test
  def 'Should show nice error message when comparing strings'() {
    when:
    def pineapple = "pineapple"

    then:
    pineapple == "pipe arrays"
  }

}
