package servicetest

import grails.gorm.transactions.Transactional

class PersonService {

    @Transactional(connection='people')
    Person savePersonWithoutFlush(String name) {
        new Person(name: name).save()
    }

    @Transactional(connection='people')
    Person savePersonWithFlush(String name) {
        new Person(name: name).save(flush: true)
    }

    @Transactional(connection='people', readOnly = true)
    Person findPerson(String name) {
        Person.findByName(name)
    }
}
