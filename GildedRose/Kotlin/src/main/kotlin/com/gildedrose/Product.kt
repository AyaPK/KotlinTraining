package com.gildedrose

open class Product(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    open fun updateQuality() {
        if(this.sellIn > 0) {
            this.quality -= 1;
        } else {
            this.quality -= 2;
        }
        this.sellIn -= 1;

        if (this.quality < 0){
            this.quality = 0;
        }
    }
}