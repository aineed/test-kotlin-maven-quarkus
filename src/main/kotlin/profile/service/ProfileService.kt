package profile.service

import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import profile.domain.Profile
import profile.entity.ProfileEntity
import profile.repository.ProfileRepository


@ApplicationScoped
class ProfileService(
        val profileRepository: ProfileRepository
) {
    @Transactional
    fun storeProfile(profile: Profile) {
        val profileEntity = mapToEntity(profile)
        profileRepository.persist(profileEntity)
    }

    @Transactional
    fun deleteProfile(profileId: Int): Boolean {
        return profileRepository.deleteById(profileId.toLong())
    }

    @Transactional
    fun getProfileById(profileId: Int): Profile? {
        val profileEntity = profileRepository.findById(profileId.toLong())
        return profileEntity?.let { mapToDto(it) }
    }

    @Transactional
    fun findByUsername(username: String): Profile? {
        val profileEntity = profileRepository.findByUsername(username)
        return profileEntity?.let { mapToDto(it) }
    }

    fun mapToEntity(profile: Profile): ProfileEntity {
        val profileEntity = ProfileEntity()
        profileEntity.firstname = profile.firstname
        profileEntity.lastname = profile.lastname
        profileEntity.email = profile.email
        profileEntity.phoneNumber = profile.phoneNumber.toString()
        profileEntity.username = profile.username
        profileEntity.userType = profile.userType
        profileEntity.description = profile.description
        profileEntity.skills = profile.skills
        return profileEntity
    }

    fun mapToDto(profileEntity: ProfileEntity): Profile {
        return Profile(
                firstname = profileEntity.firstname,
                username = profileEntity.username,
                lastname = profileEntity.lastname,
                email = profileEntity.email,
                phoneNumber = profileEntity.phoneNumber.toInt(),
                userType = profileEntity.userType,
                description = profileEntity.description,
                skills = profileEntity.skills)
    }
}