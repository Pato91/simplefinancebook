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
public class PatientSummaryData {
    PatientSummaryData(String monthx, String patient_nox, String patient_no_diffx, String avg_pat_payx, String avg_pat_pay_per_revx) {

            month = new SimpleStringProperty(monthx);
            patient_no = new SimpleStringProperty(patient_nox);
            patient_no_diff = new SimpleStringProperty(patient_no_diffx);
            avg_pat_pay = new SimpleStringProperty(avg_pat_payx);
            avg_pat_pay_per_rev = new SimpleStringProperty(avg_pat_pay_per_revx);
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
        
    
        public StringProperty patient_no;

        public void setpatient_no(String value) {
            patient_noProperty().set(value);
        }

        public String getpatient_no() {
            return patient_noProperty().get();
        }

        public StringProperty patient_noProperty() {
            if (patient_no == null) {
                patient_no = new SimpleStringProperty(this, "patient_no");
            }
            return patient_no;
        }
        
        

        public StringProperty patient_no_diff;

        public void setpatient_no_diff(String value) {
            patient_no_diffProperty().set(value);
        }

        public String getpatient_no_diff() {
            return patient_no_diffProperty().get();
        }

        public StringProperty patient_no_diffProperty() {
            if (patient_no_diff == null) {
                patient_no_diff = new SimpleStringProperty(this, "expenses");
            }
            return patient_no_diff;
        }
       
        public StringProperty avg_pat_pay;

        public void setavg_pat_pay(String value) {
            avg_pat_payProperty().set(value);
        }

        public String getavg_pat_pay() {
            return avg_pat_payProperty().get();
        }

        public StringProperty avg_pat_payProperty() {
            if (avg_pat_pay == null) {
                avg_pat_pay = new SimpleStringProperty(this, "avg_pat_pay");
            }
            return avg_pat_pay;
        }

        public StringProperty avg_pat_pay_per_rev;

        public void setavg_pat_pay_per_rev(String value) {
            avg_pat_pay_per_revProperty().set(value);
        }

        public String getavg_pat_pay_per_rev() {
            return avg_pat_pay_per_revProperty().get();
        }

        public StringProperty avg_pat_pay_per_revProperty() {
            if (avg_pat_pay_per_rev == null) {
                avg_pat_pay_per_rev = new SimpleStringProperty(this, "avg_pat_pay_per_rev");
            }
            return avg_pat_pay_per_rev;
        }
}
