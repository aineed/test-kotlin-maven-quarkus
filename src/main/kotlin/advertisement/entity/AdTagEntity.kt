package advertisement.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "adtags")
class AdTagEntity {
    @Column(name = "ad_id")
    @Id
    var adId: Int = 0

    @Column(name = "tag_name")
    lateinit var tagName: String
}