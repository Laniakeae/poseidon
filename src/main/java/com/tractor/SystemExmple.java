package com.tractor;

import java.math.BigDecimal;

/**
 * @author 404NotFoundx
 * @version 1.0.0
 * @date 2019/11/21 19:36
 * @since 1.8
 */
public class SystemExmple {

    public static void main(String[] args) {
        // System.setProperty("jdbc.drivers","com.mysql.cj.jdbc.Driver");
        // Enumeration<Driver> drivers = DriverManager.getDrivers();

        BigDecimal count = new BigDecimal("16");
        BigDecimal percent = new BigDecimal("20").divide(new BigDecimal("100"));

        percent = percent.multiply(count);

        System.out.println(percent);

    }

}