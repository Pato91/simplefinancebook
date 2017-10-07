/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dios.finance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author meraki
 */
public class MonitorRevenueTask extends Task<ArrayList<ArrayList<String>>> {
    merakiBusinessDBClass merakiBusinessDBClass = new merakiBusinessDBClass();
    DiosFinanceQueries DiosFinanceQueries = new DiosFinanceQueries();
    
    ArrayList<ArrayList<String>> results;

        protected ArrayList<ArrayList<String>> call() throws Exception {
            
            results = new ArrayList<>();
            
            JSONObject revenue = merakiBusinessDBClass.processSQLSelect(DiosFinanceQueries.selectRevenue(), null);
            
            Iterator<?> keys = revenue.keys();
                    while (keys.hasNext()) {
                        ArrayList<String> resultsTemp = new ArrayList<>();
                        try {
                            String key = (String) keys.next();
                            JSONObject jsonObj1 = revenue.getJSONObject(
                                    key);
                            resultsTemp.add(jsonObj1.getString("revenue_id"));
                            resultsTemp.add(jsonObj1.getString("patient_name"));
                            resultsTemp.add(jsonObj1.getString("phone_number"));
                            resultsTemp.add(jsonObj1.getString("address"));
                            resultsTemp.add(jsonObj1.getString("medical_condition"));
                            resultsTemp.add(jsonObj1.getString("charge"));
                            resultsTemp.add(jsonObj1.getString("date_of_visit"));
                            
                        } catch (JSONException ex) {
                            Logger.getLogger(
                                    FXMLDocumentController.class.getName()).log(
                                    Level.SEVERE, null, ex);
                        }
                        
                        results.add(resultsTemp);
                        
                        
                    }
            return results;
        }
    
}
