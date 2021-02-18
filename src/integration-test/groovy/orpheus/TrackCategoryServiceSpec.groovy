package orpheus

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TrackCategoryServiceSpec extends Specification {

    TrackCategoryService trackCategoryService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TrackCategory(...).save(flush: true, failOnError: true)
        //new TrackCategory(...).save(flush: true, failOnError: true)
        //TrackCategory trackCategory = new TrackCategory(...).save(flush: true, failOnError: true)
        //new TrackCategory(...).save(flush: true, failOnError: true)
        //new TrackCategory(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //trackCategory.id
    }

    void "test get"() {
        setupData()

        expect:
        trackCategoryService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TrackCategory> trackCategoryList = trackCategoryService.list(max: 2, offset: 2)

        then:
        trackCategoryList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        trackCategoryService.count() == 5
    }

    void "test delete"() {
        Long trackCategoryId = setupData()

        expect:
        trackCategoryService.count() == 5

        when:
        trackCategoryService.delete(trackCategoryId)
        sessionFactory.currentSession.flush()

        then:
        trackCategoryService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TrackCategory trackCategory = new TrackCategory()
        trackCategoryService.save(trackCategory)

        then:
        trackCategory.id != null
    }
}
