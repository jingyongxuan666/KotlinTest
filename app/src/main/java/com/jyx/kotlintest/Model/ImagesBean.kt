package com.jyx.kotlintest.Model


data class ImagesBean(
    val `data`: List<Data>,
    val status: Int,
    val success: Boolean
)

data class Data(
    val account_id: Int,
    val account_url: String,
    val ad_config: AdConfig,
    val ad_type: Int,
    val ad_url: String,
    val comment_count: Int,
    val cover: String,
    val cover_height: Int,
    val cover_width: Int,
    val datetime: Int,
    val description: Any,
    val downs: Int,
    val favorite: Boolean,
    val favorite_count: Int,
    val id: String,
    val images: List<Image>,
    val images_count: Int,
    val in_gallery: Boolean,
    val in_most_viral: Boolean,
    val include_album_ads: Boolean,
    val is_ad: Boolean,
    val is_album: Boolean,
    val layout: String,
    val link: String,
    val nsfw: Boolean,
    val points: Int,
    val privacy: String,
    val score: Int,
    val section: String,
    val tags: List<Any>,
    val title: String,
    val topic: String,
    val topic_id: Int,
    val ups: Int,
    val views: Int,
    val vote: Any
)
data class Image(
    val account_id: Any,
    val account_url: Any,
    val ad_type: Int,
    val ad_url: String,
    val animated: Boolean,
    val bandwidth: Long,
    val comment_count: Any,
    val datetime: Int,
    val description: String,
    val downs: Any,
    val favorite: Boolean,
    val favorite_count: Any,
    val has_sound: Boolean,
    val height: Int,
    val id: String,
    val in_gallery: Boolean,
    val in_most_viral: Boolean,
    val is_ad: Boolean,
    val link: String,
    val nsfw: Any,
    val points: Any,
    val score: Any,
    val section: Any,
    val size: Int,
    val tags: List<Any>,
    val title: Any,
    val type: String,
    val ups: Any,
    val views: Int,
    val vote: Any,
    val width: Int
)

data class AdConfig(
    val highRiskFlags: List<Any>,
    val safeFlags: List<String>,
    val showsAds: Boolean,
    val unsafeFlags: List<Any>
)