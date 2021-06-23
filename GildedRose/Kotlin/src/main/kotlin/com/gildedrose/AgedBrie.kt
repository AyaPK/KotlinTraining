package com.gildedrose

class AgedBrie(name:String, sellIn:Int, quality:Int) : Product(name, sellIn, quality){
    override fun updateQuality(){
        if(this.sellIn > 0) {
            this.quality += 2;
        } else {
            this.quality += 2;
        }
        this.sellIn -= 1;

        if (this.quality < 0){
            this.quality = 0;
        } else if (this.quality > 50) {
            this.quality = 50;
        }
    }
}