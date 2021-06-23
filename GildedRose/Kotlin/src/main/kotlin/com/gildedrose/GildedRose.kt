package com.gildedrose

class GildedRose(var items: Array<Item>) {

    private var mappedItems:HashMap<Item, Product> = HashMap<Item, Product>();

    fun updateQuality() {
        for (item in items) {
            if (item !in mappedItems){
                mappedItems[item] = when (item.name) {
                    "Aged Brie" -> AgedBrie(item.name, item.sellIn, item.quality)
                    "Sulfuras, Hand of Ragnaros" -> Sulfuras(item.name, item.sellIn, item.quality)
                    "Backstage passes to a TAFKAL80ETC concert" -> BackstagePass(item.name, item.sellIn, item.quality)
                    "Conjured Mana Cake" -> Conjured(item.name, item.sellIn, item.quality)
                    else -> Product(item.name, item.sellIn, item.quality)
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

