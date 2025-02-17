import org.example.Controller
import java.io.*
import java.util.*

class TestUtil {



    companion object {
        fun genScanner(input: String): Scanner {
            val `in`: InputStream = ByteArrayInputStream(input.toByteArray())
            return Scanner(`in`)
        }

        // System.out의 출력을 스트림으로 받기
        fun setOutToByteArray(): ByteArrayOutputStream {
            val output = ByteArrayOutputStream()
            System.setOut(PrintStream(output))

            return output
        }

        // setOutToByteArray 함수의 사용을 완료한 후 정리하는 함수, 출력을 다시 정상화 하는 함수
        fun clearSetOutToByteArray(output: ByteArrayOutputStream) {
            System.setOut(PrintStream(FileOutputStream(FileDescriptor.out)))
            try {
                output.close()
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
        }

        fun run(input: String): String {
            val input = input.replace(" ", "\n")
            val output = setOutToByteArray()
            var service = Controller(genScanner(input))
            service.thread.join()
            clearSetOutToByteArray(output)
            return output.toString()
        }
    }



}