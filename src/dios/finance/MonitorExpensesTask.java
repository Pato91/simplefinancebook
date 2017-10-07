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
public class MonitorExpensesTask extends Task<ArrayList<ArrayList<String>>> {

    merakiBusinessDBClass merakiBusinessDBClass = new merakiBusinessDBClass();
    DiosFinanceQueries DiosFinanceQueries = new DiosFinanceQueries();

    ArrayList<ArrayList<String>> results;

    protected ArrayList<ArrayList<String>> call() throws Exception {

        results = new ArrayList<>();
        
        JSONObject revenue = merakiBusinessDBClass.processSQLSelect(
                DiosFinanceQueries.selectExpenses(), null);
        
        Iterator<?> keys = revenue.keys();
        while (keys.hasNext()) {
            ArrayList<String> resultsTemp = new ArrayList<>();
            try {
                String key = (String) keys.next();
                JSONObject jsonObj1 = revenue.getJSONObject(
                        key);
                
                resultsTemp.add(jsonObj1.getString("expense_id"));
                resultsTemp.add(jsonObj1.getString("item"));
                resultsTemp.add(jsonObj1.getString("category"));
                resultsTemp.add(jsonObj1.getString("quantity"));
                resultsTemp.add(jsonObj1.getString("rate"));
                resultsTemp.add(jsonObj1.getString("paid_to"));
                resultsTemp.add(jsonObj1.getString("paid_on"));

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
