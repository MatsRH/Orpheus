package orpheus

import grails.gorm.services.Service

@Service(TrackCategory)
interface TrackCategoryService {

    TrackCategory get(Serializable id)

    List<TrackCategory> list(Map args)

    Long count()

    void delete(Serializable id)

    TrackCategory save(TrackCategory trackCategory)

}