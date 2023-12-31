package advertisement.repository

import advertisement.entity.AdEntity
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class AdRepository : PanacheRepository<AdEntity> {
    fun findById(adId: String) = find("ad_id", adId).firstResult()
}