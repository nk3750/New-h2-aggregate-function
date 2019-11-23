package org.h2.api;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomAggregateFunction implements org.h2.api.AggregateFunction {

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
        System.out.println(inputTypes.toString());
        return inputTypes[0];
    }

    @Override
    public void add(Object value) throws SQLException {
        System.out.println("Inside Add");

    }

    @Override
    public Object getResult() throws SQLException {
        return 1;
    }
}
