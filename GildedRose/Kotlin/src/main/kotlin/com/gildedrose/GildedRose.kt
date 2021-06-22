package com.gildedrose

class GildedRose(var items: Array<Item>) {

    private var mappedItems:ArrayList<Product> = ArrayList<Product>();

    init {
        for (i in items.indices){
            if (items[i].name == "Aged Brie"){
                mappedItems.add(AgedBrie(items[i].name, items[i].sellIn, items[i].quality));
            } else if (items[i].name == "Sulfuras, Hand of Ragnaros") {
                mappedItems.add(Sulfuras(items[i].name, items[i].sellIn, items[i].quality));
            } else if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                mappedItems.add(BackstagePass(items[i].name, items[i].sellIn, items[i].quality));
            }
            else {
                mappedItems.add(Product(items[i].name, items[i].sellIn, items[i].quality));
            }
        }
    }

    fun updateQuality() {
        for (i in mappedItems.indices){
            mappedItems[i].updateQuality();
            items[i].quality = mappedItems[i].quality;
            items[i].sellIn = mappedItems[i].sellIn;
        }
    }
}

