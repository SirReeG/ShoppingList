package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository
import java.lang.RuntimeException


object ShopListRepositoryImpl: ShopListRepository


    {
        private val shopListLiveData = MutableLiveData<List<ShopItem>>()
        private val shoplist = sortedSetOf<ShopItem>({ o1, o2 -> o1.id.compareTo(o2.id) })
        private  var autoIncrementId = 0;


        init {
            for (i in 0 until 1000) {
                val item = ShopItem("Название $i", i, true)
                addShopItem(item)
            }
        }



        override fun addShopItem(shopItem: ShopItem) {
            if(shopItem.id == ShopItem.UNDEFINED_ID){
               shopItem.id =autoIncrementId++
            }
            shoplist.add(shopItem)
            updateList()
        }

        override fun deleteShopItem(shopItem: ShopItem) {
            shoplist.remove(shopItem)
            updateList()
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

