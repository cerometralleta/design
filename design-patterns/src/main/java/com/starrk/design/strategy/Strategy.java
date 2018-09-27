package com.starrk.design.strategy;


public class Strategy {

    public interface Travel{
        void travelType();
    }

    /**
     *  策略持有类，持有一个策略的引用不必实现策略接口，区别于代理模式（代理类必须实现被代理类接口）
    */
    public static class TravelContext{

        private Travel travel;

        public void setTravel(Travel travel) {
            this.travel = travel;
        }

        public void travel(){
            this.travel.travelType();
        };
    }

    public static void main(String[] args) {

        Travel hc = new Travel(){

            public void travelType() {
                System.out.println("乘坐火车旅游:100$");
            }
        };
        Travel fj = new Travel(){

            public void travelType() {
                System.out.println("乘坐飞机旅游:300$");
            }
        };

        Travel lc= new Travel(){

            public void travelType() {
                System.out.println("乘坐轮船旅游:700$");
            }
        };

        TravelContext travelContext = new TravelContext();
        travelContext.setTravel(hc);
        travelContext.travel();

        travelContext.setTravel(fj);
        travelContext.travel();

        travelContext.setTravel(lc);
        travelContext.travel();
    }
}
