package orpheus

class TrackCategory {

    String name
    String status

    //Relationships
    static hasMany = [tracks: Track]
    static belongsTo = [project: Project]

    static constraints = {
    }
}
