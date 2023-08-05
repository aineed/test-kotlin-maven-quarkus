package advertisement.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity(name = "ad")
class AdEntity {
    @Column(name = "ad_id")
    @GeneratedValue
    @Id
    val adId: Int = 0

    lateinit var title: String
    lateinit var categoryName: String
}