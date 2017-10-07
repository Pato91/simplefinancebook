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
public class RevenueTblData {
    RevenueTblData(String numberx, String revenue_idx, String patient_namex, String phone_numberx, String addressx, String conditionx, String chargex, String date_of_visitx) {
            
            number = new SimpleStringProperty(numberx);
            revenue_id = new SimpleStringProperty(revenue_idx);
            patient_name = new SimpleStringProperty(patient_namex);
            phone_number = new SimpleStringProperty(phone_numberx);
            address = new SimpleStringProperty(addressx);
            condition = new SimpleStringProperty(conditionx);
            charge = new SimpleStringProperty(chargex);
            date_of_visit = new SimpleStringProperty(date_of_visitx);
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
    
        public StringProperty revenue_id;

        public void setrevenue_id(String value) {
            revenue_idProperty().set(value);
        }

        public String getrevenue_id() {
            return revenue_idProperty().get();
        }

        public StringProperty revenue_idProperty() {
            if (revenue_id == null) {
                revenue_id = new SimpleStringProperty(this, "revenue_id");
            }
            return revenue_id;
        }
    
        public StringProperty patient_name;

        public void setpatient_name(String value) {
            patient_nameProperty().set(value);
        }

        public String getpatient_name() {
            return patient_nameProperty().get();
        }

        public StringProperty patient_nameProperty() {
            if (patient_name == null) {
                patient_name = new SimpleStringProperty(this, "patient_name");
            }
            return patient_name;
        }

        public StringProperty phone_number;

        public void setphone_number(String value) {
            phone_numberProperty().set(value);
        }

        public String getphone_number() {
            return phone_numberProperty().get();
        }

        public StringProperty phone_numberProperty() {
            if (phone_number == null) {
                phone_number = new SimpleStringProperty(this, "phone_number");
            }
            return phone_number;
        }

        public StringProperty address;

        public void setaddress(String value) {
            addressProperty().set(value);
        }

        public String getaddress() {
            return addressProperty().get();
        }

        public StringProperty addressProperty() {
            if (address == null) {
                address = new SimpleStringProperty(this, "address");
            }
            return address;
        }

        public StringProperty condition;

        public void setconditione(String value) {
            conditionProperty().set(value);
        }

        public String getcondition() {
            return conditionProperty().get();
        }

        public StringProperty conditionProperty() {
            if (condition == null) {
                condition = new SimpleStringProperty(this, "condition");
            }
            return condition;
        }

        public StringProperty charge;

        public void setcharge(String value) {
            chargeProperty().set(value);
        }

        public String getcharge() {
            return chargeProperty().get();
        }

        public StringProperty chargeProperty() {
            if (charge == null) {
                charge = new SimpleStringProperty(this, "charge");
            }
            return charge;
        }

        public StringProperty date_of_visit;

        public void setdate_of_visit(String value) {
            date_of_visitProperty().set(value);
        }

        public String getdate_of_visit() {
            return date_of_visitProperty().get();
        }

        public StringProperty date_of_visitProperty() {
            if (date_of_visit == null) {
                date_of_visit = new SimpleStringProperty(this, "date_of_visit");
            }
            return date_of_visit;
        }
}
