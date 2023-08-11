package advertisement.service

import advertisement.domain.Ad
import advertisement.domain.Category
import advertisement.domain.Tag
import advertisement.entity.AdEntity
import advertisement.entity.AdTagEntity
import advertisement.entity.CategoryEntity
import advertisement.entity.TagEntity
import advertisement.repository.AdRepository
import advertisement.repository.AdTagRepository
import advertisement.repository.CategoryRepository
import advertisement.repository.TagRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional


@ApplicationScoped
class AdService(
        val adRepository: AdRepository,
        val adTagRepository: AdTagRepository,
        val tagRepository: TagRepository,
        val categoryRepository: CategoryRepository
) {
    @Transactional
    fun storeAd(ad: Ad) {
        checkOrStoreCategory(ad)

        val adEntity = mapToAdEntity(ad)
        adRepository.persist(adEntity)

        //Todo: finn ut hvordan man filterer ikke registert tags
        val missingTags =
                ad.tags.stream().map { tag -> { tagRepository.findByName(tag.name) } }.toList()
        //TODO: missingTags skal store
        /* missingTags.stream().forEach {
             it.let { tagRepository.persist(Optional.of(it.invoke()).get()) }
         }*/

        ad.tags.stream().forEach {
            val adTagEntity = mapToAdTagEntity(adEntity.adId, it.name)
            adTagRepository.persist(adTagEntity)
        }

    }

    private fun checkOrStoreCategory(ad: Ad) {
        val categoryEntity =
                categoryRepository.findByName(ad.category.name)
        if (categoryEntity == null) {
            val categoryEntity = mapToCategoryEntity(Category(ad.category.name))
            categoryRepository.persist(categoryEntity)
        }
    }

    @Transactional
    fun deleteAd(adId: Int): Boolean {
        return adRepository.deleteById(adId.toLong())
    }

    @Transactional
    fun getAdById(adId: Int): Ad? {
        val adEntity = adRepository.findById(adId.toLong())

        val allTagsInAd = adTagRepository.findAllTagByAdId(adId)
        val tagNames = allTagsInAd.list().map { Tag(it.tagName)}.toList()

        return adEntity?.let { mapToAdDto(it, tagNames ) }
    }


    fun mapToAdEntity(ad: Ad): AdEntity {
        val adEntity = AdEntity()
        adEntity.title = ad.title
        adEntity.categoryName = ad.category.name
        adEntity.profileId = ad.profileId
        return adEntity
    }

    fun mapToTagEntity(tag: Tag): TagEntity {
        val tagEntity = TagEntity()
        tagEntity.name = tag.name
        return tagEntity
    }

    fun mapToAdTagEntity(adId: Int, tagName: String): AdTagEntity {
        val adTagEntity = AdTagEntity()
        adTagEntity.adId = adId
        adTagEntity.tagName = tagName
        return adTagEntity
    }

    fun mapToCategoryEntity(category: Category): CategoryEntity {
        val categoryEntity = CategoryEntity()
        categoryEntity.name = categoryEntity.name
        return categoryEntity
    }

    fun mapToAdDto(adEntity: AdEntity, allTagsInAd: List<Tag>): Ad {
        return Ad(
                title = adEntity.title,
                category = Category(adEntity.categoryName),
                profileId = adEntity.profileId,
                tags = allTagsInAd
        )
    }

}