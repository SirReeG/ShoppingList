package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository
import java.lang.RuntimeException



    object ShopListRepositoryImpl: ShopListRepository


    {
        private val shopListLiveData = MutableLiveData<List<ShopItem>>()
        private val shoplist = mutableListOf<ShopItem>()
        private  var autoIncrementId = 0;

        override fun addShopItem(shopItem: ShopItem) {
            if(shopItem.id == ShopItem.UNDEFINED_ID){
               shopItem.id = autoIncrementId
            autoIncrementId++
            }
            shoplist.add(shopItem)
            updateList()
        }

        override fun deleteShopItem(shopItem: ShopItem) {
            shoplist.remove(shopItem)
        }

        override fun edtiShopItem(shopItem: ShopItem)
        {
            val oldElement = getShopItem(shopItem.id)
            shoplist.remove(oldElement)
            addShopItem(shopItem)
            updateList()
        }

        override fun getShopItem(shopItemId: Int): ShopItem {
            return shoplist.find {
                it.id == shopItemId
            }?: throw RuntimeException("Элемент c ID$shopItemId Не найдет")
            }


        override fun getShopList(): LiveData<List<ShopItem>> {
            return shopListLiveData
        }

        private fun updateList(){

            shopListLiveData.value = shoplist.toList()

        }


    }

