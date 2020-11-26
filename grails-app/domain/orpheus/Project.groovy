package orpheus

class Project {

    //Relationships
    static hasMany = [users: User, rooms: Room, categories: TrackCategory]

    static constraints = {
    }
}
