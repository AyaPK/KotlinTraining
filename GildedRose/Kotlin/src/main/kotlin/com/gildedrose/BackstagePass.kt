package com.gildedrose

class BackstagePass(name:String, sellIn:Int, quality:Int) : Product(name, sellIn, quality){
    override fun updateQuality(){
        if(this.sellIn > 10) {
            this.quality += 1;
            this.sellIn -= 1;
        } else if(this.sellIn > 5) {
            this.quality += 2;
            this.sellIn -= 1;
        } else if(this.sellIn > 0) {
            this.quality += 3;
            this.sellIn -= 1;
        }
        else {
            this.quality = 0;
        }
    }
}