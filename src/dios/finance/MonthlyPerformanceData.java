/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dios.finance;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author meraki
 */
public class MonthlyPerformanceData {
    MonthlyPerformanceData(String monthx, String cash_revenuex, String expensesx, String profitx, String statusx) {

            month = new SimpleStringProperty(monthx);
            cash_revenue = new SimpleStringProperty(cash_revenuex);
            expenses = new SimpleStringProperty(expensesx);
            profit = new SimpleStringProperty(profitx);
            status = new SimpleStringProperty(statusx);
        }

    
        public StringProperty month;

        public void setmonth(String value) {
            monthProperty().set(value);
        }

        public String getmonth() {
            return monthProperty().get();
        }

        public StringProperty monthProperty() {
            if (month == null) {
                month = new SimpleStringProperty(this, "month");
            }
            return month;
        }
    
        public StringProperty cash_revenue;

        public void setcash_revenue(String value) {
            cash_revenueProperty().set(value);
        }

        public String getcash_revenue() {
            return cash_revenueProperty().get();
        }

        public StringProperty cash_revenueProperty() {
            if (cash_revenue == null) {
                cash_revenue = new SimpleStringProperty(this, "cash_revenue");
            }
            return cash_revenue;
        }

        public StringProperty expenses;

        public void setexpenses(String value) {
            expensesProperty().set(value);
        }

        public String getexpenses() {
            return expensesProperty().get();
        }

        public StringProperty expensesProperty() {
            if (expenses == null) {
                expenses = new SimpleStringProperty(this, "expenses");
            }
            return expenses;
        }

        public StringProperty profit;

        public void setprofit(String value) {
            profitProperty().set(value);
        }

        public String getprofit() {
            return profitProperty().get();
        }

        public StringProperty profitProperty() {
            if (profit == null) {
                profit = new SimpleStringProperty(this, "profit");
            }
            return profit;
        }

        public StringProperty status;

        public void setstatus(String value) {
            statusProperty().set(value);
        }

        public String getstatus() {
            return statusProperty().get();
        }

        public StringProperty statusProperty() {
            if (status == null) {
                status = new SimpleStringProperty(this, "status");
            }
            return status;
        }
}
