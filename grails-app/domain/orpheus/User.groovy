package orpheus

class User {

    String name
    String email
    String password

    //Relationships
    static hasMany = [projects: Project, tracks: Track]

    static constraints = {
        name blank: false, nullable: false
        email blank: false, nullable: false, email: true
        password blank: false, nullable: false, minSize: 8, maxSize: 25
    }

}
