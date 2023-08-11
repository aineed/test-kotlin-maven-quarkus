package advertisement.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity(name = "adtags")
class AdTagEntity {
    @Column(name = "ad_id")
    var adId: Int = 0

    @Column(name = "tag_name")
    lateinit var tagName: String
}