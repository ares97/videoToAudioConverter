package radoslaw.slowinski.videotoaudio.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import radoslaw.slowinski.videotoaudio.model.AudioResponse
import radoslaw.slowinski.videotoaudio.service.ConverterServiceImpl

@RestController
@RequestMapping("/api/converter/")
class ConverterController {

    @Autowired
    lateinit var converterService: ConverterServiceImpl

    @GetMapping
    fun getAudioUrl(@RequestParam("url") videoKey: String): AudioResponse{
        return converterService.getDownloadableAudioURL(videoKey)
    }


}