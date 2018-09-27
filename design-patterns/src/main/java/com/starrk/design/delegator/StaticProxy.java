package com.starrk.design.delegator;

public class StaticProxy {

    /**
     * 代理对象抽象
     */
    public static interface Shopping {
        void goShopping();
    }


    public static class ShoppingProxy implements Shopping {
        private Shopping shopping;

        public ShoppingProxy(Shopping shopping) {
            this.shopping = shopping;
        }

        public void goShopping() {
            System.out.println("代理购物记录账单");
            this.shopping.goShopping();
            System.out.println("代理购物结束");
        }
    }

    public static void main(String[] args) {
        Shopping meShopping = new Shopping() {
            public void goShopping() {
                System.out.println("购物付款");
            }
        };
        Shopping shopping = new ShoppingProxy(meShopping);
        shopping.goShopping();
    }
}
