package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {
    @Test
    void vipQualityMore1or2or3() {
        Item[] items = new Item[] {
                new Item("Pass VIP Concert", 10, 10),
                new Item("Pass VIP Concert", 5, 10),
                new Item("Pass VIP Concert", 15, 10)
        };
        Magasin app = new Magasin(items);
        for (int i = 0; i < 2; i++) {
            app.updateQuality();
        }
        assertEquals(14, app.items[0].quality);
        assertEquals(16, app.items[1].quality);
        assertEquals(12, app.items[2].quality);
        assertEquals(8, app.items[0].sellIn);
        assertEquals(3, app.items[1].sellIn);
        assertEquals(13, app.items[2].sellIn);
    }
    @Test
    void vipQualityForRarity() {
        Item[] items = new Item[] {
                new Item("Pass VIP Concert", 12, 10),
                new Item("Pass VIP Concert", 11, 10),
                new Item("Pass VIP Concert", 10, 10),
                new Item("Pass VIP Concert", 6, 10),
                new Item("Pass VIP Concert", 5, 10),
                new Item("Pass VIP Concert", 4, 10)
        };
        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals(11, app.items[0].quality);
        assertEquals(11, app.items[1].quality);
        assertEquals(12, app.items[2].quality);
        assertEquals(12, app.items[3].quality);
        assertEquals(13, app.items[4].quality);
        assertEquals(13, app.items[5].quality);

        assertEquals(11, app.items[0].sellIn);
        assertEquals(10, app.items[1].sellIn);
        assertEquals(9, app.items[2].sellIn);
        assertEquals(5, app.items[3].sellIn);
        assertEquals(4, app.items[4].sellIn);
        assertEquals(3, app.items[5].sellIn);
    }
    @Test
    void vipZeroQualityAfterDatePass() {
        Item[] items = new Item[] {
                new Item("Pass VIP Concert", 1, 10),
                new Item("Pass VIP Concert", 0, 10)
        };
        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals(13, app.items[0].quality);
        assertEquals(0, app.items[1].quality);

        assertEquals(0, app.items[0].sellIn);
        assertEquals(-1, app.items[1].sellIn);
    }
    @Test
    void qualityNeverExceeds50() {
        Item[] items = new Item[] {
                new Item("Comté", 10, 48),
                new Item("Pass VIP Concert", 5, 48),
                new Item("Kryptonite", 0, 80)
        };
        Magasin app = new Magasin(items);
        for (int i = 0; i < 4; i++) {
            app.updateQuality();
        }
        assertEquals(50, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
        assertEquals(80, app.items[2].quality);

        assertEquals(6, app.items[0].sellIn);
        assertEquals(1, app.items[1].sellIn);
        assertEquals(0, app.items[2].sellIn);
    }
    @Test
    void kryptoniteNeverMoveTo80Quality() {
        Item[] items = new Item[]{
                new Item("Kryptonite", 0, 80),
        };
        Magasin app = new Magasin(items);
        for (int i = 0; i < 1; i++) {
            app.updateQuality();
        }
        assertEquals(80, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
        for (int i = 0; i < 1; i++) {
            app.updateQuality();
        }
        assertEquals(80, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }
    @Test
    void testQualityAfterSellInPassing() {
        Item[] items = new Item[] {new Item("too", 1, 10),
                new Item("too2", 2, 24),
        };

        Magasin app = new Magasin(items);

        for (int i = 0; i < 3; i++) {
            app.updateQuality();
        }
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(20, app.items[1].quality);

    }

    @Test
    void qualityCantNegative() {
        Item[] items = new Item[]{new Item("too", 20, 10),
                new Item("too2", 25, 1),
                new Item("Pass VIP Concert ", 5, 20)
        };
        Magasin app = new Magasin(items);

        for (int i = 0; i < 20; i++) {
            app.updateQuality();
        }
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        assertEquals(5, app.items[1].sellIn);
        assertEquals(0, app.items[1].quality);
        assertEquals(-15, app.items[2].sellIn);
        assertEquals(0, app.items[2].quality);

    }

    @Test
    void comteGainQuality(){
        Item[] items = new Item[]{new Item("Comté", 5, 10),
                new Item("Comté", 25, 40),

        };
        Magasin app = new Magasin(items);

        for (int i = 0; i < 20; i++) {
            app.updateQuality();
        }
        assertEquals(-15, app.items[0].sellIn);
        assertEquals(45, app.items[0].quality);
        assertEquals(5, app.items[1].sellIn);
        assertEquals(50, app.items[1].quality);
    }
}
