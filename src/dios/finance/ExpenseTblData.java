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
public class ExpenseTblData {
    ExpenseTblData(String numberx, String expense_idx, String itemx, String categoryx , String quantityx, String ratex, String paid_tox, String paid_onx) {

            number = new SimpleStringProperty(numberx);
            expense_id = new SimpleStringProperty(expense_idx);
            item = new SimpleStringProperty(itemx);
            category = new SimpleStringProperty(categoryx);
            quantity = new SimpleStringProperty(quantityx);
            rate = new SimpleStringProperty(ratex);
            paid_to = new SimpleStringProperty(paid_tox);
            paid_on = new SimpleStringProperty(paid_onx);
        }

        public StringProperty number;

        public void setnumber(String value) {
            numberProperty().set(value);
        }

        public String getnumber() {
            return numberProperty().get();
        }

        public StringProperty numberProperty() {
            if (number == null) {
                number = new SimpleStringProperty(this, "number");
            }
            return number;
        }
    
        public StringProperty expense_id;

        public void setexpense_id(String value) {
            expense_idProperty().set(value);
        }

        public String getexpense_id() {
            return expense_idProperty().get();
        }

        public StringProperty expense_idProperty() {
            if (expense_id == null) {
                expense_id = new SimpleStringProperty(this, "expense_id");
            }
            return expense_id;
        }
    
        public StringProperty item;

        public void setitem(String value) {
            itemProperty().set(value);
        }

        public String getitem() {
            return itemProperty().get();
        }

        public StringProperty itemProperty() {
            if (item == null) {
                item = new SimpleStringProperty(this, "item");
            }
            return item;
        }

        public StringProperty category;

        public void setcategory(String value) {
            categoryProperty().set(value);
        }

        public String getcategory() {
            return categoryProperty().get();
        }

        public StringProperty categoryProperty() {
            if (category == null) {
                category = new SimpleStringProperty(this, "category");
            }
            return category;
        }

        public StringProperty quantity;

        public void setquantity(String value) {
            quantityProperty().set(value);
        }

        public String getquantity() {
            return quantityProperty().get();
        }

        public StringProperty quantityProperty() {
            if (quantity == null) {
                quantity = new SimpleStringProperty(this, "quantity");
            }
            return quantity;
        }

        public StringProperty rate;
        public void setrate(String value) {
            rateProperty().set(value);
        }

        public String getrate() {
            return rateProperty().get();
        }

        public StringProperty rateProperty() {
            if (rate == null) {
                rate = new SimpleStringProperty(this, "rate");
            }
            return rate;
        }

        public StringProperty paid_to;

        public void setpaid_to(String value) {
            paid_toProperty().set(value);
        }

        public String getpaid_to() {
            return paid_toProperty().get();
        }

        public StringProperty paid_toProperty() {
            if (paid_to == null) {
                paid_to = new SimpleStringProperty(this, "paid_to");
            }
            return paid_to;
        }

        public StringProperty paid_on;

        public void setpaid_on(String value) {
            paid_onProperty().set(value);
        }

        public String getpaid_on() {
            return paid_onProperty().get();
        }

        public StringProperty paid_onProperty() {
            if (paid_on == null) {
                paid_on = new SimpleStringProperty(this, "paid_on");
            }
            return paid_on;
        }
} 
