package orpheus

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TrackCategoryController {

    TrackCategoryService trackCategoryService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond trackCategoryService.list(params), model:[trackCategoryCount: trackCategoryService.count()]
    }

    def show(Long id) {
        respond trackCategoryService.get(id)
    }

    def create() {
        respond new TrackCategory(params)
    }

    def save(TrackCategory trackCategory) {
        if (trackCategory == null) {
            notFound()
            return
        }

        try {
            trackCategoryService.save(trackCategory)
        } catch (ValidationException e) {
            respond trackCategory.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'trackCategory.label', default: 'TrackCategory'), trackCategory.id])
                redirect trackCategory
            }
            '*' { respond trackCategory, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond trackCategoryService.get(id)
    }

    def update(TrackCategory trackCategory) {
        if (trackCategory == null) {
            notFound()
            return
        }

        try {
            trackCategoryService.save(trackCategory)
        } catch (ValidationException e) {
            respond trackCategory.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'trackCategory.label', default: 'TrackCategory'), trackCategory.id])
                redirect trackCategory
            }
            '*'{ respond trackCategory, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        trackCategoryService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'trackCategory.label', default: 'TrackCategory'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'trackCategory.label', default: 'TrackCategory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
