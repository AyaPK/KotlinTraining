package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun qualityGetsUpdated() {
        val items = arrayOf<Item>(Item("foo", 5, 5))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(4, app.items[0].quality)
    }

    @Test
    fun sellInGetsUpdated() {
        val items = arrayOf<Item>(Item("foo", 5, 5))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(4, app.items[0].sellIn)
    }

    @Test
    fun outOfDateQualityDegradation() {
        val items = arrayOf<Item>(Item("foo", 0, 5))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(3, items[0].quality)
    }

    @Test
    fun qualityNeverNegative() {
        val items = arrayOf<Item>(Item("foo", 0, 1))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(0, items[0].quality)
    }

    @Test
    fun agedBrieQualityIncreases() {
        val items = arrayOf<Item>(Item("Aged Brie", 0, 5))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(7, items[0].quality)
    }

    @Test
    fun qualityNeverOverFifty() {
        val items = arrayOf<Item>(Item("Aged Brie", 10, 45))
        val app = GildedRose(items)

        for (x in 1..10) {
            app.updateQuality()
        }

        assertEquals(50, items[0].quality)
    }

    @Test
    fun sulfurasNeverChanges() {
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros", 5, 5))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(5, items[0].sellIn)
        assertEquals(5, items[0].quality)
    }

    @Test
    fun backstagePassesIncreaseByOne(){
        var items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 15, 10))
        var app = GildedRose(items)

        app.updateQuality()

        assertEquals(11, items[0].quality)
    }

    @Test
    fun backstagePassesIncreaseByTwo(){
        var items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 8, 10))
        var app = GildedRose(items)

        app.updateQuality()

        assertEquals(12, items[0].quality)
    }

    @Test
    fun backstagePassesIncreaseByThree(){
        var items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 4, 10))
        var app = GildedRose(items)

        app.updateQuality()

        assertEquals(13, items[0].quality)
    }

    @Test
    fun backstagePassesQualityDrops(){
        var items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 0, 10))
        var app = GildedRose(items)

        app.updateQuality()

        assertEquals(0, items[0].quality)
    }


}


