package com.example.shoppinglist.domain

import com.example.shoppinglist.data.ShopListRepositoryImpl

class EditShopItemUseCase(private val shopListRepository: ShopListRepositoryImpl) {

    fun edtiShopItem(shopItem: ShopItem) {

        shopListRepository.edtiShopItem(shopItem)

    }

}