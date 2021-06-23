package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        this.items = items.map { qualityUpdater(it) }.toTypedArray();
    }

    fun qualityUpdater(item: Item): Item {
        val mutatedItem = when (item.name) {
            "Aged Brie" -> AgedBrie(item.name, item.sellIn, item.quality)
            "Sulfuras, Hand of Ragnaros" -> Sulfuras(item.name, item.sellIn, item.quality)
            "Backstage passes to a TAFKAL80ETC concert" -> BackstagePass(item.name, item.sellIn, item.quality)
            "Conjured Mana Cake" -> Conjured(item.name, item.sellIn, item.quality)
            else -> Product(item.name, item.sellIn, item.quality)
        }
        mutatedItem.updateQuality()
        return mutatedItem;
    }

}