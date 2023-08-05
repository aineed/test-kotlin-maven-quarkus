package profile.domain

data class Profile(
        val username: String,
        val firstname: String,
        val lastname: String,
        val email: String,
        val phoneNumber: Number,
        val userType: String,
        //TODO: GJØR OM TIL ENUM OG VERDIER - userType
        val description: String,
        val skills: String
)
