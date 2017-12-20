package servicetest

import grails.testing.services.ServiceUnitTest
import org.grails.datastore.mapping.core.connections.ConnectionSource
import org.grails.datastore.mapping.simple.SimpleMapDatastore
import spock.lang.AutoCleanup
import spock.lang.Specification

class PersonServiceSpec extends Specification implements ServiceUnitTest<PersonService> {

    @AutoCleanup SimpleMapDatastore dataStore = new SimpleMapDatastore([ConnectionSource.DEFAULT, 'people'], Person)

    void "test with flush"() {
        when:
        Person p = service.savePersonWithFlush('Jake')

        then:
        p.name == 'Jake'
        p.id != null

        when:
        p = service.findPerson('Jake')

        then:
        p != null
    }

    void "test without flush"() {
        when:
        Person p = service.savePersonWithoutFlush('Zack')

        then:
        p.name == 'Zack'
        p.id != null

        when:
        p = service.findPerson('Zack')

        then:
        p != null
    }
}
