package com.example.shoppinglist.domain

import com.example.shoppinglist.data.ShopListRepositoryImpl

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun edtiShopItem(shopItem: ShopItem) {

        shopListRepository.edtiShopItem(shopItem)

    }

}