import static org.example.jenkinslibraryutils.ValidationUtils.requireNonBlank

def call(def parameters) {
	def mode = parameters['mode'] ?: (env.CHANGE_BRANCH == null ? 'branch' : 'pullRequest')

	def params = mode == 'branch' ? createBranchParameters(parameters) : createPullRequestParameters(parameters)
	return params.join(' ')
}

List<String> createBranchParameters(def parameters) {
	def mainBranch = requireNonBlank('mainBranch', parameters['mainBranch'])
	def branch = requireNonBlank('branch', parameters['branch'] ?: env.BRANCH_NAME)

	return branch == mainBranch ? [] : ["-Dsonar.branch.name=${branch}"]
}

List<String> createPullRequestParameters(def parameters) {
	def key = requireNonBlank('key', parameters['key'] ?: env.CHANGE_ID)
	def branch = requireNonBlank('branch', parameters['branch'] ?: env.CHANGE_BRANCH)
	def base = requireNonBlank('base', parameters['base'] ?: env.CHANGE_TARGET)

	return [
		"-Dsonar.pullrequest.key=${key}",
		"-Dsonar.pullrequest.branch=${branch}",
		"-Dsonar.pullrequest.base=${base}"
	]
}
