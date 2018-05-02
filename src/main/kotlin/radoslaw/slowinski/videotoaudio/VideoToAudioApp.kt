package radoslaw.slowinski.videotoaudio

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@Configuration
class VideoToAudioApp

fun main(args: Array<String>) {
    SpringApplication.run(VideoToAudioApp::class.java, *args)
}
