package advertisement.service

import advertisement.domain.Ad
import advertisement.entity.AdEntity
import advertisement.repository.AdRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional


@ApplicationScoped
class AdService(
        val adRepository: AdRepository
) {
    @Transactional
    fun storeProfile(ad: Ad) {
        val profileEntity = mapToEntity(ad)
        adRepository.persist(profileEntity)
    }

    @Transactional
    fun deleteProfile(profileId: Int): Boolean {
        return adRepository.deleteById(profileId.toLong())
    }

    @Transactional
    fun getProfileById(profileId: Int): Ad? {
        val profileEntity = adRepository.findById(profileId.toLong())
        return profileEntity?.let { mapToDto(it) }
    }

    @Transactional
    fun findByUsername(username: String): Ad? {
        val profileEntity = adRepository.findByUsername(username)
        return profileEntity?.let { mapToDto(it) }
    }

    fun mapToEntity(ad: Ad): AdEntity {
        val adEntity = AdEntity()
        adEntity.title = ad.title
        adEntity.categoryName = ad.categoryName
        return adEntity
    }

    fun mapToDto(adEntity: AdEntity): Ad {
        return Ad(
                title = adEntity.title,
                categoryName = adEntity.categoryName

        )
    }
}