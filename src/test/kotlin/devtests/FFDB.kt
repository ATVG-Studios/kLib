package devtests

import klib.annotations.Experimental
import klib.ffdb.FFDB

@OptIn(Experimental::class)
fun main() {
    val db = FFDB.open("/stmp/testing.ffdb", FFDB.Version.V2.version)

    val user = User(1, "Thomas", "Obernosterer", "thomas.obernosterer@atvg-studios.com")

    db.write(user)
    db.flush()

    val data = db.readAll()

    data.forEach {
        if (it is User) {
            println(it.first_name)
        }
    }
}
