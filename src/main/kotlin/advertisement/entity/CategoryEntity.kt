package advertisement.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity(name = "category")
class CategoryEntity {
    @Column(name = "name")
    lateinit var name: String
}