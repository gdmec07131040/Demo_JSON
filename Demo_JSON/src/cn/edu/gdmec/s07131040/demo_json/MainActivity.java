package cn.edu.gdmec.s07131040.demo_json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//        JSONObject person=new JSONObject();
//        
//        try {
//			person.put("name", "zhangsan");
//			person.put("age", 18);
//			
//			JSONArray phones = new JSONArray();
//			phones.put("1234567").put("7654321");
//			
//			person.put("phones", phones);
//			
//			String jsonData=person.toString();
//			
//			
//			Log.i("info",jsonData );
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
        String s=null;
        
        try {
        	
        	JSONStringer jsonStringer = new JSONStringer();
			jsonStringer.object();
			jsonStringer.key("name").value("lisi"); 
			jsonStringer.key("age").value(18);
			
			jsonStringer.key("phones");
			
			jsonStringer.array();
			
			jsonStringer.value("1111111").value("2222222");
			
			jsonStringer.endArray();
			
			jsonStringer.endObject();
			
			
			s=jsonStringer.toString();
			
			
			Log.i("info", s);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        try {
			JSONObject person = new JSONObject(s);
			String name=person.getString("name");
			int age=person.getInt("age");
			
			JSONArray phones=person.getJSONArray("phones");
			String phone1=phones.getString(0);
			String phone2=phones.getString(1);
			List<String> numbers = new ArrayList<String>();
			numbers.add(phone1);
			numbers.add(phone2);
			
			Person p=new Person(name,age,numbers);
			
			
			Log.i("info","生成的JAVA对象：" +p.toString());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
