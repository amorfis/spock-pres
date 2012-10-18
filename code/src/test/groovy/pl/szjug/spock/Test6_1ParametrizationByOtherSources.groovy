package pl.szjug.spock

import groovy.sql.Sql
import org.junit.Test
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Pawel Stawicki 
   @since 7/15/12 1:03 PM
 */
class Test6_1ParametrizationByOtherSources extends Specification {

  //New for every test
  def service = new NumbersService()

  @Shared
  def sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

  def setupSpec() {
    sql.execute("create table DATA(number int, isEven boolean)")
    sql.execute("insert into DATA values (5, false)")
    sql.execute("insert into DATA values (10, true)")
    sql.execute("insert into DATA values (720, true)")
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

  @Test
  @Unroll
  def 'isEven should return #isEven for #number as list. Values from other methods.'() {
    when:
    def result = service.isEven(number)

    then:
    result == isEven

    where:
    number << getNumberValues()
    isEven << getIsEvenValues()
  }

  def getIsEvenValues() {
    [true, false, false]
  }

  def getNumberValues() {
    [2, 3, 65]
  }

  @Test
  @Unroll
  def 'isEven should return #isEven for #number as list. Values from data provider.'() {
    when:
    def result = service.isEven(number)

    then:
    result == isEven

    where:
    [number, isEven] << getTestValues()
  }

  def getTestValues() {
    [[2, true], [3, false], [65, false]]
  }

  @Test
  @Unroll
  def 'isEven should return #expected for #number. Values from SQL.'() {
    when:
    def result = service.isEven(number)

    then:
    result == expected

    where:
    rows << sql.rows("select number, isEven from DATA")
    number = rows["number"]
    expected = rows["isEven"]
  }

  @Test
  @Unroll
  def 'isEven should return #expected for #number. Values from SQL, concise "where".'() {
    when:
    def result = service.isEven(number)

    then:
    result == expected

    where:
    [number, expected] << sql.rows("select number, isEven from DATA")
  }

}
