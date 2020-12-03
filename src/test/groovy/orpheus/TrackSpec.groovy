package orpheus

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TrackSpec extends Specification implements DomainUnitTest<Track> {

    def setup() {
    }

    def cleanup() {
    }

    void 'test valid name is valid'() {
        when:
        domain.name = "Nombre"

        then:
        domain.validate(['name'])
    }

    void 'test name cannot be null'() {
        when:
        domain.name = null

        then:
        !domain.validate(['name'])
        domain.errors['name'].code == 'nullable'
    }

    void 'test name cannot be blank'() {
        when:
        domain.name = ''

        then:
        !domain.validate(['name'])
    }

    void 'test submitted status is valid'() {
        when:
        domain.status = "submitted"

        then:
        domain.validate(['status'])
    }

    void 'test redo status is valid'() {
        when:
        domain.status = "redo"

        then:
        domain.validate(['status'])
    }

    void 'test status cannot be null'() {
        when:
        domain.status = null

        then:
        !domain.validate(['status'])
        domain.errors['status'].code == 'nullable'
    }

    void 'test status cannot be blank'() {
        when:
        domain.status = ''

        then:
        !domain.validate(['status'])
    }
}
