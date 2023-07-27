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

        lateinit var username: String
        lateinit var firstname: String
        lateinit var lastname: String
        lateinit var email: String

        @Column(name = "phone_number")
        lateinit var phoneNumber: String
}