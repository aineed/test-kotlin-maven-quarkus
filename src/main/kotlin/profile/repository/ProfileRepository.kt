package profile.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import profile.entity.ProfileEntity

@ApplicationScoped
class ProfileRepository: PanacheRepository<ProfileEntity> {
    fun findByUsername(username: String) = find("username", username).firstResult()
}