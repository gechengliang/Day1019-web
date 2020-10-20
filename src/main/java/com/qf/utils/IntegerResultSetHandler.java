package com.qf.utils;

import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IntegerResultSetHandler implements ResultSetHandler<Integer> {
    @Override
    public Integer handle(ResultSet rs) throws SQLException {

        int count = 0;
        if (rs.next()) {
            count = rs.getInt(1);
        }
        return count;

    }
}
