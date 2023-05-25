package Test_Layer;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base_Layer.baseClass;
import Page_Layer.facebookCreate;
import Util_package.ExcelReader;

public class facebookID extends baseClass {
	ExcelReader obj;

	@BeforeMethod

	public void setup() {
		initalization("url");
	}


	@Test(dataProvider="FacebookData")

	public void createFB(String name,String surnamee,String mobil,String npass,String da, String mont,String yea)
	{


		facebookCreate fb=new facebookCreate();
		fb.username(name);
		fb.pass(surnamee);
		fb.mobile(mobil);
		fb.newpass(npass);
		fb.dayy(da);
		fb.monthh(mont);
		fb.yearr(yea);

	}

	@AfterMethod 

	public void teardwon() {

		driver.close();

	}

	@DataProvider (name="FacebookData")

	public Object[][] getdatta()
	{
		try {
			obj=new ExcelReader(System.getProperty("user.dir")+"\\abc.xlsx");
		} catch (Exception e) {

			e.printStackTrace();
		}
		int ro=obj.lastRowCount(2);

		Object[][] data=new Object[ro][7];

		for (int i=1;i<ro;i++)
		{
			data[i][0]=obj.getData(i, 0, 2);
			data[i][1]=obj.getData(i, 1, 2);
			data[i][2]=obj.getData(i, 2, 2);
			data[i][3]=obj.getData(i, 3, 2);
			data[i][4]=obj.getData(i, 4, 2); 
			data[i][5]=obj.getData(i, 5, 2);
			data[i][6]=obj.getData(i, 6, 2);
            

		}


		return data ;


	}

}

