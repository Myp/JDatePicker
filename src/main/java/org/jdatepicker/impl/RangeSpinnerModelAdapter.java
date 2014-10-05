package org.jdatepicker.impl;

import javax.swing.AbstractSpinnerModel;

public abstract class RangeSpinnerModelAdapter extends AbstractSpinnerModel {

    private int max;
    private int min;

    public RangeSpinnerModelAdapter(int min, int max) {
        this.min = min;
        this.max = max;
    }

    protected String format(Integer hour) {
        return String.format("%02d", hour);
    }

    public void setValue(Object value) {
        setModelValue(Integer.valueOf((String) value) % max);
    }

    public abstract void setModelValue(Integer value);

    public abstract Integer getModelValue();

    public Object getValue() {
        return format(getModelValue());
    }

    public Object getNextValue() {
        return format(getModelValue() + 1);
    }

    public Object getPreviousValue() {
        Integer prevValue = getModelValue() - 1;
        return format(prevValue >=min ? prevValue : max - 1);
    }

    @Override
    protected void fireStateChanged() {
        super.fireStateChanged();
    }
}
