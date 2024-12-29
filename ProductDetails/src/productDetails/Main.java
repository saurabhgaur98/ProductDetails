//Filename: Prod_Project1.java 
/*

File Handling project to Handle Product Data
==============================================


Record Handling
to store 

pno (int)
pname (String or UTF)
rate (Double)
qty (Double)
cost (Double)


To Write data:
===============
int value use: object.writeInt(variable);
Text value use:object.writeUTF(variable);
Double value use: object.writeDouble(variable);

To Read Data
=============
for int value : variable=object.readInt();
for Text value: variable=object.readUTF();
for double value : variable=object.readDouble();

Menu driven program for
(1). adding a record
(2). display all the records
(3). display all the records one by one
(4) search a record by roll no
(5). search a record by name
(6). exit

*/
package productDetails;

import java.lang.*;
import java.io.*;

class Main
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int pno;
	String pname;
	double rate,qty,cost;

	void write()
	{
		//file to store the data is "prod"
		try
		{
			DataOutputStream obj=new DataOutputStream(new
				BufferedOutputStream(new FileOutputStream("prod",true)));
			// if true is given then it opens the file in "append" mode
			// if true is not given then the file is opened in "output" mode
			System.out.print("Enter pno ");
			pno=Integer.parseInt(br.readLine());
			obj.writeInt(pno); //pno
			System.out.print("Enter product name ");
			pname=br.readLine();
			obj.writeUTF(pname);//pname
			System.out.print("Enter product rate ");
			rate=Double.parseDouble(br.readLine());
			obj.writeDouble(rate);//rate
			qty=Double.parseDouble(br.readLine());
			obj.writeDouble(qty);//qty
			cost=rate*qty;
			obj.writeDouble(cost);//cost

		    obj.close();
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e);
		}
	}
	
	void read()
	{
		char ch;
		try
		{
		DataInputStream in=new DataInputStream(new BufferedInputStream
			(new FileInputStream("prod")));

			System.out.println("Product detials are from file prod");
			do
			{
				pno=in.readInt();
				pname=in.readUTF();
				rate=in.readDouble();
				qty=in.readDouble();
				cost=in.readDouble();
				//System.out.println("   "+ pno+ "       " + pname + "        "+rate+"    "+qty+"    "+cost );

			System.out.println("Product no " + pno);
			System.out.println("Product Name " +pname);
			System.out.println("Rate " +rate );
			System.out.println("Qty " +qty );
			System.out.println("Cost " +cost );
			System.out.print("\n\n\nLike to read more (y/n) : ");
			ch=br.readLine().charAt(0);
			}while(ch=='y' || ch=='Y');
			in.close();
		}
		catch(EOFException e)
		{
		System.out.println("End of file reached");
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e);
		}
	}
	
	void disp_all()
		{
			//char ch;
			try
			{
				DataInputStream in=new DataInputStream(new
					BufferedInputStream(new FileInputStream("prod")));
				System.out.println("Product detials are from file prod");
			    System.out.println("==============================================");
				System.out.println("   pno      pname      rate  qty   cost");
				System.out.println("==============================================");
				while(true)
				{
				pno=in.readInt();
				pname=in.readUTF();
				rate=in.readDouble();
				qty=in.readDouble();
				cost=in.readDouble();
				System.out.println("   "+ pno+ "       " + pname + "        "+rate+"    "+qty+"    "+cost );
				}
			//	in.close();
			}
			catch(EOFException e)
			{
				System.out.println("==============================================");
			System.out.println("End of file reached");
			}
			catch(Exception e)
			{
				System.out.println("Error : "+e);
			}
	}
	
	void searchbypno()
	{
		char ch;
		int tr,z=0;
		try
		{
			DataInputStream in=new DataInputStream(new
				BufferedInputStream(new FileInputStream("prod")));
			System.out.print("Enter product no to search  ");
			tr=Integer.parseInt(br.readLine());

				System.out.println("Product detials are from file prod");
			    System.out.println("==============================================");
				System.out.println("   pno      pname      rate  qty   cost");
				System.out.println("==============================================");
			while(true)
			{
				pno=in.readInt();
				pname=in.readUTF();
				rate=in.readDouble();
				qty=in.readDouble();
				cost=in.readDouble();
				if(tr==pno)
				{
					z=1;
				System.out.println("   "+ pno+ "       " + pname + "        "+rate+"    "+qty+"    "+cost );
				//break;

				}
			}
			//	in.close();
			}
			catch(EOFException e)
			{
				System.out.println("==============================================");
				if(z==0)
				System.out.println("Rec not found");
				System.out.println("End of file reached");


			}
			catch(Exception e)
			{
				System.out.println("Error : "+e);
			}
	}//search
	
	
	void searchbyname()
	{
		char ch;
		int z=0;
		String tn;
		try
		{
			DataInputStream in=new DataInputStream
				(new BufferedInputStream(new FileInputStream("prod")));
			System.out.print("Enter Product Name to search ");
			tn=br.readLine();

				System.out.println("Product detials are from file prod");
			    System.out.println("==============================================");
				System.out.println("   pno      pname      rate  qty   cost");
				System.out.println("==============================================");
			while(true)
			{
				pno=in.readInt();
				pname=in.readUTF();
				rate=in.readDouble();
				qty=in.readDouble();
				cost=in.readDouble();
				if(tn.equals(pname))
				{
					z=1;
				System.out.println("   "+ pno+ "       " + pname + "        "+rate+"    "+qty+"    "+cost );
				}

			//	in.close();
			}
		}
		catch(EOFException e)
		{
			System.out.println("==============================================");
			if(z==0)
			System.out.println("Rec not found");
			System.out.println("End of file reached");
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e);
		}
	}//searchbyname

		
	public static void main(String args[])
	{
		//filedata3 f=new filedata3();
		Main f=new Main();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int op=0;
		try
		{
			while(op!=6)
			{
				System.out.println("main Menu");
				System.out.println("==========");
				System.out.println("1. Add Product Record ");
				System.out.println("2. Display records one by one");
				System.out.println("3. Display All record");
				System.out.println("4. Search by Product No");
				System.out.println("5. Search by Product Name");
				System.out.println("6. Exit");
				System.out.println("Enter your choice  ");

				op=Integer.parseInt(br.readLine());
				switch(op)
				{
					case 1:
						f.write();
						break;
					case 2:
						f.read();
						break;
					case 3:
						f.disp_all();
						break;
					case 4:
						f.searchbypno();
						break;
					case 5:
						f.searchbyname();
						break;
					case 6:
						System.out.println("end of program");
						break;
					default:
						System.out.println("Invalid choice");
						break;
				}//switch
			}//while
		}//try
		catch(Exception e){}
	}//main
}//class