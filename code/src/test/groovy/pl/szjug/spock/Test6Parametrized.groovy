package pl.szjug.spock

import org.junit.Test
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Pawel Stawicki 
   @since 7/15/12 1:03 PM
 */
class Test6Parametrized extends Specification {

  //New for every test
  def service = new NumbersService()

  @Test
  @Unroll
  def 'isEven should return #isEven for #number'() {
    when:
    def result = service.isEven(number)

    then:
    result == isEven

    where:
    number  | isEven
    2       | true
    3       | false
    65      | false
  }

  @Test
  @Unroll
  def 'isEven should return #isEven for #number as list'() {
    when:
    def result = service.isEven(number)

    then:
    result == isEven

    where:
    number << [2, 3, 65]
    isEven << [true, false, false]
  }

}
