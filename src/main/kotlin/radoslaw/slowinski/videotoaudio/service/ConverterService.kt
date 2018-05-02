package radoslaw.slowinski.videotoaudio.service

import org.springframework.stereotype.Service
import radoslaw.slowinski.videotoaudio.model.AudioResponse
import java.io.BufferedReader
import java.io.InputStreamReader

interface ConverterService {
    fun getDownloadableAudioURL(videoKey: String): AudioResponse
}

@Service
class ConverterServiceImpl : ConverterService {

    override fun getDownloadableAudioURL(videoKey: String): AudioResponse{
        val videoURL = videoKey

        val process = Runtime.getRuntime().exec("youtube-dl -x -g -s $videoURL")
        val input = BufferedReader(InputStreamReader(process.inputStream))
        var audioURL = ""
        var output = input.readLine()
        while (output != null) {
            println(output)
            audioURL += "$output \n"
            output = input.readLine()
        }
        process.destroy()

        return AudioResponse(audioURL)
    }
}