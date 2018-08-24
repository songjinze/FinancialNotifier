package ui.controller;
import javafx.scene.control.*;
import javafx.fxml.FXML;


public class SalaryManage {

    @FXML private TableView employeeList;
    @FXML private TableColumn employeeIdColumn;
    @FXML private TableColumn employeeNameColumn;
    @FXML private TableColumn employeeEmailColumn;
    @FXML private TableColumn employeeSalaryColumn;
    @FXML private Button searchButton;
    @FXML private TextField searchField;

    private SalaryManage(){}
    private static volatile SalaryManage salaryManage;
    public static SalaryManage getInstance(){
        if(salaryManage==null){
            synchronized (SalaryManage.class) {
                salaryManage = new SalaryManage();
            }
        }
        return salaryManage;
    }

    public void back(){
        // TODO
    }
    public void initList(){
        
    }

}
