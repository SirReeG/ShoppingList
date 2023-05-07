package com.example.shoppinglist.data

import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository
import java.lang.RuntimeException

class ShopListRepositoryImpl {

    object ShopListRepositoryImpl: ShopListRepository


    {
        private val shoplist = mutableListOf<ShopItem>()
        override fun addShopItem(shopItem: ShopItem) {
            shoplist.add(shopItem)
        }

        override fun deleteShopItem(shopItem: ShopItem) {
            shoplist.remove(shopItem)
        }

        override fun edtiShopItem(shopItem: ShopItem)
        {
            val oldElement = getShopItem(shopItem.id)
            shoplist.remove(oldElement)
            addShopItem(shopItem)
        }

        override fun getShopItem(shopItemId: Int): ShopItem {
            return shoplist.find {
                it.id == shopItemId
            }?: throw RuntimeException("Элемент c ID$shopItemId Не найдет")
            }


        override fun getShopList(): List<ShopItem> {
            return shoplist.toList()
        }


    }

}