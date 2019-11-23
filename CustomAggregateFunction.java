package org.h2.api;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomAggregateFunction implements org.h2.api.AggregateFunction {
    float max=0;
    float min=0;
    int count=0;

    public CustomAggregateFunction(){
        System.out.println("non arguement constructor");
    }

    @Override
    public void init(Connection conn) throws SQLException {
        System.out.println("A method to calculate difference between the max " +
                "and min element in a column.");

    }

    @Override
    public int getType(int[] inputTypes) throws SQLException {
        if (inputTypes.length !=1){
            throw new java.sql.SQLException("The user must provide 1 " +
                    "arguement");
        }
        return inputTypes[0];
    }

    @Override
    public void add(Object value) throws SQLException {
        count=count+1;
        if (count==1){
            max=(float)value;
            min=(float)value;
        }
        else {
            if ((float)value < min){
                min=(float)value;
            }
            if ((float)value>max){
                max=(float)value;
            }
        }
        System.out.println(value.toString());

    }

    @Override
    public Object getResult() throws SQLException {
        System.out.println(count);
        System.out.println(max);
        System.out.println(min);
        return (max-min);
    }
}
