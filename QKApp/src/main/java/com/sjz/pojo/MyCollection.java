package com.sjz.pojo;

public class MyCollection {
    private int id;
    private int compositionId;
    private int deleteFlag;

    private Composition composition;

    public MyCollection() {
    }

    public MyCollection(int id, int compositionId, int deleteFlag, Composition composition) {
        this.id = id;
        this.compositionId = compositionId;
        this.deleteFlag = deleteFlag;
        this.composition = composition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompositionId() {
        return compositionId;
    }

    public void setCompositionId(int compositionId) {
        this.compositionId = compositionId;
    }

    public int getDelete() {
        return deleteFlag;
    }

    public void setDelete(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Composition getComposition() {
        return composition;
    }

    public void setComposition(Composition composition) {
        this.composition = composition;
    }
}
