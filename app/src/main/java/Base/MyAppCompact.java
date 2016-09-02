package Base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import db.DBHelper;

/**
 * Created by Komal UETian on 8/30/2016.
 */
public class MyAppCompact extends AppCompatActivity {

    public static DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DBHelper(this);
    }

}
