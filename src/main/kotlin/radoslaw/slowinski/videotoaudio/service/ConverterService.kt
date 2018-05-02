package radoslaw.slowinski.videotoaudio.service

import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.InputStreamReader

interface ConverterService {
    fun getDownloadableAudioURL(videoKey: String): String
}

@Service
class ConverterServiceImpl : ConverterService {

    override fun getDownloadableAudioURL(videoKey: String): String {
        val videoURL = "https://www.youtube.com/watch?v=$videoKey"

        val process = Runtime.getRuntime().exec("youtube-dl -x -g $videoURL")
        val input = BufferedReader(InputStreamReader(process.inputStream))
        var audioURL = ""
        var output = input.readLine()
        while (output != null) {
            println(output)
            audioURL += "$output \n"
            output = input.readLine()
        }
        process.destroy()
        return audioURL
    }
}