package orpheus

class Room {

    String name

    //Relationships
    static belongsTo = [project: Project]
    static hasMany = [tracks: Track]

    static constraints = {
        name blank: false, nullable: false
    }
}
