package advertisement.repository

import advertisement.entity.CategoryEntity
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class CategoryRepository : PanacheRepository<CategoryEntity> {
    fun findByName(name: String) = find("name", name).firstResult()
}