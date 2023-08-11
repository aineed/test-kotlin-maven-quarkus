package profile.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity(name = "profile")
class ProfileEntity {
        @Column(name = "profile_id")
        @GeneratedValue
        @Id
        val profileId: Int = 0

        @Column(name = "username")
        lateinit var username: String

        @Column(name = "firstname")
        lateinit var firstname: String

        @Column(name = "lastname")
        lateinit var lastname: String

        @Column(name = "email")
        lateinit var email: String

        @Column(name = "phone_number")
        lateinit var phoneNumber: String

        @Column(name = "user_type")
        lateinit var userType: String

        @Column(name = "description")
        lateinit var description: String

        @Column(name = "skills")
        lateinit var skills: String
}