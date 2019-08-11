package com.lxgzhw;

public class HomeWork01 {
    public static void main(String[] args) {
        //个人所得税
        double salary = 10000.0;//工资
        double taxSalary = salary - 3500;//记税工资
        double tax = 0.0;//税

        /*
         * 已知税率:
         * 1500 3
         * 4500 10
         * 9000 20
         * 35000 25
         * 55000 30
         * 80000 35
         * 80000+ 45
         */
        if (taxSalary <= 0) {
            //不纳税
            tax = 0.0;
        } else if (taxSalary <= 1500) {
            tax = taxSalary * 0.03;
        } else if (taxSalary <= 4500) {
            tax = taxSalary * 0.1;
        } else if (taxSalary <= 9000) {
            tax = taxSalary * 0.2;
        } else if (taxSalary <= 35000) {
            tax = taxSalary * 0.25;
        } else if (taxSalary <= 55000) {
            tax = taxSalary * 0.3;
        } else if (taxSalary <= 80000) {
            tax = taxSalary * 0.35;
        } else if (taxSalary > 80000) {
            tax = taxSalary * 0.45;
        } else {
            tax = 0;
        }

        //扣税后工资
        double finalSalary = taxSalary - tax;
        System.out.println("税后工资为:" + finalSalary);
    }
}
