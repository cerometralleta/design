package com.starrk.design.adapted;

public class Adapted {

    /**
     * mubiao目标接口
     */
    public static interface Target {
        void method();

        void method2();
    }

    public static class Orgin {
        void method() {
            System.out.println("原始方法");
        }
    }

    /**
     * Adapter与BeAdapted是继承关系，即为类适配器模式。
     */
    public static class TargetAdapted extends Orgin implements Target {

        @Override
        public void method() {
            super.method();
        }

        public void method2() {
            System.out.println("适配器做的实现");
        }
    }

    /**
     * Adapter与BeAdapted是委托关系，即为对象适配器模式。
     */
    public static class Target2Adapted implements Target{

        private Orgin orgin;
        public Target2Adapted(Orgin orgin){
            this.orgin = orgin;
        }

        public void method() {
            this.orgin.method();
        }

        public void method2() {
            System.out.println("适配新方法");
        }
    }

    public static void main(String[] args) {
        Target target = new TargetAdapted();
        target.method();
        target.method2();

        target = new Target2Adapted(new Orgin());
        target.method();
        target.method2();
    }
}
