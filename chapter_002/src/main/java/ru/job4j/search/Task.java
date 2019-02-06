package ru.job4j.search;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Task {
        private String desc;
        private int priority;

        public Task(String desc, int priority) {
            this.desc = desc;
            this.priority = priority;
        }

        public String getDesc() {
            return desc;
        }

        public boolean getPriority() {
            return priority;
        }
}

