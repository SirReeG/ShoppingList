package com.example.shoppinglist.domain

import com.example.shoppinglist.data.ShopListRepositoryImpl

class GetShopListUseCase(private val shopListRepository: ShopListRepository){
    
    fun getShopList():List<ShopItem>{

        return shopListRepository.getShopList()
    }

}