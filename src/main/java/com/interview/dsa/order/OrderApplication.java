package com.interview.dsa.order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// food ordering
// Bruger
/*

Item
    price
    packing
    name

  ------

  ploy
1)  Burger
    price = 50
    packing = wrap
2)  noodles
    price = 70
    packing = plastic bag

 */
interface Packing {
    String packName();
}

interface Item {
    String name();
    Packing packing();
    int price();
}

class VegWrapper implements Packing {

    @Override
    public String packName() {
        return "GreenWrappper";
    }
}

class NonVegWrapper implements Packing {

    @Override
    public String packName() {
        return "RedWrappper";
    }
}

class Bottle implements Packing {

    @Override
    public String packName() {
        return "Bootle";
    }
}


abstract class Burger implements Item {

}

abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }
}

class VegBurger extends Burger {

    private Packing packing;

    public VegBurger(Packing packing) {
       this.packing = packing;
    }

    @Override
    public String name() {
        return "VegBurger";
    }

    @Override
    public Packing packing() {
        return packing;
    }

    @Override
    public int price() {
        return 50;
    }
}
class NonVegBurger extends Burger {

    private Packing packing;

    public NonVegBurger(Packing packing) {
        this.packing = packing;
    }

    @Override
    public String name() {
        return "NonVegBurger";
    }

    @Override
    public Packing packing() {
        return packing;
    }

    @Override
    public int price() {
        return 80;
    }
}


class Pepsi extends ColdDrink {

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public int price() {
        return 20;
    }
}

/*
                 Item

Burger          ColdDrink    Noodles
VegBurger       Pepsi        VegNoodles

 */


public class OrderApplication {
    public static void main(String[] args) {
        List<Item> orderList = new ArrayList<>();
       // Item item = new Pepsi();

        orderList.add(new VegBurger(new VegWrapper()));
        orderList.add(new NonVegBurger(new NonVegWrapper()));
        orderList.add(new Pepsi());

        Iterator<Item> iterator = orderList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().name());
        }

        int totalPrice = 0;
        for (Item item: orderList) {
            System.out.printf("Name: %s, Price: %d, Packing: %s\n", item.name(), item.price(), item.packing().packName());
            totalPrice += item.price();
        }

        System.out.println(totalPrice);
    }
}










