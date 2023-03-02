import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.lang.Exception
import java.net.Socket

class Client(
    val host: String = "127.0.0.1",
    val port: Int
) {
    fun start() {
        var s: Socket? = null
        var pw: PrintWriter? = null
        var br: BufferedReader? = null

        try {
            s = Socket(host, port)
            pw = PrintWriter(s.getOutputStream()).apply {
                println("Greetings from the client")
                flush()
            }
            br = BufferedReader(InputStreamReader(s.getInputStream())).also {
                println(it.readLine())
            }
        } catch (e: Exception) {
            println("Smth wrong")
            println(e)
        } finally {
            pw?.close()
            br?.close()
            s?.close()
        }

    }
}
