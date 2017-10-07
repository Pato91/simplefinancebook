/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dios.finance;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXButton;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateTimeStringConverter;
import org.controlsfx.control.Notifications;
import org.json.JSONException;
import org.json.JSONObject;
import java.time.Month;
import javafx.event.EventHandler;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author meraki
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    public TableView<RevenueTblData> revenue_tbl;

    @FXML
    public TableView<ExpenseTblData> expenses_tbl;

    @FXML
    public TableColumn revenue_number_col;

    @FXML
    public TableColumn patient_nam_col;

    @FXML
    public TableColumn phone_no_col;

    @FXML
    public TableColumn address_col;

    @FXML
    public TableColumn condition_col;

    @FXML
    public TableColumn charge_col;

    @FXML
    public TableColumn date_of_visit_col;

    @FXML
    public JFXTextField patientname;

    @FXML
    public JFXTextField phonenumber;

    @FXML
    public JFXTextField address;

    @FXML
    public JFXTextField condition;

    @FXML
    public JFXTextField charge;

    @FXML
    public DatePicker date_of_visit;

    @FXML
    public JFXButton cancel_button;

    @FXML
    public Label revenue_title_lbl;

    @FXML
    public JFXButton submit_revenue_btn;

    @FXML
    public Label temp_revenue_id;

    @FXML
    public TableColumn expense_number_col;

    @FXML
    public TableColumn item_col;

    @FXML
    public TableColumn category_col;

    @FXML
    public TableColumn quantity_col;

    @FXML
    public TableColumn rate_col;

    @FXML
    public TableColumn paid_to_col;

    @FXML
    public TableColumn date_col;

    @FXML
    public JFXTextField item_txtFld;

    @FXML
    public JFXTextField category_TxtFld;

    @FXML
    public JFXTextField quantity_TxtFld;

    @FXML
    public JFXTextField rate_TxtFld;

    @FXML
    public JFXTextField paid_to_TxtFld;

    @FXML
    public DatePicker date_Picker;

    @FXML
    public Label expense_title_Lbl;

    @FXML
    public Label temp_expense_id;

    @FXML
    public JFXButton cancel_expense_button;

    @FXML
    public Label total_expenses_lbl;

    @FXML
    public Label total_revenue_lbl;

    ////SUMMARY PART
    @FXML
    public TableView<MonthlyPerformanceData> summary_tbl;

    @FXML
    public TableColumn month_col;

    @FXML
    public TableColumn cash_revenue_col;

    @FXML
    public TableColumn expenses_col;

    @FXML
    public TableColumn profit_col;

    @FXML
    public TableColumn status_col;

    @FXML
    public PieChart pie_chart;

    @FXML
    public Label caption;

    @FXML
    public LineChart<String, Number> line_graph;
    
    @FXML
    public TableView<PatientSummaryData> summary_patients_tbl;
    
    @FXML
    public TableColumn month_col1;
    
    @FXML
    public TableColumn Patients_no_col;
    
    @FXML
    public TableColumn patient_stats_col;
    
    @FXML
    public TableColumn avg_patient_pay;
    
    @FXML
    public TableColumn pat_avg_pay_per_rev_col;
    
    @FXML
    public LineChart<String, Number> line_chart;
    
    @FXML
    public PieChart pie_graph;
    
    
    
    

    merakiBusinessDBClass merakiBusinessDBClass = new merakiBusinessDBClass();
    DiosFinanceQueries DiosFinanceQueries = new DiosFinanceQueries();
    DecimalFormat df = new DecimalFormat("###,###,###.00");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    double total;

    @FXML
    private void submit_revenue_action(ActionEvent event) throws
            ClassNotFoundException {
        if (patientname.getText() != null && !patientname.getText().isEmpty() && charge.getText() != null && !charge.getText().isEmpty() && date_of_visit.getValue() != null) {
            if (revenue_title_lbl.getText().equals("NEW ENTRY")) {
                int status = merakiBusinessDBClass.processSQLInsert(
                        DiosFinanceQueries.insertRevenue(patientname.getText(),
                                phonenumber.getText(), address.getText(),
                                condition.getText(), charge.getText(),
                                date_of_visit.getValue().toString()));
                if (status == 1) {
                    Notifications.create()
                            .title("SUCCESS!")
                            .darkStyle()
                            .text("VISIT SUCCESSFULLY ADDED!")
                            .position(Pos.CENTER)
                            .showConfirm();
                    patientname.clear();
                    phonenumber.clear();
                    address.clear();
                    condition.clear();
                    charge.clear();
                    date_of_visit.setValue(null);
                }
            } else if (revenue_title_lbl.getText().equals("EDIT VISIT")) {
                if (!temp_revenue_id.getText().isEmpty() && temp_revenue_id.getText() != null) {
                    int status = merakiBusinessDBClass.processSQLUpdate(
                            DiosFinanceQueries.updateRevenue(
                                    temp_revenue_id.getText(),
                                    patientname.getText(),
                                    phonenumber.getText(), address.getText(),
                                    condition.getText(), charge.getText(),
                                    date_of_visit.getValue().toString()));
                    if (status == 1) {
                        Notifications.create()
                                .title("SUCCESS!")
                                .darkStyle()
                                .text("VIST " + temp_revenue_id.getText() + "WITH PATIENT " + patientname.getText() + " SUCCESSFULLY UPDATED!")
                                .position(Pos.CENTER)
                                .showConfirm();
                        temp_revenue_id.setText("");
                        patientname.clear();
                        phonenumber.clear();
                        address.clear();
                        condition.clear();
                        charge.clear();
                        date_of_visit.setValue(null);
                    }
                }
            }
        }
    }


    @FXML
    private void submit_expense_action(ActionEvent event) throws
            ClassNotFoundException {
        if (expense_title_Lbl.getText() != null && !expense_title_Lbl.getText().isEmpty()
                && quantity_TxtFld.getText() != null && !quantity_TxtFld.getText().isEmpty()
                && rate_TxtFld.getText() != null && !rate_TxtFld.getText().isEmpty()
                && paid_to_TxtFld.getText() != null && !paid_to_TxtFld.getText().isEmpty()) {
            if (expense_title_Lbl.getText().equals("NEW ENTRY")) {
                int status = merakiBusinessDBClass.processSQLInsert(
                        DiosFinanceQueries.insertExpense(item_txtFld.getText(),
                                category_TxtFld.getText(),
                                quantity_TxtFld.getText(),
                                rate_TxtFld.getText(), paid_to_TxtFld.getText(),
                                date_Picker.getValue().toString()));
                if (status == 1) {
                    Notifications.create()
                            .title("SUCCESS!")
                            .darkStyle()
                            .text("EXPENSE SUCCESSFULLY ADDED!")
                            .position(Pos.CENTER)
                            .showConfirm();
                    patientname.clear();
                    phonenumber.clear();
                    address.clear();
                    condition.clear();
                    charge.clear();
                    date_of_visit.setValue(null);
                }
            } else if (expense_title_Lbl.getText().equals("EDIT EXPENSE")) {
                if (!temp_expense_id.getText().isEmpty() && temp_expense_id.getText() != null) {
                    int status = merakiBusinessDBClass.processSQLUpdate(
                            DiosFinanceQueries.updateExpense(
                                    temp_expense_id.getText(),
                                    item_txtFld.getText(),
                                    category_TxtFld.getText(),
                                    quantity_TxtFld.getText(),
                                    rate_TxtFld.getText(),
                                    paid_to_TxtFld.getText(),
                                    date_Picker.getValue().toString()));
                    if (status == 1) {
                        Notifications.create()
                                .title("SUCCESS!")
                                .darkStyle()
                                .text("EXPENSE " + temp_revenue_id.getText() + "ITEM " + item_txtFld.getText() + " SUCCESSFULLY UPDATED!")
                                .position(Pos.CENTER)
                                .showConfirm();
                        temp_revenue_id.setText("");
                        patientname.clear();
                        phonenumber.clear();
                        address.clear();
                        condition.clear();
                        charge.clear();
                        date_of_visit.setValue(null);
                    }
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ScheduledService<ArrayList<ArrayList<String>>> svc = new ScheduledService<ArrayList<ArrayList<String>>>() {
            @Override
            protected Task<ArrayList<ArrayList<String>>> createTask() {
                return new MonitorRevenueTask();
            }
        };
        svc.setPeriod(Duration.seconds(2.5));

        ScheduledService<ArrayList<ArrayList<String>>> svc1 = new ScheduledService<ArrayList<ArrayList<String>>>() {
            @Override
            protected Task<ArrayList<ArrayList<String>>> createTask() {
                return new MonitorExpensesTask();
            }
        };
        svc1.setPeriod(Duration.seconds(2.5));

        ScheduledService<ArrayList<ArrayList<String>>> svc2 = new ScheduledService<ArrayList<ArrayList<String>>>() {
            @Override
            protected Task<ArrayList<ArrayList<String>>> createTask() {
                return new SummaryTask();
            }
        };
        svc2.setPeriod(Duration.seconds(2.5));

        date_of_visit.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(
                    "yyyy/MM/dd");

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateTimeFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateTimeFormatter);
                } else {
                    return null;
                }
            }
        });

        date_Picker.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(
                    "yyyy/MM/dd");

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateTimeFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateTimeFormatter);
                } else {
                    return null;
                }
            }
        });

        ObservableList<RevenueTblData> revenue_tbl_items = FXCollections.observableArrayList();
        revenue_tbl.setItems(revenue_tbl_items);
        revenue_number_col.setCellValueFactory(
                new PropertyValueFactory<RevenueTblData, String>(
                        "number"));
        patient_nam_col.setCellValueFactory(
                new PropertyValueFactory<RevenueTblData, String>(
                        "patient_name"));
        phone_no_col.setCellValueFactory(
                new PropertyValueFactory<RevenueTblData, String>(
                        "phone_number"));
        address_col.setCellValueFactory(
                new PropertyValueFactory<RevenueTblData, String>("address"));
        condition_col.setCellValueFactory(
                new PropertyValueFactory<RevenueTblData, String>("condition"));
        charge_col.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<RevenueTblData, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(
                    final TableColumn.CellDataFeatures<RevenueTblData, Boolean> p) {
                double money = Double.parseDouble(
                        p.getValue().charge.getValue());
                String finalMoney = df.format(money) + "/=";
                return new SimpleObjectProperty(finalMoney);
            }

        });
        date_of_visit_col.setCellValueFactory(
                new PropertyValueFactory<RevenueTblData, String>(
                        "date_of_visit"));
        svc.setOnSucceeded((WorkerStateEvent d) -> {
            if (!svc.getValue().equals(svc.getLastValue())) {
                try {
                    revenue_tbl_items.clear();
                    svc.getValue().forEach((value) -> {
                        revenue_tbl_items.add(new RevenueTblData(
                                (svc.getValue().indexOf(value) + 1) + "",
                                value.get(0),
                                value.get(1), value.get(2), value.get(3),
                                value.get(4), value.get(5), value.get(6)));
                    });
                    JSONObject totalRev = merakiBusinessDBClass.processSQLSelect(
                            DiosFinanceQueries.getTotalRevenue(), null);
                    Iterator<?> keyRev = totalRev.keys();
                    while (keyRev.hasNext()) {
                        String keyedItem1 = (String) keyRev.next();
                        JSONObject totalRevVal = totalRev.getJSONObject(
                                keyedItem1);
                        total_revenue_lbl.setText(df.format(parseDouble(
                                totalRevVal.getString("total"))) + "/=");
                    }
                } catch (ClassNotFoundException | JSONException |
                        SQLException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(
                            Level.SEVERE,
                            null, ex);
                }
            }

        });

        svc.start();
        svc.restart();
        svc.restart();
        svc.restart();
        svc.restart();
        svc.restart();
        svc.restart();
        svc.restart();
        svc.restart();

        ///item_col category_col quantity_col rate_col paid_to_col date_col
        ObservableList<ExpenseTblData> expense_tbl_items = FXCollections.observableArrayList();
        expenses_tbl.setItems(expense_tbl_items);
        expense_number_col.setCellValueFactory(
                new PropertyValueFactory<ExpenseTblData, String>(
                        "number"));
        item_col.setCellValueFactory(
                new PropertyValueFactory<ExpenseTblData, String>(
                        "item"));
        category_col.setCellValueFactory(
                new PropertyValueFactory<ExpenseTblData, String>(
                        "category"));
        quantity_col.setCellValueFactory(
                new PropertyValueFactory<ExpenseTblData, String>("quantity"));
        rate_col.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ExpenseTblData, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(
                    final TableColumn.CellDataFeatures<ExpenseTblData, Boolean> p) {
                double money = Double.parseDouble(
                        p.getValue().rate.getValue());
                String finalMoney = df.format(money) + "/=";
                return new SimpleObjectProperty(finalMoney);
            }

        });
        paid_to_col.setCellValueFactory(
                new PropertyValueFactory<ExpenseTblData, String>("paid_to"));
        date_col.setCellValueFactory(
                new PropertyValueFactory<ExpenseTblData, String>(
                        "paid_on"));

        svc1.setOnSucceeded((WorkerStateEvent d) -> {

            if (!svc1.getValue().equals(svc1.getLastValue())) {
                try {
                    expense_tbl_items.clear();
                    svc1.getValue().forEach((value) -> {
                        expense_tbl_items.add(new ExpenseTblData(
                                (svc1.getValue().indexOf(value) + 1) + "",
                                value.get(0),
                                value.get(1), value.get(2), value.get(3),
                                value.get(4), value.get(5), value.get(6)));
                    });

                    JSONObject totalExp = merakiBusinessDBClass.processSQLSelect(
                            DiosFinanceQueries.getTotalExpenses(), null);
                    Iterator<?> keyExp = totalExp.keys();
                    while (keyExp.hasNext()) {
                        String keyedItem = (String) keyExp.next();
                        JSONObject totalExpVal = totalExp.getJSONObject(
                                keyedItem);
                        if(!totalExpVal.getString("total").equals("")){
                            total_expenses_lbl.setText(df.format(parseDouble(
                                totalExpVal.getString("total"))) + "/=");
                        }
                        
                    }
                } catch (ClassNotFoundException | JSONException |
                        SQLException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(
                            Level.SEVERE,
                            null, ex);
                }
            }

        });

        svc1.start();
        svc1.restart();
        svc1.restart();
        svc1.restart();
        svc1.restart();
        svc1.restart();
        svc1.restart();
        svc1.restart();
        svc1.restart();

        ObservableList<MonthlyPerformanceData> monthly_performance_items = FXCollections.observableArrayList();
        summary_tbl.setItems(monthly_performance_items);
        month_col.setCellValueFactory(
                new PropertyValueFactory<MonthlyPerformanceData, String>(
                        "month"));
        cash_revenue_col.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<MonthlyPerformanceData, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(
                    final TableColumn.CellDataFeatures<MonthlyPerformanceData, Boolean> p) {
                double money = Double.parseDouble(
                        p.getValue().cash_revenue.getValue());
                String finalMoney = df.format(money) + "/=";
                return new SimpleObjectProperty(finalMoney);
            }

        });
        expenses_col.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<MonthlyPerformanceData, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(
                    final TableColumn.CellDataFeatures<MonthlyPerformanceData, Boolean> p) {
                if (!p.getValue().expenses.getValue().equals("") || !p.getValue().expenses.getValue().equals("0.00")) {
                    double money = Double.parseDouble(
                            p.getValue().expenses.getValue());
                    String finalMoney = df.format(money) + "/=";
                    return new SimpleObjectProperty(finalMoney);
                } else {
                    return new SimpleObjectProperty("0.00/=");
                }
            }

        });
        profit_col.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<MonthlyPerformanceData, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(
                    final TableColumn.CellDataFeatures<MonthlyPerformanceData, Boolean> p) {
                if (!p.getValue().profit.getValue().equals("") || !p.getValue().profit.getValue().equals("0.00")) {
                    double money = Double.parseDouble(
                            p.getValue().profit.getValue());
                    String finalMoney = df.format(money) + "/=";
                    return new SimpleObjectProperty(finalMoney);
                } else {
                    return new SimpleObjectProperty("0.00/=");
                }
            }

        });
        status_col.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<MonthlyPerformanceData, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(
                    final TableColumn.CellDataFeatures<MonthlyPerformanceData, Boolean> p) {
                if (!p.getValue().status.getValue().equals("")) {
                    double money = Double.parseDouble(
                            p.getValue().status.getValue());
                    String finalMoney = df.format(money);
                    return new SimpleObjectProperty(finalMoney+"%");
                } else {
                    return new SimpleObjectProperty("0.00%");
                }
            }

        });
        
        
        ////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////
        
        ObservableList<PatientSummaryData> monthly_performance_patients = FXCollections.observableArrayList();
        summary_patients_tbl.setItems(monthly_performance_patients);
        month_col1.setCellValueFactory(
                new PropertyValueFactory<PatientSummaryData, String>(
                        "month"));
        Patients_no_col.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<PatientSummaryData, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(
                    final TableColumn.CellDataFeatures<PatientSummaryData, Boolean> p) {
                int money = Integer.parseInt(
                        p.getValue().patient_no.getValue());
                String finalMoney = df.format(money);
                return new SimpleObjectProperty(finalMoney);
            }

        });
        patient_stats_col.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<PatientSummaryData, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(
                    final TableColumn.CellDataFeatures<PatientSummaryData, Boolean> p) {
                if (!p.getValue().patient_no_diff.getValue().equals("") || !p.getValue().patient_no_diff.getValue().equals("0.00")) {
                    double money = Double.parseDouble(
                            p.getValue().patient_no_diff.getValue());
                    String finalMoney = df.format(money) + "%";
                    return new SimpleObjectProperty(finalMoney);
                } else {
                    return new SimpleObjectProperty("0.00%");
                }
            }

        });
        avg_patient_pay.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<PatientSummaryData, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(
                    final TableColumn.CellDataFeatures<PatientSummaryData, Boolean> p) {
                if (!p.getValue().avg_pat_pay.getValue().equals("") || !p.getValue().avg_pat_pay.getValue().equals("0.00")) {
                    double money = Double.parseDouble(
                            p.getValue().avg_pat_pay.getValue());
                    String finalMoney = df.format(money) + "/=";
                    return new SimpleObjectProperty(finalMoney);
                } else {
                    return new SimpleObjectProperty("0.00/=");
                }
            }

        });
        pat_avg_pay_per_rev_col.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<PatientSummaryData, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(
                    final TableColumn.CellDataFeatures<PatientSummaryData, Boolean> p) {
                if (!p.getValue().avg_pat_pay_per_rev.getValue().equals("")) {
                    double money = Double.parseDouble(
                            p.getValue().avg_pat_pay_per_rev.getValue());
                    String finalMoney = df.format(money);
                    return new SimpleObjectProperty(finalMoney+"%");
                } else {
                    return new SimpleObjectProperty("0.00%");
                }
            }

        });
        
        ///////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        pie_chart.setData(pieChartData);
        
        ObservableList<PieChart.Data> pieChartData1 = FXCollections.observableArrayList();
        pie_graph.setData(pieChartData1);

        
        XYChart.Series series = new XYChart.Series();
        series.setName("DIOS Performance");
        line_graph.getData().add(series);
        
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("DIOS Patients Trend");
        line_chart.getData().add(series1);

        svc2.setOnSucceeded((WorkerStateEvent d) -> {
            if (!svc2.getValue().equals(svc2.getLastValue())) {
                monthly_performance_items.clear();
                pieChartData.clear();
                series.getData().clear();
                monthly_performance_patients.clear();
                pieChartData1.clear();
                series1.getData().clear();
                svc2.getValue().forEach((value) -> {
                    monthly_performance_items.add(new MonthlyPerformanceData(
                            value.get(0).substring(0, 4) + "-" + (java.time.Month.of(
                            parseInt(value.get(0).substring(4)))).toString().substring(
                            0, 3),
                            value.get(1), value.get(2), value.get(3),
                            value.get(4)));
                    monthly_performance_patients.add(new PatientSummaryData(
                            value.get(0).substring(0, 4) + "-" + (java.time.Month.of(
                            parseInt(value.get(0).substring(4)))).toString().substring(
                            0, 3),
                            value.get(5), value.get(6), value.get(7),
                            value.get(8)));
                    pieChartData.add(new PieChart.Data(
                            value.get(0).substring(0, 4) + "-" + (java.time.Month.of(
                            parseInt(value.get(0).substring(4)))).toString().substring(
                            0, 3), parseDouble(value.get(1).replaceAll(",",
                                    "").replaceAll("/=", ""))));
                    pieChartData1.add(new PieChart.Data(
                            value.get(0).substring(0, 4) + "-" + (java.time.Month.of(
                            parseInt(value.get(0).substring(4)))).toString().substring(
                            0, 3), parseDouble(value.get(5).replaceAll(",",
                                    "").replaceAll("/=", ""))));
                    series.getData().addAll(new XYChart.Data<>(
                            value.get(0).substring(0, 4) + "-" + (java.time.Month.of(
                            parseInt(value.get(0).substring(4)))).toString().substring(
                            0, 3), parseDouble(value.get(3).replaceAll(",",
                                    "").replaceAll("/=", ""))));
                    series1.getData().addAll(new XYChart.Data<>(
                            value.get(0).substring(0, 4) + "-" + (java.time.Month.of(
                            parseInt(value.get(0).substring(4)))).toString().substring(
                            0, 3), parseDouble(value.get(6).replaceAll(",",
                                    "").replaceAll("/=", ""))));
                    
                });
                
            }
        });

        svc2.start();
        svc2.restart();
        svc2.restart();
        svc2.restart();
        svc2.restart();
        svc2.restart();
        svc2.restart();
        svc2.restart();
        svc2.restart();

        revenue_tbl.setRowFactory(PI -> {
            TableRow<RevenueTblData> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    try {
                        revenue_title_lbl.setText("EDIT VISIT");
                        temp_revenue_id.setText("");
                        temp_revenue_id.setText(row.getItem().getrevenue_id());
                        patientname.clear();
                        patientname.setText(row.getItem().getpatient_name());

                        phonenumber.clear();
                        phonenumber.setText(row.getItem().getphone_number());

                        address.clear();
                        address.setText(row.getItem().getaddress());

                        condition.clear();
                        condition.setText(row.getItem().getcondition());

                        charge.clear();
                        charge.setText(row.getItem().getcharge().replaceAll(
                                "/=", ""));

                        date_of_visit.setValue(null);
                        Date dateUtil = sdf.parse(
                                row.getItem().getdate_of_visit().replaceAll(
                                        "-", "/"));
                        date_of_visit.setValue(dateUtil.toInstant().atZone(
                                ZoneId.systemDefault()).toLocalDate());

                        cancel_button.setVisible(true);
                    } catch (ParseException ex) {
                        Logger.getLogger(
                                FXMLDocumentController.class.getName()).log(
                                Level.SEVERE,
                                null, ex);
                    }
                }
            });
            svc.restart();
            svc.restart();
            svc.restart();
            svc.restart();
            
            svc2.restart();
            svc2.restart();
            svc2.restart();
            svc2.restart();
            return row;
        });

        expenses_tbl.setRowFactory(PI -> {
            TableRow<ExpenseTblData> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    try {
                        expense_title_Lbl.setText("EDIT EXPENSE");
                        temp_expense_id.setText("");
                        temp_expense_id.setText(row.getItem().getexpense_id());
                        item_txtFld.clear();
                        item_txtFld.setText(row.getItem().getitem());

                        category_TxtFld.clear();
                        category_TxtFld.setText(row.getItem().getcategory());

                        quantity_TxtFld.clear();
                        quantity_TxtFld.setText(row.getItem().getquantity());

                        rate_TxtFld.clear();
                        rate_TxtFld.setText(row.getItem().getrate().replaceAll(
                                "/=", ""));

                        paid_to_TxtFld.clear();
                        paid_to_TxtFld.setText(row.getItem().getpaid_to());

                        date_Picker.setValue(null);
                        Date dateUtil = sdf.parse(
                                row.getItem().getpaid_on().replaceAll(
                                        "-", "/"));
                        date_Picker.setValue(dateUtil.toInstant().atZone(
                                ZoneId.systemDefault()).toLocalDate());

                        cancel_expense_button.setVisible(true);
                    } catch (ParseException ex) {
                        Logger.getLogger(
                                FXMLDocumentController.class.getName()).log(
                                Level.SEVERE,
                                null, ex);
                    }
                }
            });
            svc1.restart();
            svc1.restart();
            svc2.restart();
            svc2.restart();
            return row;
        });

        cancel_button.setOnAction(p -> {
            revenue_title_lbl.setText("NEW ENTRY");
            temp_revenue_id.setText("");
            patientname.clear();
            phonenumber.clear();
            address.clear();
            condition.clear();
            charge.clear();
            date_of_visit.setValue(null);
            cancel_button.setVisible(false);
            svc.restart();
            svc.restart();
            svc2.restart();
            svc2.restart();
        });

        cancel_expense_button.setOnAction(p -> {
            expense_title_Lbl.setText("NEW ENTRY");
            temp_expense_id.setText("");
            item_txtFld.clear();
            category_TxtFld.clear();
            quantity_TxtFld.clear();
            rate_TxtFld.clear();
            paid_to_TxtFld.clear();
            date_Picker.setValue(null);
            cancel_expense_button.setVisible(false);
            svc1.restart();
            svc1.restart();
            svc2.restart();
            svc2.restart();
        });

        svc.restart();
        svc.restart();
        svc.restart();

        svc1.restart();
        svc1.restart();
        svc1.restart();

        svc2.restart();
        svc2.restart();
        svc2.restart();

    }

}
