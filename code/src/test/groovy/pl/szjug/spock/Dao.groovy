package pl.szjug.spock

import pl.szjug.spock.entities.Person

/**
 * @author Pawel Stawicki 
   @since 7/15/12 11:26 PM
 */
class Dao {

  Person findByFirstname(String firstname) {
    return null
  }

  Person persist(Person entity) {
    //Store in database
    //We don't care here because in test we are mocking this class anyway

    entity
  }
}
