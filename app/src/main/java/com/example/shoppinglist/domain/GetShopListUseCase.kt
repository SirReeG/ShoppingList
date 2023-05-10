package com.example.shoppinglist.domain

import com.example.shoppinglist.data.ShopListRepositoryImpl

class GetShopListUseCase(private val shopListRepository: ShopListRepositoryImpl){
    
    fun getShopList():List<ShopItem>{

        return shopListRepository.getShopList()
    }

}