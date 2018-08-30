package com.csii.springbootmutiledatasource.dybamicDataSource;

import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;

import java.io.Serializable;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/29 - 0:12 -- 星期三
 */
public class MutablePropertyValues implements PropertyValues,Serializable {
    @Override
    public PropertyValue[] getPropertyValues() {
        return new PropertyValue[0];
    }

    @Override
    public PropertyValue getPropertyValue(String s) {
        return null;
    }

    @Override
    public PropertyValues changesSince(PropertyValues propertyValues) {
        return null;
    }

    @Override
    public boolean contains(String s) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
