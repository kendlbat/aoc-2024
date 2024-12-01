import java.io.File
import okhttp3.OkHttpClient
import okhttp3.Request

class Aoc {
    companion object {
        private fun getSession(): String {
            return File(".aocsession").readText()
        }

        fun getInput(day: Int): File {
            // If the input file already exists, return it
            val file = File("${day.toString().padStart(2, '0')}/input")
            if (file.exists()) return file

            val client = OkHttpClient();

            val request = Request.Builder()
                .url("https://adventofcode.com/2024/day/$day/input")
                .header("Cookie", "session=${getSession()}")
                .build()

            val response = client.newCall(request).execute()

            return File("${day.toString().padStart(2, '0')}/input").apply {
                writeText(response.body.string())
            }
        }
    }
}