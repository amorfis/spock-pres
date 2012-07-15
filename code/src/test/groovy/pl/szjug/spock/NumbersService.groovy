package pl.szjug.spock

/**
 * @author Pawel Stawicki 
   @since 7/15/12 11:03 PM
 */
class NumbersService {

  public NumbersService() {
    println "NumbersService constructed"
  }

  boolean isEven(int number) {
    return number % 2 == 0
  }

}
