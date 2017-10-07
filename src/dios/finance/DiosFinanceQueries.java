/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dios.finance;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.Date;
import javafx.scene.control.TextArea;

/**
 *
 * @author meraki
 */
public class DiosFinanceQueries {

    merakiBusinessDBClass merakiBusinessDBClass = new merakiBusinessDBClass();

    public String selectRevenue() {
        return "SELECT revenue_id, patient_name, phone_number, address, medical_condition, charge, date_of_visit FROM revenue";
    }

    public String insertRevenue(String patient_name, String phone_number,
            String address, String condition, String charge,
            String date_of_visit) {
        TextArea query = new TextArea();
        
        query.appendText("INSERT INTO revenue (patient_name, phone_number, address, medical_condition,"
                + " charge, date_of_visit, users_userid) VALUES (a");
        
        if(patient_name != null && !patient_name.isEmpty()){
            if(query.getText().contains("a,")){
                query.setText(query.getText().replaceAll("a,", ""));
            }
            query.appendText(",'"+patient_name+"' ");
        }
        
        if(phone_number != null && !phone_number.isEmpty()){
            if(query.getText().contains("a,")){
                query.setText(query.getText().replaceAll("a,", ""));
            }
            query.appendText(",'"+phone_number+"' ");
        } else if(phone_number == null || phone_number.isEmpty()){
            if(query.getText().contains("a,")){
                query.setText(query.getText().replaceAll("a,", ""));
            }
            query.appendText(",' ' ");
        }
        
        if(address != null && !address.isEmpty()){
            if(query.getText().contains("a,")){
                query.setText(query.getText().replaceAll("a,", ""));
            }
            query.appendText(",'"+address+"' ");
        } else if(address == null || address.isEmpty()){
            if(query.getText().contains("a,")){
                query.setText(query.getText().replaceAll("a,", ""));
            }
            query.appendText(",' ' ");
        }
        
        if(condition != null && !condition.isEmpty()){
            if(query.getText().contains("a,")){
                query.setText(query.getText().replaceAll("a,", ""));
            }
            query.appendText(",'"+condition+"' ");
        } else if(condition == null || condition.isEmpty()){
            if(query.getText().contains("a,")){
                query.setText(query.getText().replaceAll("a,", ""));
            }
            query.appendText(",' ' ");
        }        
        if(charge != null && !charge.isEmpty()){
            if(query.getText().contains("a,")){
                query.setText(query.getText().replaceAll("a,", ""));
            }
            query.appendText(","+parseDouble(charge)+" ");
        }
        
        if(date_of_visit != null && !date_of_visit.isEmpty()){
            if(query.getText().contains("a,")){
                query.setText(query.getText().replaceAll("a,", ""));
            }
            query.appendText(",'"+Date.valueOf(date_of_visit)+"' ");
        }
        
        query.appendText(", 1);");
        
        return query.getText();
    }
    
    public String updateRevenue(String revenue_id, String patient_name, String phone_number,
            String address, String condition, String charge,
            String date_of_visit) {
        TextArea query = new TextArea();
        
        query.appendText("UPDATE revenue SET ");
        
        if(patient_name != null && !patient_name.isEmpty()){
            query.appendText("patient_name = '"+patient_name+"', ");
        }
        
        if(phone_number != null && !phone_number.isEmpty()){
            
            query.appendText("phone_number = '"+phone_number+"', ");
        } 
        
        if(address != null && !address.isEmpty()){
            
            query.appendText("address = '"+address+"', ");
        } 
        if(condition != null && !condition.isEmpty()){
            
            query.appendText("medical_condition = '"+condition+"', ");
        }
        
        if(charge != null && !charge.isEmpty()){
            
            query.appendText("charge = "+parseDouble(charge)+", ");
        }
        
        if(date_of_visit != null && !date_of_visit.isEmpty()){
           
            query.appendText("date_of_visit = '"+Date.valueOf(date_of_visit)+"', ");
        }
        
        query.appendText("WHERE revenue_id = "+parseInt(revenue_id)+";");
        
        if(query.getText().contains(", WHERE")){
            query.setText(query.getText().replaceAll(", WHERE", " WHERE"));
        }
        
        return query.getText();
    }
    
    public String getTotalRevenue(){
        return "SELECT ROUND(SUM(charge), 2) AS total FROM revenue;";
    }
    
    public String selectExpenses() {
        return "SELECT expense_id, item, category, quantity, rate, paid_to, paid_on FROM expenses";
    }
    
