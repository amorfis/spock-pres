package pl.szjug.spock

import org.junit.Test
import spock.lang.Specification

/**
 * @author Pawel Stawicki 
   @since 7/21/12 11:11 PM
 */
class Test8ExceptionsTesting extends Specification {

  @Test
  def 'Should show nice error message when calling many methods'() {
    when:
    new ExceptionalService().run()

    then:
    Exception e = thrown()
    e instanceof RuntimeException
    e.message == "Could not run"
    e.cause instanceof ArithmeticException
  }

}

class ExceptionalService {

  def run() {
    try {
      5 / 0
    } catch (Exception e) {
      throw new RuntimeException("Could not run", e)
    }
  }

}