package radoslaw.slowinski.videotoaudio.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import radoslaw.slowinski.videotoaudio.service.ConverterServiceImpl

@RestController("/api/converter/")
class ConverterController {

    @Autowired
    lateinit var converterService: ConverterServiceImpl

    @GetMapping("yt")
    fun getAudioUrl(@RequestParam("videoKey") videoKey: String): String{
        return converterService.getDownloadableAudioURL(videoKey)
    }

}