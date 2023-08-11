package advertisement.domain

data class Ad(
        val title: String,
        val category: Category,
        val profileId: Int,
        val tags: List<Tag>
)
