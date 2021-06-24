export class Item {
    name: string;
    sellIn: number;
    quality: number;

    constructor(name, sellIn, quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
}

export class Product extends Item {
    constructor(name:string, sellIn:number, quality:number){
        super(name, sellIn, quality);
    }

    updateQuality(){
        if (this.sellIn>0){
            this.quality -= 1;
        } else {
            this.quality -=2;
        }
        if (this.quality < 0){
            this.quality = 0;
        } else if (this.quality > 50){
            this.quality = 50;
        }
        this.sellIn -= 1;
    }
}

export class AgedBrie extends Item {
    constructor(name:string, sellIn:number, quality:number) {
        super(name, sellIn, quality);
    }

    updateQuality(){
        this.quality += 2;
        if (this.quality < 0){
            this.quality = 0;
        } else if (this.quality > 50){
            this.quality = 50;
        }
        this.sellIn -= 1;
    }
}

export class Sulfuras extends Item {
    constructor(name:string, sellIn:number, quality:number) {
        super(name, sellIn, quality);
    }

    updateQuality(){
    }
}

export class BackstagePass extends Item {
    constructor(name:string, sellIn:number, quality:number) {
        super(name, sellIn, quality);
    }

    updateQuality(){
        if (this.sellIn > 10){
            this.quality += 1;
        } else if (this.sellIn > 5) {
            this.quality += 2;
        } else if (this.sellIn > 0){
            this.quality += 3;
        } else {
            this.quality = 0;
        }

        if (this.quality < 0){
            this.quality = 0;
        } else if (this.quality > 50){
            this.quality = 50;
        }
        this.sellIn -= 1;
    }
}

export class GildedRose {
    items: Array<Item>;

    constructor(items = [] as Array<Item>) {
        this.items = items;
    }

    updateQuality() : Array<Item> {
        this.items = this.items.map(item => { return this.qualityUpdater(item)})
        return this.items;
    }

    qualityUpdater(item:Item) : Item{
        switch (item.name) {
            case "Aged Brie":
                var mutatedItem = new AgedBrie(item.name, item.sellIn, item.quality);
                break;
            case "Sulfuras, Hand of Ragnaros":
                var mutatedItem = new Sulfuras(item.name, item.sellIn, item.quality);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                var mutatedItem = new BackstagePass(item.name, item.sellIn, item.quality);
                break;
            default:
                var mutatedItem = new Product(item.name, item.sellIn, item.quality);
                break;
        }
        mutatedItem.updateQuality();
        return mutatedItem;
    }
}
