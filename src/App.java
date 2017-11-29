import java.io.*;
public class App {
    Store[] str=new Store[16];
    int strCtr=0;
    BufferedReader br=null;

    public void readData()
    {
        try {
            br = new BufferedReader(new FileReader("/home/shreyas/IdeaProjects/PairedComp/out/production/PairedComp/a.txt"));
            String data;
            while ((data=br.readLine()) != null)
            {
                String segements[]=data.split("\t");
                str[strCtr++]=new Store(segements[0].substring(0,segements[0].indexOf("d")+1),Double.parseDouble(segements[1]));

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public void sortData()
    {
        for (int i=0;i<strCtr;i++)
        {
            for(int j=i;j<strCtr;j++)
            {
                if (str[i].getValue() > str[j].getValue())
                {
                    Store temp=str[i];
                    str[i]=str[j];
                    str[j]=temp;
                }
            }
        }
    }

    public double getUpperCount()
    {
        double uc=0;
        int i=0;
        while(str[i].getLabel().equals(str[i+1].getLabel()))
        {

            i++;
            uc++;
            System.out.println(str[i].getLabel()+" "+str[i+1].getLabel());
        }
        return uc;
    }

    public void showData()
    {
        for(int i=0;i<strCtr;i++)
            System.out.println(str[i].getLabel()+"  "+str[i].getValue());
    }

    public static void main(String[] args) {
        App app=new App();
        app.readData();
        app.sortData();
        app.showData();
        double uc = app.getUpperCount();
    }
}
