package orpheus

class Project {

    String name

    //Relationships
    static hasMany = [users: User, rooms: Room, categories: TrackCategory]

    static constraints = {
        name blank: false, nullable: false
    }
}
