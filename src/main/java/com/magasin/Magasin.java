package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    String ears = "(\\ /)";
    String face = "( . .)♥";
    String paw =  "c(\")(\")";

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if (!items[i].name.equals("Kryptonite")) {

                if (items[i].quality < 50) {

                    if (items[i].name.equals("Comté")) {
                        items[i].quality ++;
                        if (items[i].sellIn < 1) {
                            items[i].quality ++;
                        }
                    }

                    else if (items[i].name.equals("Pass VIP Concert")) {
                        if (items[i].sellIn < 6) {
                            items[i].quality = items[i].quality + 3;
                        } else if (items[i].sellIn < 11) {
                            items[i].quality = items[i].quality + 2;
                        } else {
                            items[i].quality = items[i].quality ++;
                        }
                        if (items[i].quality > 50) {
                            items[i].quality = 50;
                        }
                        if (items[i].sellIn < 1) {
                            items[i].quality = 0;
                        }
                    }

                    else {
                        if (items[i].quality > 0) {
                            items[i].quality --;
                        }
                    }
                }

                items[i].sellIn = items[i].sellIn - 1;
                if (items[i].sellIn < 0 && items[i].quality > 0 && !items[i].name.equals("Comté") ) {
                    items[i].quality --;
                }
            }

        }

        /*for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Comté")
                    && !items[i].name.equals("Pass VIP Concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Kryptonite")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Pass VIP Concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                        // if (items[i].quality < 50) {
                        //     if (items[i].sellIn < 6) {
                        //         items[i].quality = items[i].quality + 2;
                        //     } else if (items[i].sellIn < 11) {
                        //         items[i].quality = items[i].quality + 1;
                        //     }
                        // }
                    }
                }
            }

            if (!items[i].name.equals("Kryptonite")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Comté")) {
                    if (!items[i].name.equals("Pass VIP Concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Kryptonite")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }*/
    }
}
