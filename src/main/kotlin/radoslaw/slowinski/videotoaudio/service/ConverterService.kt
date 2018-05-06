package radoslaw.slowinski.videotoaudio.service

import com.fasterxml.jackson.databind.util.JSONPObject
import org.springframework.stereotype.Service
import radoslaw.slowinski.videotoaudio.controller.ConverterController
import radoslaw.slowinski.videotoaudio.model.AudioResponse
import java.io.BufferedReader
import java.io.InputStreamReader

interface ConverterService {
    fun getDownloadableAudioURL(videoKey: String): AudioResponse
}

@Service
class ConverterServiceImpl : ConverterService {

    override fun getDownloadableAudioURL(videoKey: String): AudioResponse {
        val videoURL = videoKey

        val process = Runtime.getRuntime().exec("youtube-dl -x -g -s --get-title $videoURL")
        val input = BufferedReader(InputStreamReader(process.inputStream))
        var audioURL = ""
        var output = input.readLine()
        while (output != null) {
            println(output)
            audioURL += "$output \n"
            output = input.readLine()
        }
        process.destroy()

        val splitedData = audioURL.split("\n")
        var title = ""
        for (split in splitedData) {
            if (split.contains("http"))
                audioURL = split
            else if (split.isNotBlank())
                title = split
        }

        return AudioResponse(audioURL, title)
    }
}