package com.algorithm.coursedesign.dynamic;

public class Work implements Comparable {
    private int start;
    private int end;
    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Work{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }

    Work(int start, int end) {
        this.start = start;
        this.end = end;
    }

    Work(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public int compareTo(Object o) {
        Work work = (Work) o;
        if (this.end > work.getEnd())
            return 1;
        else if (this.end == work.getEnd())
            return 0;
        else
            return -1;
    }
}
