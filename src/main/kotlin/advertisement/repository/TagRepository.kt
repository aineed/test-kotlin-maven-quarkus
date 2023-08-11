package advertisement.repository

import advertisement.entity.TagEntity
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class TagRepository : PanacheRepository<TagEntity> {
    fun findByName(name: String) = find("name", name).firstResult()
}