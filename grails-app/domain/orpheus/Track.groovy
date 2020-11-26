package orpheus

class Track {

    String name
    String filename

    //Relationships
    static belongsTo = [room: Room, user: User, category: TrackCategory]

    static constraints = {
    }
}
