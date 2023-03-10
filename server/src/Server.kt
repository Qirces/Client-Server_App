import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.lang.Exception
import java.net.ServerSocket
import java.net.Socket

class Server {
    companion object{
        const val PORT = 5004
    }

    fun start() {
        val ss = ServerSocket(PORT)
        var br : BufferedReader? = null
        var pw : PrintWriter? = null
        var s : Socket? = null
        try {
            s = ss.accept()
            val iStream = s.getInputStream()
            br = BufferedReader(InputStreamReader(iStream))
            val inputString = br.readLine()
            println(inputString)
            val oStream = s.getOutputStream()
            pw = PrintWriter(oStream)
            pw.println("Greetings from the server")
            pw.flush()

        } catch(e:Exception){
            println("Smth wrong")
            println(e)
        } finally{
            pw?.close()
            br?.close()
        }
    }
}