package com.starrk.design.state;


/**
 * state mode
 */
public class State {

    public static interface IState{

        void doAction(Context context);
    }

    /**
     * context 拥有具体状态引用
     */
    public static class Context{
        private IState iState;

        public void  setIstate(IState istate){
            this.iState = istate;
        }
    }

    public static void main(String[] args) {
        Context context = new Context();

        IState iState = new IState() {
            public void doAction(Context context) {
                System.out.println("1zhuangtai....");
                context.setIstate(this);
            }

            @Override
            public String toString() {
                return "111111111";
            }
        };
        iState.doAction(context);
        System.out.println(context.iState.toString());

        IState iState2 = new IState() {
            public void doAction(Context context) {
                System.out.println("2zhuangtai....");
                context.setIstate(this);
            }
            @Override
            public String toString() {
                return "222222222";
            }
        };
        iState2.doAction(context);
        System.out.println(context.iState.toString());

    }

}
