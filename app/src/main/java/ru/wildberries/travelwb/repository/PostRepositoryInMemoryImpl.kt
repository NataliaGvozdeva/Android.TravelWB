package ru.wildberries.travelwb.repository;

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.wildberries.travelwb.dto.Post

class PostRepositoryInMemoryImpl : PostRepository {

private var posts = listOf(
        Post(
                startCity = "Москва",
                startCityCode = "mow",
                endCity = "Санкт-Петербург",
                endCityCode = "led",
                startDate = "2022-07-17T00:00:00Z",
                endDate = "2022-07-24T00:00:00Z",
                price = 2690,
                searchToken = "MOW1707LED2407Y100",
                likedByMe = false,
                likesSum = 0
        ),
        Post(
                startCity = "Москва",
                startCityCode = "mow",
                endCity = "Нижний Новгород",
                endCityCode = "goj",
                startDate = "2022-06-10T00:00:00Z",
                endDate = "2022-06-14T00:00:00Z",
                price = 3140,
                searchToken = "MOW1006GOJ1406Y100",
                likedByMe = false,
                likesSum = 0
        ),
        Post(
                startCity = "Москва",
                startCityCode = "mow",
                endCity = "Махачкала",
                endCityCode = "mcx",
                startDate = "2022-10-16T00:00:00Z",
                endDate = "2022-10-20T00:00:00Z",
                price = 4570,
                searchToken = "MOW1610MCX2010Y100",
                likedByMe = false,
                likesSum = 0
        ),
        Post(
                startCity = "Москва",
                startCityCode = "mow",
                endCity = "Калининград",
                endCityCode = "kgd",
                startDate = "2022-10-10T00:00:00Z",
                endDate = "2022-10-13T00:00:00Z",
                price = 4570,
                searchToken = "MOW1010KGD1310Y100",
                likedByMe = false,
                likesSum = 0
        ),
        Post(
                startCity = "Москва",
                startCityCode = "mow",
                endCity = "Казань",
                endCityCode = "kzn",
                startDate = "2022-06-21T00:00:00Z",
                endDate = "2022-06-30T00:00:00Z",
                price = 4760,
                searchToken = "MOW2106KZN3006Y100",
                likedByMe = false,
                likesSum = 0
        ),
        Post(
                startCity = "Москва",
                startCityCode = "mow",
                endCity = "Самара",
                endCityCode = "kuf",
                startDate = "2022-09-06T00:00:00Z",
                endDate = "2022-09-11T00:00:00Z",
                price = 4902,
                searchToken = "MOW0609KUF1109Y100",
                likedByMe = false,
                likesSum = 0
        ),
        Post(
                startCity = "Москва",
                startCityCode = "mow",
                endCity = "Краснодар",
                endCityCode = "krr",
                startDate = "2023-04-15T00:00:00Z",
                endDate = "2023-04-23T00:00:00Z",
                price = 4914,
                searchToken = "MOW1504KRR2304Y100",
                likedByMe = false,
                likesSum = 0
        ),
        Post(
                startCity = "Москва",
                startCityCode = "mow",
                endCity = "Екатеринбург",
                endCityCode = "svx",
                startDate = "2022-06-16T00:00:00Z",
                endDate = "2022-06-21T00:00:00Z",
                price = 5096,
                searchToken = "MOW1606SVX2106Y100",
                likedByMe = false,
                likesSum = 0
        ),
        Post(
                startCity = "Москва",
                startCityCode = "mow",
                endCity = "Пермь",
                endCityCode = "pee",
                startDate = "2022-06-10T00:00:00Z",
                endDate = "2022-06-13T00:00:00Z",
                price = 5140,
                searchToken = "MOW1006PEE1306Y100",
                likedByMe = false,
                likesSum = 0
        ),
        Post(
                startCity = "Москва",
                startCityCode = "mow",
                endCity = "Волгоград",
                endCityCode = "vog",
                startDate = "2022-06-13T00:00:00Z",
                endDate = "2022-06-19T00:00:00Z",
                price = 5140,
                searchToken = "MOW1306VOG1906Y100",
                likedByMe = false,
                likesSum = 0
        )
        )

        private val data = MutableLiveData(posts)

        override fun getAll(): LiveData<List<Post>> = data

        override fun likeBySearchToken(searchToken: String) {
                posts = posts.map {
                        if (it.searchToken != searchToken) it else it.copy(
                                likedByMe = !it.likedByMe,
                                likesSum = if (!it.likedByMe) it.likesSum + 1 else it.likesSum - 1
                        )
                }
                data.value = posts
        }

}
