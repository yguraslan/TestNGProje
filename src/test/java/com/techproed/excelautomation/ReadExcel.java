package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
public class ReadExcel {
    @Test
    public void test() throws IOException {
        String dosyaYolu = ".\\src\\test\\resources\\ULKELER.xlsx";
        //Java'da bir dosyayı açmak için bu kullanılır.
        // Parametre bölümüne açmak istediğimiz dosyanın adresi (dosya yolu,path) yazılır
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        // Workbook (excel) dosyasını okumaya başladık.
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // 1. sayfaya gider. (index değeri 0'dan başlar.)
        Sheet sheet       = workbook.getSheetAt(0);

        // 1. satıra gidelim. (index değeri 0'dan başlar.)
        Row row           = sheet.getRow(0);

        // 1. Hücreyi alalım. (index değeri 0'dan başlar.)
        Cell ulkeler      = row.getCell(0);
        Cell baskentler   = row.getCell(1);
        Cell meshurlar    = row.getCell(2);

        System.out.println(ulkeler);
        System.out.println(baskentler);
        System.out.println(meshurlar);

        // Excel'e Git -> Sheet 0'a git -> 3. İndexteki Satıra git -> 1. İndexteki Hücre
        System.out.println(workbook.getSheetAt(0).getRow(3).getCell(1));
        System.out.println(workbook.getSheetAt(0).getRow(7).getCell(2));
        System.out.println(workbook.getSheetAt(0).getRow(10).getCell(0));

        // Son satır(Row)'ın numarasını almak için (indexini, index 0 dan başlar)
        int satirSayisi = workbook.getSheetAt(0).getLastRowNum() + 1;
        System.out.println("Satir sayisi : " + satirSayisi);

        //Icerisinde veri olan satir sayisini almak istersek index i 1 den basliyor
        int doluSatirSayisi = workbook.getSheetAt(0).getPhysicalNumberOfRows();
        System.out.println("dolu satir sayisi :" + doluSatirSayisi);

        System.out.println("-----------");

        // tum ulkeleri yazdirdik
        int sonSatirinIndexi = workbook.getSheetAt(0).getLastRowNum();//10
        for(int i = 0 ; i <= sonSatirinIndexi ; i++){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
        }
        System.out.println("--------------");

         // tum baskentleri yazdiralim
        for(int i = 0 ; i<= sonSatirinIndexi ; i++) {
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(1));

        }
        System.out.println("--------------");

        //bir satirin son sutununun indexini alma, index 1 den basliyor
        int sonSutunIndex = workbook.getSheetAt(0).getRow(0).getLastCellNum();
        System.out.println();

        for(int k = 0; k < sonSutunIndex ; k++){
            System.out.println("4. Satır " + k +". Sütun :" + workbook.getSheetAt(0).getRow(3).getCell(k) );
        }



    }
}
