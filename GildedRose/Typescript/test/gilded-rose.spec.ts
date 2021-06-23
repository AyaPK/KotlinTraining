import { expect } from 'chai';4
import { Item, GildedRose } from '../app/gilded-rose';

describe('Gilded Rose', function () {

    it('Quality Should Get Updated', function() {
        const gildedRose = new GildedRose([ new Item('foo', 5, 5) ]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(4);
    });

});
