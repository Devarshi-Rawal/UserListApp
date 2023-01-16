package com.example.userlistapp.models

import com.google.gson.annotations.SerializedName

data class UserList(

	@field:SerializedName("UserList")
	val userList: List<UserListItem>
)

data class Social(

	@field:SerializedName("twitter_username")
	val twitterUsername: String,

	@field:SerializedName("paypal_email")
	val paypalEmail: Any,

	@field:SerializedName("instagram_username")
	val instagramUsername: String,

	@field:SerializedName("portfolio_url")
	val portfolioUrl: String
)

data class Sponsorship(

	@field:SerializedName("sponsor")
	val sponsor: Sponsor,

	@field:SerializedName("tagline_url")
	val taglineUrl: String,

	@field:SerializedName("tagline")
	val tagline: String,

	@field:SerializedName("impression_urls")
	val impressionUrls: List<String>
)

data class Links(

	@field:SerializedName("followers")
	val followers: String,

	@field:SerializedName("portfolio")
	val portfolio: String,

	@field:SerializedName("following")
	val following: String,

	@field:SerializedName("self")
	val self: String,

	@field:SerializedName("html")
	val html: String,

	@field:SerializedName("photos")
	val photos: String,

	@field:SerializedName("likes")
	val likes: String,

	@field:SerializedName("download")
	val download: String,

	@field:SerializedName("download_location")
	val downloadLocation: String
)

data class Sponsor(

	@field:SerializedName("total_photos")
	val totalPhotos: Int,

	@field:SerializedName("accepted_tos")
	val acceptedTos: Boolean,

	@field:SerializedName("social")
	val social: Social,

	@field:SerializedName("twitter_username")
	val twitterUsername: String,

	@field:SerializedName("last_name")
	val lastName: Any,

	@field:SerializedName("bio")
	val bio: String,

	@field:SerializedName("total_likes")
	val totalLikes: Int,

	@field:SerializedName("portfolio_url")
	val portfolioUrl: String,

	@field:SerializedName("profile_image")
	val profileImage: ProfileImage,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("for_hire")
	val forHire: Boolean,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("location")
	val location: Any,

	@field:SerializedName("links")
	val links: Links,

	@field:SerializedName("total_collections")
	val totalCollections: Int,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("first_name")
	val firstName: String,

	@field:SerializedName("instagram_username")
	val instagramUsername: String,

	@field:SerializedName("username")
	val username: String
)

data class ProfileImage(

	@field:SerializedName("small")
	val small: String,

	@field:SerializedName("large")
	val large: String,

	@field:SerializedName("medium")
	val medium: String
)

data class Urls(

	@field:SerializedName("small")
	val small: String,

	@field:SerializedName("small_s3")
	val smallS3: String,

	@field:SerializedName("thumb")
	val thumb: String,

	@field:SerializedName("raw")
	val raw: String,

	@field:SerializedName("regular")
	val regular: String,

	@field:SerializedName("full")
	val full: String
)

data class UserListItem(

	@field:SerializedName("topic_submissions")
	val topicSubmissions: TopicSubmissions,

	@field:SerializedName("current_user_collections")
	val currentUserCollections: List<Any>,

	@field:SerializedName("color")
	val color: String,

	@field:SerializedName("sponsorship")
	val sponsorship: Sponsorship,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("description")
	val description: Any? = null,

	@field:SerializedName("liked_by_user")
	val likedByUser: Boolean,

	@field:SerializedName("urls")
	val urls: Urls,

	@field:SerializedName("alt_description")
	val altDescription: Any? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("width")
	val width: Int,

	@field:SerializedName("blur_hash")
	val blurHash: String,

	@field:SerializedName("links")
	val links: Links,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("promoted_at")
	val promotedAt: Any,

	@field:SerializedName("user")
	val user: User,

	@field:SerializedName("height")
	val height: Int,

	@field:SerializedName("likes")
	val likes: Int
)

data class User(

	@field:SerializedName("total_photos")
	val totalPhotos: Int,

	@field:SerializedName("accepted_tos")
	val acceptedTos: Boolean,

	@field:SerializedName("social")
	val social: Social,

	@field:SerializedName("twitter_username")
	val twitterUsername: String,

	@field:SerializedName("last_name")
	val lastName: Any,

	@field:SerializedName("bio")
	val bio: Any? = null,

	@field:SerializedName("total_likes")
	val totalLikes: Int,

	@field:SerializedName("portfolio_url")
	val portfolioUrl: String,

	@field:SerializedName("profile_image")
	val profileImage: ProfileImage,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("for_hire")
	val forHire: Boolean,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("location")
	val location: Any? = null,

	@field:SerializedName("links")
	val links: Links,

	@field:SerializedName("total_collections")
	val totalCollections: Int,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("first_name")
	val firstName: String,

	@field:SerializedName("instagram_username")
	val instagramUsername: String,

	@field:SerializedName("username")
	val username: String
)

data class TopicSubmissions(
	val any: Any? = null
)