    public String insertExpense(String item, String category,
            String quantity, String rate, String paid_to,
            String paid_on) {
        TextArea query = new TextArea();
        
        query.appendText("INSERT INTO expenses (item, category, quantity, rate,"
                + " paid_to, paid_on, users_userid) VALUES (a");
        
        if(item != null && !item.isEmpty()){
            if(query.getText().contains("a,")){
                query.setText(query.getText().replaceAll("a,", ""));
            }
            query.appendText(",'"+item+"' ");
        }
        
        if(category != null && !category.isEmpty()){
            if(query.getText().contains("a,")){
                query.setText(query.getText().replaceAll("a,", ""));
            }
            query.appendText(",'"+category+"' ");
        } else if(category == null || category.isEmpty()){
            if(query.getText().contains("a,")){
                query.setText(query.getText().replaceAll("a,", ""));
            }
            query.appendText(",' ' ");
        }
        
        if(quantity != null && !quantity.isEmpty()){
            if(query.getText().contains("a,")){
                query.setText(query.getText().replaceAll("a,", ""));
            }
            query.appendText(","+parseInt(quantity)+" ");
        }
        
        if(rate != null && !rate.isEmpty()){
            if(query.getText().contains("a,")){
                query.setText(query.getText().replaceAll("a,", ""));
            }
            query.appendText(","+parseDouble(rate)+" ");
        } else if(rate == null || rate.isEmpty()){
            if(query.getText().contains("a,")){
                query.setText(query.getText().replaceAll("a,", ""));
            }
            query.appendText(",' ' ");
        }
        
        if(paid_to != null && !paid_to.isEmpty()){
            if(query.getText().contains("a,")){
                query.setText(query.getText().replaceAll("a,", ""));
            }
            query.appendText(",'"+paid_to+"' ");
        }
        
        if(paid_on != null && !paid_on.isEmpty()){
            if(query.getText().contains("a,")){
                query.setText(query.getText().replaceAll("a,", ""));
            }
            query.appendText(",'"+Date.valueOf(paid_on)+"' ");
        }
        
        query.appendText(", 1);");
        
        return query.getText();
    }
    
    public String updateExpense(String expense_id, String item, String category,
            String quantity, String rate, String paid_to,
            String paid_on) {
        TextArea query = new TextArea();
        
        query.appendText("UPDATE expenses SET ");
        
        if(item != null && !item.isEmpty()){
            query.appendText("item = '"+item+"', ");
        }
        
        if(category != null && !category.isEmpty()){
            
            query.appendText("category = '"+category+"', ");
        } 
        
        if(quantity != null && !quantity.isEmpty()){
            
            query.appendText("quantity = "+parseInt(quantity)+", ");
        } 
        if(rate != null && !rate.isEmpty()){
            
            query.appendText("rate = "+parseDouble(rate)+", ");
        }
        
        if(paid_to != null && !paid_to.isEmpty()){
            
            query.appendText("paid_to = '"+paid_to+"', ");
        }
        
        if(paid_on != null && !paid_on.isEmpty()){
           
            query.appendText("paid_on = '"+Date.valueOf(paid_on)+"', ");
        }
        
        query.appendText("WHERE expense_id = "+parseInt(expense_id)+";");
        
        if(query.getText().contains(", WHERE")){
            query.setText(query.getText().replaceAll(", WHERE", " WHERE"));
        }
        
        return query.getText();
    }
    
    public String getTotalExpenses(){
        return "SELECT ROUND(SUM(rate * quantity), 2) AS total FROM expenses;";
    }
    
    public String getSets(){
    return "SET @a := 0;SET @b := 1;";
    }
    public String getSummary(){
        TextArea query = new TextArea();
        
        query.appendText("SELECT d.date as fin_date, d.total AS totalRev, "
                + "COALESCE(ROUND(SUM(rate * quantity), 2), 0.00) AS totalExp, "
                + "COALESCE(ROUND((d.total - ROUND(SUM(rate * quantity), 2)), 2),d.total) AS totalProf, "
                + "COALESCE(d.percent_lag, 0.00) AS percent_lag, d.no_patients AS p_no, "
                + "COALESCE(d.pat_percent_lag, 0.00) AS p_p_no_lag, "
                + "COALESCE(ROUND((d.d.total/d.no_patients) ,2), 0.00) AS avg_pat_pay, "
                + "COALESCE(ROUND((COALESCE(ROUND((d.d.total/d.no_patients) ,2), 0.00)*100/d.total), 2), 0.00) "
                + "AS avg_pay_percent_rev FROM "
                + "(SELECT r.dateVal AS date, r.totalRev AS total, "
                + "ROUND(((r.totalRev-r2.totalRev)*100/r2.totalRev),2) AS percent_lag, "
                + "r.patient_no AS no_patients, "
                + "ROUND(((r.patient_no - r2.patient_no)*100/r2.patient_no), 2) AS pat_percent_lag FROM "
                + "(SELECT if(@a, @a := @a + 1, @a := 1) AS rownum, EXTRACT(YEAR_MONTH FROM date_of_visit) AS dateVal, "
                + "ROUND(SUM(charge), 2) AS totalRev, COUNT(*) AS patient_no FROM revenue "
                + "GROUP BY dateVal) AS r LEFT JOIN (SELECT if(@b, @b := @b + 1, @b := 1) AS rownum, "
                + "EXTRACT(YEAR_MONTH FROM date_of_visit) AS dateVal, ROUND(SUM(charge), 2) AS totalRev, "
                + "COUNT(*) AS patient_no FROM revenue GROUP BY dateVal) AS r2 ON r.rownum = r2.rownum "
                + "ORDER by date ASC) AS d LEFT JOIN expenses AS e ON d.date = EXTRACT(YEAR_MONTH FROM paid_on) "
                + "GROUP BY fin_date, d.percent_lag, d.pat_percent_lag;");
        
        return query.getText();
    }
}
