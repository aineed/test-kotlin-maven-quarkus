package advertisement.repository

import advertisement.entity.AdTagEntity
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class AdTagRepository : PanacheRepository<AdTagEntity> {
    fun findAllTagByAdId(adId: Int) = find("ad_id", adId)
}