package com.davidcai.aad.ut01.ex06.data.remote

import com.davidcai.aad.ut01.ex06.domain.Address
import com.davidcai.aad.ut01.ex06.domain.Company
import com.davidcai.aad.ut01.ex06.domain.Geo
import com.davidcai.aad.ut01.ex06.domain.User

class UsersRemoteDataSource {

    fun getUsers(): List<User> = mutableListOf(


        User(
            1,
            "User1",
            "Username1",
            "email1@email.com",
            Address(
                "calle1",
                "suite1",
                "city1",
                "zipcode1",
                Geo(
                    "11",
                    "12"
                )
            ),
            "phone1",
            "website1",
            Company(
                "company1",
                "hello there1",
                "holi1"
            )
        ),

        User(
            2,
            "User2",
            "Username2",
            "email2@email.com",
            Address(
                "calle2",
                "suite2",
                "city2",
                "zipcode2",
                Geo(
                    "21",
                    "22"
                )
            ),
            "phone2",
            "website2",
            Company(
                "company2",
                "hello there2",
                "holi2"
            )
        ),

        User(
            3,
            "User3",
            "Username3",
            "email3@email.com",
            Address(
                "calle3",
                "suite3",
                "city3",
                "zipcode3",
                Geo(
                    "31",
                    "32"
                )
            ),
            "phone3",
            "website3",
            Company(
                "company3",
                "hello there3",
                "holi3"
            )
        ),
    )


    fun getUser(userId: Int): User {
        return User(
            userId,
            "User$userId",
            "Username$userId",
            "email$userId",
            Address(
                "street$userId",
                "suite$userId",
                "city$userId",
                "zipcode$userId",
                Geo(
                    "lat$userId",
                    "lng$userId"
                )
            ),
            "phone$userId",
            "website$userId",
            Company(
                "name$userId",
                "catchPhrase$userId",
                "bs$userId"
            )
        )
    }

}
