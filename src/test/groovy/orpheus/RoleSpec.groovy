package orpheus

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class RoleSpec extends Specification implements DomainUnitTest<Role> {

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
}
