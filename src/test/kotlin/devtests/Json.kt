package devtests

data class User(var id: Int, val first_name: String, val last_name: String, val email: String)

fun main() {
    val jsonData = "[{\n" +
        "  \"id\": 1,\n" +
        "  \"first_name\": \"Cleve\",\n" +
        "  \"last_name\": \"Sturrock\",\n" +
        "  \"email\": \"csturrock0@dagondesign.com\"\n" +
        "}, {\n" +
        "  \"id\": 2,\n" +
        "  \"first_name\": \"Heather\",\n" +
        "  \"last_name\": \"Tregien\",\n" +
        "  \"email\": \"htregien1@unblog.fr\"\n" +
        "}, {\n" +
        "  \"id\": 3,\n" +
        "  \"first_name\": \"Almeta\",\n" +
        "  \"last_name\": \"Rundle\",\n" +
        "  \"email\": \"arundle2@deliciousdays.com\"\n" +
        "}, {\n" +
        "  \"id\": 4,\n" +
        "  \"first_name\": \"Christoper\",\n" +
        "  \"last_name\": \"Sparshett\",\n" +
        "  \"email\": \"csparshett3@uiuc.edu\"\n" +
        "}, {\n" +
        "  \"id\": 5,\n" +
        "  \"first_name\": \"Meghan\",\n" +
        "  \"last_name\": \"Seear\",\n" +
        "  \"email\": \"mseear4@state.tx.us\"\n" +
        "}]"

    val users = klib.kLibInf.jsonHandler.toObject(jsonData, Array<User>::class.java)
    if (users is Array<*>) {
        (users as Array<User>).forEach {
            it.id *= 5
            println(it)
        }
    }
}