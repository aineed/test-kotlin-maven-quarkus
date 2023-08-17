package advertisement.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "tag")
class TagEntity {
    @Column(name = "name")
    @Id
    lateinit var name: String
}