package com.example.model;

import java.util.Objects;

public class BookCopy {
    private Long ID;
    private Long cost;
    private PhysicalCondition physicalCondition;
    private String branch;

    public BookCopy(Long ID){this.ID = ID;}

    public Long getID() {
        return ID;
    }
    public Long getCost() {
        return cost;
    }
    public PhysicalCondition getPhysicalCondition() {
        return physicalCondition;
    }
    public String getBranch() {
        return branch;
    }


    public static enum PhysicalCondition {
        EXCELLENT, VERYGOOD, GOOD, USABLE, NOTUSABLE
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        BookCopy that = (BookCopy) obj;

        if(this.ID != that.ID)
            return false;
        return true;
    }

    public static class Builder{

        private BookCopy copy;

        public Builder(Long ID){
            copy = new BookCopy(ID);
        }
        public Builder cost(Long cost){
            copy.cost = cost;
            return this;
        }
        public Builder branch(String branch){
            copy.branch = branch;
            return this;
        }
        public BookCopy build(){
            return copy;
        }
        public Builder physicalCondition(String physicalCondition){
            switch (physicalCondition) {
            case "excellent":
                copy.physicalCondition = PhysicalCondition.EXCELLENT;
                break;
            case "very-good":
                copy.physicalCondition = PhysicalCondition.VERYGOOD;
                break;
            case "good":
                copy.physicalCondition = PhysicalCondition.GOOD;
                break;
            case "usable":
                copy.physicalCondition = PhysicalCondition.USABLE;
                break;
            case "not-usable":
                copy.physicalCondition = PhysicalCondition.NOTUSABLE;
                break;
        }
            return this;
        }


    }

}
