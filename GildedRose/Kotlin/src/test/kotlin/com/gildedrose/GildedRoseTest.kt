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
    fun outOfDateItemQualityGetsUpdatedTwiceAsFast() {
        val items = arrayOf<Item>(Item("foo", 0, 5))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(3, app.items[0].quality)
    }

    @Test
    fun qualityIsNeverNegative() {
        val items = arrayOf<Item>(Item("foo", 0, 1))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun agedBrieQualityIncreases() {
        val items = arrayOf<Item>(Item("Aged Brie", 0, 5))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(7, app.items[0].quality)
    }

    @Test
    fun qualityNeverGoesOverFifty() {
        val items = arrayOf<Item>(Item("Aged Brie", 10, 45))
        val app = GildedRose(items)

        for (x in 1..10) {
            app.updateQuality()
        }

        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun sulfurasNeverChanges() {
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros", 5, 80))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(5, app.items[0].sellIn)
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun sulfurasQualityIsAlways80(){
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros", 5, 30))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun backstagePassesIncreaseByOneWhenMoreThan10daysLeft(){
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 15, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun backstagePassesIncreaseByTwoWhen10orLessdaysLeft(){
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 10, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun backstagePassesIncreaseByThreeWhen5orLessdaysLeft(){
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 5, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(13, app.items[0].quality)
    }

    @Test
    fun backstagePassesQualityDropsToZeroAfterSellInHits0(){
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 0, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun conjuredItemsDegradeBy2WhenWithinSellInTime(){
        val items = arrayOf<Item>(Item("Conjured Mana Cake", 10, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun conjuredItemsDegradeBy4WhenOutOfSellInTime(){
        val items = arrayOf<Item>(Item("Conjured Mana Cake", 0, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(6, app.items[0].quality)
    }

}

