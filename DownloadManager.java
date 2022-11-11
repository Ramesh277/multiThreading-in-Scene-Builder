package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.example.config.AppConfig;
import org.example.models.FileInfo;

import java.io.File;

public class DownloadManager {

    @FXML
    private TableView<FileInfo> tableview;

    @FXML
    private TextField urlTextField;

    public  int index = 0;

    @FXML
    void downloadButtonClicked(ActionEvent event) {
       String url = urlTextField.getText().trim();
       String filename = url.substring(url.lastIndexOf("/")+1);
       String status = "STARTING";
       String action = "OPEN";
       String path = AppConfig.DOWNLOAD_PATH+ File.separator+filename;
       FileInfo file = new FileInfo((index+1)+"",filename,url, status,action,  path);
       this.index = this.index+1;
       DownloadThread thread = new DownloadThread(file, this);
       this.tableview.getItems().add(Integer.parseInt(file.getIndex())-1,file);
       thread.start();

    }

    public void   updateUI(FileInfo metaFile) {
        System.out.println(metaFile);

        FileInfo fileInfo = this.tableview.getItems().get(Integer.parseInt(metaFile.getIndex()) - 1);
        fileInfo.setStatus(metaFile.getStatus());
        fileInfo.setStatus(metaFile.getStatus());
        this.tableview.refresh();

        System.out.println(" ,,,,,,,,,,,,,,,,,,,,,,");
    }

    @FXML
    public void initialize(){
        System.out.println("view initialize.....");


        TableColumn<FileInfo, String> sn = (TableColumn<FileInfo, String>) this.tableview.getColumns().get(0);
        sn.setCellValueFactory(p->{
            return p.getValue().indexProperty();
        });

        TableColumn<FileInfo, String> filename = (TableColumn<FileInfo, String>) this.tableview.getColumns().get(1);
        filename.setCellValueFactory(p->{
            return p.getValue().nameProperty();
        });

        TableColumn<FileInfo, String> url = (TableColumn<FileInfo, String>) this.tableview.getColumns().get(2);
        url.setCellValueFactory(p->{
            return p.getValue().urlProperty();
        });

        TableColumn<FileInfo, String> status = (TableColumn<FileInfo, String>) this.tableview.getColumns().get(3);
       status.setCellValueFactory(p->{
            return p.getValue().urlProperty();
        });

       TableColumn<FileInfo, String> action = (TableColumn<FileInfo, String>) this.tableview.getColumns().get(4);
       action.setCellValueFactory(p->{
            return p.getValue().urlProperty();
        });

    }


}
