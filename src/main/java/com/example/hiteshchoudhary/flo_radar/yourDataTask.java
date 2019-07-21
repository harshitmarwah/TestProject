package com.example.hiteshchoudhary.flo_radar;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

class yourDataTask {

    ListView tw,lv1;
    Context context;
    TextView tw1;
   private String dt1;
    public yourDataTask (Context con,ListView tw,String dt) {
        this.tw = tw;
        this.context=con;
        //this.lv1=tw1;
        dt1=dt;
        //this.textView2 = textView2;

    }
    ArrayList<String>f1=new ArrayList<String>();
    ArrayList<String>f2=new ArrayList<String>();
    ArrayList<String>f3=new ArrayList<String>();
    ArrayList<String>f4=new ArrayList<String>();
    ArrayList<String>f5=new ArrayList<String>();
    ArrayList<String>f6=new ArrayList<String>();



    protected String doInBackground(Void... params)
    {

        String str="https://thingspeak.com/channels/643783/feed.json";

        URLConnection urlConn = null;
        BufferedReader bufferedReader = null;
        try
        {
            URL url = new URL(str);
            urlConn = url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                stringBuffer.append(line);
            }
//tw.setText(stringBuffer);
            //return new JSONObject(stringBuffer.toString());*/
            // JSONObject js=new JSONObject(stringBuffer.toString());
            // JSONObject js1=new JSONObject("channel");
            //System.out.print(js);
            JSONObject js=new JSONObject(String.valueOf(stringBuffer));
            //  JSONObject js1=new JSONObject(String.valueOf(js));
            String dt=js.getString("feeds");
            JSONArray arr=js.getJSONArray("feeds");
            String[] arr1=new String[100];
            JSONObject js2;
            String str1 = "",str2=dt1;

            for(int i=0;i<arr.length();i++){
                str1=arr.getString(i);
                String str3=dt1;
               // Log.d("fsgerfab",str3);
                //Boolean s= str1.contains(dt1);

               // Log.d("Hellagfu",s.toString());
          if(str1.contains(str3)){
                    js2=arr.getJSONObject(i);
                    f5.add(js2.getString("field1"));

                    f1.add(js2.getString("field2"));
                    f2.add(js2.getString("field3"));
                    f6.add(js2.getString("field4"));
                    String[] parts=js2.getString("created_at").split("T");
                    String[]Parts1=parts[1].split("Z");
                    f4.add(Parts1[0]);
                }
//                else{
//                    Toast.makeText(context, "Wait for Sometime", Toast.LENGTH_SHORT).show();
//                }

            }
//            Calendar cal = Calendar. getInstance();
//            Date date=cal. getTime();
//            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//            String formattedDate=dateFormat. format(date);

            for(int i=0;i<f1.size();i++)
                f3.add("Flow="+f5.get(i)+" L/hour\n" +"Pressure="+f1.get(i)+" MPa\n"+"Temprature="+f2.get(i)+" Celsius\n"+"Humidity="+f6.get(i)+" %\n" + "at "+ f4.get(i));


            return str2;
        }
        catch(Exception ex)
        {
            Log.e("App", "yourDataTask", ex);
            return null;
        }
        finally
        {
            if(bufferedReader != null)
            {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    protected void onPostExecute(String  response)
    {
        if(response != null)
        {
            try {
                Log.println(1, "Hello:","Connected");
                Log.e("App", "Success: " + response );
            } catch (Exception ex) {
                Log.e("App", "Failure", ex);
            }
        }

        //    tw1.setText(f1.get(0));
        LayoutInflater layoutinflater;
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(context.getApplicationContext(), android.R.layout.simple_list_item_1,android.R.id.text1,f3){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the current item from ListView
                View view = super.getView(position,convertView,parent);
                if(position %2 == 1)
                {
                    // Set a background color for ListView regular row/item
                    view.setBackgroundColor(Color.parseColor("#b3e0ff"));
                }
                else
                {
                    // Set the background color for alternate row/item
                    view.setBackgroundColor(Color.parseColor("#e6f5ff"));
                }
                return view;
            }
        };
       // layoutinflater = getClass().getLayoutInflater();

       // ViewGroup header = (ViewGroup)layoutinflater.inflate(R.layout.item_header,tw,false);

        //tw.addHeaderView(header);
        tw.setAdapter(arrayAdapter);

      /*  ArrayAdapter<String> arrayAdapter1;
        arrayAdapter1 = new ArrayAdapter<String>(context.getApplicationContext(), android.R.layout.simple_list_item_1, f2);

        lv1.setAdapter(arrayAdapter1);
*/
        //  tw.setText(response);
        //  tw.setText(response.toString());
    }



}
