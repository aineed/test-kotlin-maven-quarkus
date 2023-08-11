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

    @Column(name = "title")
    lateinit var title: String

    @Column(name = "category_name")
    lateinit var categoryName: String

    @Column(name = "profile_id")
    var profileId: Int = 0
}