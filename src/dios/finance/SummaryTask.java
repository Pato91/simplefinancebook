/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dios.finance;

import static java.lang.Integer.parseInt;
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
public class SummaryTask extends Task<ArrayList<ArrayList<String>>> {

    merakiBusinessDBClass merakiBusinessDBClass = new merakiBusinessDBClass();
    DiosFinanceQueries DiosFinanceQueries = new DiosFinanceQueries();

    ArrayList<ArrayList<String>> results;

    protected ArrayList<ArrayList<String>> call() throws Exception {

        results = new ArrayList<>();

        ArrayList<ArrayList<String>> summary = merakiBusinessDBClass.processSQLSelectOrdered(
                DiosFinanceQueries.getSummary(), DiosFinanceQueries.getSets());

        summary.forEach((summaryVal) -> {
            ArrayList<String> resultsTemp = new ArrayList<>();
            resultsTemp.add(summaryVal.get(0));
            resultsTemp.add(summaryVal.get(1));
            resultsTemp.add(summaryVal.get(2));
            if (summaryVal.get(3).equals("0.00")) {
                resultsTemp.add(summaryVal.get(1));
            } else {
                resultsTemp.add(summaryVal.get(3));
            }
            resultsTemp.add(summaryVal.get(4));
            resultsTemp.add(summaryVal.get(5));
            resultsTemp.add(summaryVal.get(6));
            resultsTemp.add(summaryVal.get(7));
            resultsTemp.add(summaryVal.get(8));

            results.add(resultsTemp);
        });

        return results;
    }
}
