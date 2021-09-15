import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Lab2.R;
import com.example.Lab2.DataActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void modifyData( View v ) {
        Intent intent = new Intent(v, DataActivity.class);
        this.startActivity(intent);
    }
}