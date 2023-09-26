package com.lenard.lbb

import mu.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.lenard"])
class Application

private val log = KotlinLogging.logger { }

fun main(args: Array<String>) {
	Thread.setDefaultUncaughtExceptionHandler { thread, exception ->
		log.error("Unhandled exception on thread {}", thread.name, exception)
	}

	val joinedArguments = args.joinToString(separator = ",") { arg: String -> "'$arg'"}
	log.info("Command Line Arguments: [$joinedArguments]")

	runApplication<Application>(*args)
}
