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

    void 'test valid filename is valid'() {
        when:
        domain.filename = "file_name.test"

        then:
        domain.validate(['filename'])
    }

    void 'test filename with @ is invalid'() {
        when:
        domain.filename = "file_@name.test"

        then:
        !domain.validate(['filename'])
    }

    void 'test filename with ! is invalid'() {
        when:
        domain.filename = "file_!name.test"

        then:
        !domain.validate(['filename'])
    }

    void 'test filename with # is invalid'() {
        when:
        domain.filename = "file_#name.test"

        then:
        !domain.validate(['filename'])
    }

    void 'test filename with $ is invalid'() {
        when:
        domain.filename = "file_\$name.test"

        then:
        !domain.validate(['filename'])
    }

    void 'test filename with % is invalid'() {
        when:
        domain.filename = "file_%name.test"

        then:
        !domain.validate(['filename'])
    }

    void 'test filename with * is invalid'() {
        when:
        domain.filename = "file_*name.test"

        then:
        !domain.validate(['filename'])
    }

    void 'test filename cannot be null'() {
        when:
        domain.filename = null

        then:
        !domain.validate(['filename'])
        domain.errors['filename'].code == 'nullable'
    }

    void 'test filename cannot be blank'() {
        when:
        domain.filename = ''

        then:
        !domain.validate(['filename'])
    }


}
