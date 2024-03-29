package com.example.vkandroid.api

import com.example.vkandroid.Constants
import com.example.vkandroid.ProductUIModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.appendPathSegments
import io.ktor.utils.io.errors.IOException

class ApiServiceImpl(
    private val client: HttpClient
) : ApiService {
    override suspend fun getProducts(): ApiResult<List<ProductUIModel>> {
        val url = ApiRoutes.BASE_URL + ApiRoutes.PRODUCTS

        try {
            val response = client.get(url) {
                url {
                    parameters.append("limit", Constants.LIMIT_PRODUCTS.toString())
                }
            }

            return when (response.status.value) {
                in 200..299 -> {
                    ApiResult.Success(response.body<ListOfProductsSerializable>().products.map { it.convertToUIModel() })
                }

                else -> {
                    ApiResult.Error("Code ${response.status.value}: ${response.status.description}")
                }
            }

        } catch (e: IOException) {
            return ApiResult.Error("No connection!")
        } catch (e: Exception) {
            return ApiResult.Error("${e.message}")
        }
    }

    override suspend fun getProducts(skip: Int, category: String?): ApiResult<List<ProductUIModel>> {
        var url = ApiRoutes.BASE_URL + ApiRoutes.PRODUCTS

        if (category != null) {
            url += ApiRoutes.CATEGORY
        }

        try {
            val response = client.get(url) {
                url {
                    if (category != null) {
                        appendPathSegments(category)
                    }
                    parameters.append("skip", skip.toString())
                    parameters.append("limit", Constants.LIMIT_PRODUCTS.toString())
                }
            }

            return when (response.status.value) {
                in 200..299 -> {
                    ApiResult.Success(response.body<ListOfProductsSerializable>().products.map { it.convertToUIModel() })
                }

                else -> {
                    ApiResult.Error("Code ${response.status.value}: ${response.status.description}")
                }
            }

        } catch (e: IOException) {
            return ApiResult.Error("No connection!")
        } catch (e: Exception) {
            return ApiResult.Error("${e.message}")
        }
    }


    override suspend fun getProducts(query: String): ApiResult<List<ProductUIModel>> {
        val url = ApiRoutes.BASE_URL + ApiRoutes.PRODUCTS + ApiRoutes.SEARCH

        try {
            val response = client.get(url) {
                url {
                    parameters.append("q", query)
                }
            }

            return when (response.status.value) {
                in 200..299 -> {
                    ApiResult.Success(response.body<ListOfProductsSerializable>().products.map { it.convertToUIModel() })
                }

                else -> {
                    ApiResult.Error("Code ${response.status.value}: ${response.status.description}")
                }
            }

        } catch (e: IOException) {
            return ApiResult.Error("No connection!")
        } catch (e: Exception) {
            return ApiResult.Error("${e.message}")
        }
    }

    override suspend fun getCategories(): ApiResult<List<String>> {
        val url = ApiRoutes.BASE_URL + ApiRoutes.PRODUCTS + ApiRoutes.CATEGORIES

        try {
            val response = client.get(url)

            return when (response.status.value) {
                in 200..299 -> {
                    ApiResult.Success(response.body())
                }

                else -> {
                    ApiResult.Error("Code ${response.status.value}: ${response.status.description}")
                }
            }
        } catch (e: IOException) {
            return ApiResult.Error("No connection!")
        } catch (e: Exception) {
            return ApiResult.Error("${e.message}")
        }
    }

    override suspend fun getProductsByCategory(category: String): ApiResult<List<ProductUIModel>> {
        val url = ApiRoutes.BASE_URL + ApiRoutes.PRODUCTS + ApiRoutes.CATEGORY

        try {
            val response = client.get(url) {
                url {
                    appendPathSegments(category)
                }
            }

            return when (response.status.value) {
                in 200..299 -> {
                    ApiResult.Success(response.body<ListOfProductsSerializable>().products.map { it.convertToUIModel() })
                }

                else -> {
                    ApiResult.Error("Code ${response.status.value}: ${response.status.description}")
                }
            }
        } catch (e: IOException) {
            return ApiResult.Error("No connection!")
        } catch (e: Exception) {
            return ApiResult.Error("${e.message}")
        }
    }
}
