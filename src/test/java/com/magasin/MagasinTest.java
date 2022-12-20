package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {


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
