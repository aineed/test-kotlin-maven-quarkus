package advertisement.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity(name = "tag")
class TagEntity {
    @Column(name = "name")
    lateinit var name: String
}