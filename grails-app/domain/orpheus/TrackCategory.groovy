package orpheus

class TrackCategory {

    String name
    String status

    //Relationships
    static hasMany = [tracks: Track]
    static belongsTo = [project: Project]

    static constraints = {
        name blank: false, nullable: false
        status blank: false, inList: ["submitted", "redo"]
    }
}
