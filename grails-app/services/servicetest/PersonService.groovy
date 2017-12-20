package servicetest

import grails.gorm.transactions.Transactional

class PersonService {

    @Transactional
    Person savePersonWithoutFlush(String name) {
        new Person(name: name).save()
    }

    @Transactional
    Person savePersonWithFlush(String name) {
        new Person(name: name).save(flush: true)
    }

    @Transactional(readOnly = true)
    Person findPerson(String name) {
        Person.findByName(name)
    }
}
