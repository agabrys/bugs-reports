import jenkins.model.Jenkins

def call(def parameters, def closure) {
	def version = parameters instanceof Map ? parameters['version'] : parameters

	def availableJdks = Jenkins.get().JDKs*.name
	if (!availableJdks.contains(version)) {
		def leftShift = '\n         - '
		error "Unsupported Java version '${version}', please use one of the:${leftShift}${availableJdks.sort().join(leftShift)}"
	}

	def javaHome = tool(version)
	def path = "${javaHome}/bin:${env.PATH}"

	withEnv(["JAVA_HOME=${javaHome}", "PATH=${path}"]) {
		sh '''#!/bin/bash
			java -version
		'''
		closure.call()
	}
}
