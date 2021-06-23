package com.gildedrose

class GildedRose(var items: Array<Item>) {

    private var mappedItems:HashMap<Item, Product> = HashMap<Item, Product>();


    fun updateQuality() {
        for (item in items){
            if (item !in mappedItems){
                if (item.name == "Aged Brie"){
                    mappedItems[item] = AgedBrie(item.name, item.sellIn, item.quality);
                } else if (item.name == "Sulfuras, Hand of Ragnaros") {
                    mappedItems[item] = Sulfuras(item.name, item.sellIn, item.quality);
                } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                    mappedItems[item] = BackstagePass(item.name, item.sellIn, item.quality);
                }
                else {
                    mappedItems[item] = Product(item.name, item.sellIn, item.quality);
                }
            }
        }

        for (item in mappedItems){
            item.value.updateQuality();
            item.key.quality = item.value.quality;
            item.key.sellIn = item.value.sellIn;
        }

    }
}

