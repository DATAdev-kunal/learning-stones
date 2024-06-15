package com.giantnovadevs.superapp.ui.rules

object Validator {
	fun validateFirstName(fName: String): ValidationResults{
		return ValidationResults(
			(!fName.isNullOrEmpty() && fName.length >= 3)
		)
	}
	fun validateLastName(lName: String): ValidationResults{
		return ValidationResults(
			(!lName.isNullOrEmpty() && lName.length >= 2)
		)
	}
	fun validateEmail(email: String): ValidationResults{
		return ValidationResults(
			(!email.isNullOrEmpty() && email.length >= 12)
		)
	}
	fun validatePassword(password: String): ValidationResults{
		return ValidationResults(
			(!password.isNullOrEmpty() && password.length >= 15)
		)
	}
	fun validatePrivacyPolicyAccepted(statusValue: Boolean): ValidationResults {
		return ValidationResults(
			statusValue
		)
	}
}

data class ValidationResults(
		val status: Boolean = false
)