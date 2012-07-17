package pl.szjug.spock

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

}
