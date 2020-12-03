package orpheus

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserSpec extends Specification implements DomainUnitTest<User> {

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

    void 'test valid email is valid'() {
        when:
        domain.email = "mruizh@fi.uba.ar"

        then:
        domain.validate(['email'])
    }

    void 'test email cannot be null'() {
        when:
        domain.email = null

        then:
        !domain.validate(['email'])
        domain.errors['email'].code == 'nullable'
    }

    void 'test email cannot be blank'() {
        when:
        domain.email = ''

        then:
        !domain.validate(['email'])
    }

    void 'test email must have valid format'() {
        when:
        domain.email = 'notarealemail.com'

        then:
        !domain.validate(['email'])
    }


    void 'test password cannot be null'() {
        when:
        domain.password = null

        then:
        !domain.validate(['password'])
        domain.errors['password'].code == 'nullable'
    }

    void 'test password cannot be blank'() {
        when:
        domain.password = ''

        then:
        !domain.validate(['password'])
    }

    void 'test password must be at least 8 characters long'() {
        when:
        domain.password = '1234567'

        then:
        !domain.validate(['password'])
    }

    void 'test password must be less than 25 characters long'() {
        when:
        domain.password = 'abcdefghijklmnopqrstuvwxyz123456789'

        then:
        !domain.validate(['password'])
    }
}
