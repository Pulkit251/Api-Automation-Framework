package api.utilities;

import java.io.IOException;

public class DataProvider {

    @org.testng.annotations.DataProvider(name="Data")
    public String[][] getAllData() throws IOException {
        String path = System.getProperty("user.dir") + "//Book1.xlsx";
        xlUtitlity utils = new xlUtitlity(path);

        int rown = utils.getRowCount("Sheet1");
        int coln = utils.getCellCount("Sheet1",rown);

        String[][] apidata = new String[rown][coln - 1];
        for(int i = 1;i <= rown;i++){
            for(int j = 1;j < coln;j++){
                apidata[i-1][j - 1] = utils.getCellData("Sheet1",i,j);
            }
        }

        return apidata;
    }

    @org.testng.annotations.DataProvider(name="usernames")
    public String[] getUserNames() throws IOException {
        String path = System.getProperty("user.dir") + "//Book1.xlsx";
        xlUtitlity utils = new xlUtitlity(path);

        int rown = utils.getRowCount("Sheet1");

        String[] apiData = new String[rown];

        for(int i = 1;i <= rown;i++){
            apiData[i - 1] = utils.getCellData("Sheet1",i,1);
        }

        return apiData;
    }



}
