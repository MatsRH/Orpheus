package orpheus

class Room {

    //Relationships
    static belongsTo = [project: Project]
    static hasMany = [tracks: Track]

    static constraints = {
    }
}
