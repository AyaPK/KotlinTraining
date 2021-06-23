import { expect } from 'chai';4
import { Item, GildedRose } from '../app/gilded-rose';

describe('Gilded Rose', function () {

    it('Quality Should Get Updated', function() {
        const gildedRose = new GildedRose([ new Item('foo', 5, 5) ]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(4);
    });

    it('SellIn Should Get Updated', function() {
        const gildedRose = new GildedRose([ new Item('foo', 5, 5) ]);
        const items = gildedRose.updateQuality();
        expect(items[0].sellIn).to.equal(4);
    });

    it('Out Of Date Item Quality Should Get Updated Twice As Fast', function() {
        const gildedRose = new GildedRose([ new Item('foo', 0, 5) ]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(3);
    });

    it('Quality Should Never Be Negative', function() {
        const gildedRose = new GildedRose([ new Item('foo', 0, 1) ]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(0);
    });

    it('Aged Brie Quality Increases', function() {
        const gildedRose = new GildedRose([ new Item('Aged Brie', 0, 5) ]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(7);
    });

    it('Quality Should Never Go Over 50', function() {
        const gildedRose = new GildedRose([ new Item('Aged Brie', 10, 45) ]);
        
        var items = gildedRose.updateQuality();
        for (var x:number = 0; x < 10; x++){
            gildedRose.updateQuality();
        }

        expect(items[0].quality).to.equal(50);
    });

    it('Sulfuras should never change', function() {
        const gildedRose = new GildedRose([ new Item('Sulfuras, Hand of Ragnaros', 10, 80) ]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(80);
        expect(items[0].sellIn).to.equal(10);
    });

    it('Backstage pass increases by 1 when there is more than 10 days left', function() {
        const gildedRose = new GildedRose([ new Item('Backstage passes to a TAFKAL80ETC concert', 11, 1) ]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(2);
    });

    it('Backstage pass increases by 2 when there is 10 or less days left', function() {
        const gildedRose = new GildedRose([ new Item('Backstage passes to a TAFKAL80ETC concert', 10, 1) ]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(3);
    });

    it('Backstage pass increases by 3 when there is 5 or less days left', function() {
        const gildedRose = new GildedRose([ new Item('Backstage passes to a TAFKAL80ETC concert', 5, 1) ]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(4);
    });

    it('Backstage pass quality becomes 0 if sellIn in 0', function() {
        const gildedRose = new GildedRose([ new Item('Backstage passes to a TAFKAL80ETC concert', 0, 1) ]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(0);
    });
});
