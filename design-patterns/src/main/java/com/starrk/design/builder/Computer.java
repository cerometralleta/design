package com.starrk.design.builder;

import lombok.Data;


/**
 * 电脑实体
 */
@Data
public class Computer {

    private String displayer;
    private String keyboard;
    private String mainframe;

    /**
     * 组装电脑标准接口
     */
    public static interface IBuilder {

        void installDisplayer();

        void installKeyboard();

        void installMainframe();

        Computer buildComputer();
    }

    public static class IBMBuilder implements IBuilder {
        Computer ibam;

        public IBMBuilder() {
            this.ibam = new Computer();
        }

        public void installDisplayer() {
            System.out.println("安装显示器");
            this.ibam.setDisplayer("ibm显示器");
        }

        public void installKeyboard() {
            System.out.println("安装键盘");
            this.ibam.setKeyboard("ibm键盘");
        }

        public void installMainframe() {
            System.out.println("安装主机");
            this.ibam.setMainframe("ibm主键");
        }

        public Computer buildComputer() {

            return this.ibam;
        }
    }

    /**
     * 组装电脑，最终返回电脑实体（电脑组装过程）
     */
    public static class ComputerDirector {

        public Computer createDirector(IBuilder iBuilder) {
            System.out.println("开始电脑组装");
            iBuilder.installDisplayer();
            iBuilder.installKeyboard();
            iBuilder.installMainframe();
            Computer computer = iBuilder.buildComputer();
            System.out.println("完成电脑组装");
            return computer;

        }
    }

    public static void main(String[] args) {
        ComputerDirector computerDirector = new ComputerDirector();
        Computer computer = computerDirector.createDirector(new IBMBuilder());
        System.out.println(computer.getDisplayer());
        System.out.println(computer.getKeyboard());
        System.out.println(computer.getMainframe());
    }

}
