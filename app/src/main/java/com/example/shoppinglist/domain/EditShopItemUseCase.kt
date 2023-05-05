package com.example.shoppinglist.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun edtiShopItem(shopItem: ShopItem) {

        shopListRepository.edtiShopItem(shopItem)

    }

}