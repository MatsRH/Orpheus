package orpheus

class User {

    String name

    //Relationships
    static hasMany = [projects: Project, tracks: Track]

    static constraints = {
    }

}
