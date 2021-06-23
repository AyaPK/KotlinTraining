package com.gildedrose

class Sulfuras(name:String, sellIn:Int, quality:Int) : Product(name, sellIn, quality) {
    override fun updateQuality(){
        this.quality = 80;
    }
}