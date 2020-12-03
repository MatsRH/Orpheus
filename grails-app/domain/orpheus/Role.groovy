package orpheus

class Role {

    String name

    static constraints = {
        name blank: false, nullable: false
    }
}
