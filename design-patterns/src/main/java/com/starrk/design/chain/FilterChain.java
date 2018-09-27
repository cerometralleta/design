package com.starrk.design.chain;

public abstract class FilterChain {
    private FilterChain chain;

    final void process() {
        this.filter();
        if (null != getChain()) {
            this.getChain().process();
        }
    }

    public FilterChain getChain() {
        return chain;
    }

    public FilterChain setChain(FilterChain chain) {
        this.chain = chain;
        return chain;
    }

    abstract void filter();

    public static class Decode extends FilterChain {

        @Override
        void filter() {
            System.out.println("加解密");
        }
    }

    public static class Check extends FilterChain {

        @Override
        void filter() {
            System.out.println("数据验证");
        }
    }

    public static class Duplicate extends FilterChain {

        @Override
        void filter() {
            System.out.println("数据去重");
        }
    }


    public static void main(String[] args) {
        FilterChain decode = new Decode();
        FilterChain check = new Check();
        FilterChain duplicate = new Duplicate();
        decode.setChain(check).setChain(duplicate);
        decode.process();
    }
}
