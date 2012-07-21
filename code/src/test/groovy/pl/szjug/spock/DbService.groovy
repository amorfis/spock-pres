package pl.szjug.spock

import pl.szjug.spock.entities.Person
import pl.szjug.spock.entities.Employee

/**
 * @author Pawel Stawicki 
   @since 7/15/12 11:17 PM
 */
class DbService {

  def Dao dao

  DbService(Dao dao) {
    this.dao = dao
  }

  String getSurname(String firstname) {
    Person person = dao.findByFirstname(firstname)

    return person.surname
  }

  Employee giveRaise(Employee p) {
    p.salary = p.salary.add(p.salary.multiply(0.1));

    dao.persist(p)
  }

}
