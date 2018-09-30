package com.starrk.design.observerable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Observerable {

    public static class Subject {
        private String msg;

        public void getMsg() {
            System.out.println(this.msg);
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }


    public static interface IObserverable {
        void register(Subject subject);

        void remove(Subject subject);

        void notifySubject();
    }

    public static class MessageObserverable implements IObserverable {
        private String msg;
        List<Subject> subjects = new ArrayList<Subject>();

        public void register(Subject subject) {
            subjects.add(subject);
        }

        public void remove(Subject subject) {
            subjects.remove(subject);
        }

        public void notifySubject() {
            for (Subject subject : subjects) {
                subject.setMsg(this.msg);
                subject.getMsg();
            }
        }

        public void setMsg(String msg) {
            this.msg = msg;
            this.notifySubject();
        }
    }
    public static class asObservable extends Observable{
        @Override
        protected synchronized void setChanged() {
            super.setChanged();
        }
    }

    public static void main(String[] args) {
        MessageObserverable messageObserverable = new MessageObserverable();
        messageObserverable.register(new Subject());
        messageObserverable.register(new Subject());
        messageObserverable.register(new Subject());
        messageObserverable.setMsg("服务端发送消息了...");


        // jdk实现
        asObservable jdk = new asObservable();
        jdk.addObserver(new Observer() {
            public void update(Observable o, Object arg) {
                System.out.println("角色1被更新.."+ arg);
            }
        });
        jdk.addObserver(new Observer() {
            public void update(Observable o, Object arg) {
                System.out.println("角色2被更新.."+ arg);
            }
        });
        jdk.addObserver(new Observer() {
            public void update(Observable o, Object arg) {
                System.out.println("角色3被更新.." + arg);
            }
        });

        jdk.setChanged();
        jdk.notifyObservers("1111111111");
    }
}
